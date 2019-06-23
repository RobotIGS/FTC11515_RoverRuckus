package org.firstinspires.ftc.teamcode.AutonomousPrograms;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisIdeenExpo;
import org.firstinspires.ftc.teamcode.Tools.MotorStuffExpo;
import org.firstinspires.ftc.teamcode.Tools.Tools;

@Autonomous (name = "AutonomWettkampg")
public class SamplingCode extends LinearOpMode {

    private final double driveSpeed = 0.5;
    private final int degreeRight = 45; //todo
    private final int degreeLeft = 45; //37

    private GoldAlignDetector detector;
    private HardwareChassisIdeenExpo robot;
    private MotorStuffExpo motorStuffExpo;
    private Tools t = new Tools(this);
    @Override
    public void runOpMode() {


        robot = new HardwareChassisIdeenExpo(hardwareMap);
        motorStuffExpo = new MotorStuffExpo(robot, hardwareMap, this);

        initDetector();

        waitForStart();

        motorStuffExpo.driveInOneDirection( 0.4,0.4);
        t.stopForMilliSeconds(2000);
        motorStuffExpo.setAllMotors(0,0,0,0);

        t.stopForMilliSeconds(100);
        telemetry.addData("Hey", true);
        telemetry.update();
        //Sampling
        //Sees middle mineral. Checks whether is't gold or not.

        boolean isGold = detector.isFound();
        if (isGold  && !isStopRequested()) { //Middle

            //Drives forward a lot
            motorStuffExpo.driveInOneDirection(driveSpeed, driveSpeed);
            t.stopForMilliSeconds(2000);

        } else if (!isStopRequested()) { //Mineral is left or right
           motorStuffExpo.turnToDegreeV4(degreeRight); //Turns to the right
            //Waits one second to ensure that the robot has turned completly
            t.stopForMilliSeconds(100);
            if(detector.isFound() && !isStopRequested()){ //Mineral is right
                motorStuffExpo.driveInOneDirection(driveSpeed, driveSpeed);
                t.stopForMilliSeconds(2000);

            }
            else if (!isStopRequested()) {
                motorStuffExpo.turnToDegreeV4(360-(degreeRight + degreeLeft)); //Left
                motorStuffExpo.driveInOneDirection(driveSpeed, driveSpeed);
                t.stopForMilliSeconds(2000);
                motorStuffExpo.setAllMotors(0,0,0,0);

            }
        }
    }

    private void initDetector() {
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

    }

}
