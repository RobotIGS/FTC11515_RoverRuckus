package org.firstinspires.ftc.teamcode.AutonomousPrograms;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.Color_Enum;
import org.firstinspires.ftc.teamcode.Tools.Direction_Enum;
import org.firstinspires.ftc.teamcode.Tools.DistanceAlternativeTools;
import org.firstinspires.ftc.teamcode.Tools.DistanceTools;
import org.firstinspires.ftc.teamcode.Tools.FarbHelfer;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;

@Disabled
@Autonomous (name = "AutonomousSampling")
public class AutonomousSampling extends LinearOpMode {
    private GoldAlignDetector detector; //Recognizes golden mineral
    private FarbHelfer redline; //Recognizes blue line
    private Tools tools;

    private final int degreeRight = 45; //todo
    private final int degreeLeft = 29; //37

    private final double driveSpeed = 0.4;

    private DistanceAlternativeTools alternativeTools;

    @Override
    public void runOpMode() {

        //Init

        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap, this);
        tools = new Tools(this);

        DistanceTools distanceTools = new DistanceTools(motorStuff, hwChss, tools, this);

        alternativeTools = new DistanceAlternativeTools(motorStuff, hwChss, tools, this);
        redline = new FarbHelfer();

        detector = new GoldAlignDetector();
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance()); // Initialize it with the app context and camera

        detector.useDefaults(); // Set detector to use default settings

        // Optional tuning
        detector.alignSize = 100; // How wide (in pixels) is the range in which the gold object will be aligned. (Represented by green bars in the preview)
        detector.alignPosOffset = 0; // How far from center frame to offset this alignment zone.
        detector.downscale = 0.4; // How much to downscale the input frames

        detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
        detector.maxAreaScorer.weight = 0.005; //

        detector.ratioScorer.weight = 5; //
        detector.ratioScorer.perfectRatio = 1.0; // Ratio adjustment

        detector.enable(); // Start the detector!


        waitForStart();

        //Start of autonomous code

        //Move motor up, to unlock gear
        hwChss.motor_pull.setPower(-0.8);
        tools.stopForMilliSeconds(500); //todo 750

        //WHile robot not on ground, let robot down.
        float backUpTime = System.currentTimeMillis();
        while (((hwChss.distance_back_right.getDistance(DistanceUnit.MM) > 180 ) || distanceTools.isNaN(hwChss.distance_back_right.getDistance(DistanceUnit.MM)))&& !isStopRequested()) {
            hwChss.motor_pull.setPower(0.5);
            if (System.currentTimeMillis() > backUpTime + 5000) { //Backup, if robot doens't come down
                hwChss.motor_pull.setPower(0);
                requestOpModeStop();
            }
        }
        //Let robot go down freely
        hwChss.motor_pull.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        hwChss.motor_pull.setPower(0);

        hwChss.motor_pull.setPower(0.3);
        tools.stopForMilliSeconds(200);
        hwChss.motor_pull.setPower(0);
        //drive right additional seconds

        motorStuff.driveRight(0.4,0.4);
        tools.stopForMilliSeconds(500);
        motorStuff.setAllMotors(0,0,0,0);
        //drive forward additional seconds
        motorStuff.driveInOneDirection(0.4,0.4);
        tools.stopForMilliSeconds(1500);
        motorStuff.setAllMotors(0,0,0,0);
        //drive left additional seconds
        motorStuff.driveLeft(0.4,0.4);
        tools.stopForMilliSeconds(400);
        motorStuff.setAllMotors(0,0,0,0);

        tools.stopForMilliSeconds(100);

        //Sampling
        //Sees middle mineral. Checks whether is't gold or not.


        boolean isGold = detector.isFound();
        if (isGold  && !isStopRequested()) { //Middle

            //Drives forward a lot
            motorStuff.setAllMotors(driveSpeed,0,driveSpeed,0);
            tools.stopForMilliSeconds(2000);

        } else if (!isStopRequested()) { //Mineral is left or right
            motorStuff.turnToDegreeV4(degreeRight); //Turns to the right
            //Waits one second to ensure that the robot has turned completly
            tools.stopForMilliSeconds(100);
            if(detector.isFound() && !isStopRequested()){ //Mineral is right
                motorStuff.setAllMotors(driveSpeed,0,driveSpeed,0);
                tools.stopForMilliSeconds(2000);

            }
            else if (!isStopRequested()) {
                motorStuff.turnToDegreeV4(360-(degreeRight + degreeLeft)); //Left
                motorStuff.setAllMotors(driveSpeed, 0, driveSpeed, 0);

                motorStuff.setAllMotors(driveSpeed,0,driveSpeed,0);
                tools.stopForMilliSeconds(2000);
                motorStuff.setAllMotors(0,0,0,0);

            }
        }


    }

}
