package org.firstinspires.ftc.teamcode.AutonomousPrograms;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.Direction_Enum;
import org.firstinspires.ftc.teamcode.Tools.DistanceAlternativeTools;
import org.firstinspires.ftc.teamcode.Tools.FarbHelfer;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;

@Disabled
@Autonomous (name = "BackUpAutonomusBlueCrater")
public class AutonomusBlueCraterBackUp extends LinearOpMode {

    private final int timeDriveForward = 2345;
    private final int timeDriveBackward = 1300;
    private final float degreeRight = 37;
    private final float degreeLeft = 37;
    private GoldAlignDetector detector; //Recognizes golden mineral
    private FarbHelfer blueline;


    @Override
    public void runOpMode() {

        //Init
        Tools tools = new Tools(this);
        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap, this);
        DistanceAlternativeTools distanceTools = new DistanceAlternativeTools(motorStuff, hwChss, tools, this);

        detector = new GoldAlignDetector();
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance()); // Initialize it with the app context and camera

        detector.useDefaults(); // Set detector to use default settings

        // Optional tuning
        detector.alignSize = 100; // How wide (in pixels) is the range in which the gold object will be aligned. (Represented by green bars in the preview)
        detector.alignPosOffset = 0; // How far from center frame to offset this alignment zone.
        detector.downscale = 0.4; // How much to downscale the input frames

        detector.areaScoringMethod = DogeCV.AreaScoringMethod.PERFECT_AREA; // Can also be PERFECT_AREA
        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
        detector.maxAreaScorer.weight = 0.005; //


        detector.ratioScorer.weight = 5; //
        detector.ratioScorer.perfectRatio = 1.0; // Ratio adjustment

        detector.enable(); // Start the detector!

        blueline = new FarbHelfer();

        waitForStart();

        //Drives forward a certain amount of time
        motorStuff.setAllMotors(0.2,0,0.2,0);
        tools.stopForMilliSeconds(1500); //Time to drive forward first time
        motorStuff.setAllMotors(0,0,0,0);

        //Sees middle mineral. Checks whether it's gold or not.
        boolean isGold = detector.isFound();
        telemetry.addData("Is Gold: " ,isGold);
        telemetry.addData("Where: ", detector.getXPosition());
        telemetry.update();
        tools.stopForMilliSeconds(1000);
        if (isGold && !isStopRequested()) { //Middle

            //Drive forward two seconds
            motorStuff.setAllMotors(0.2,0,0.2,0);
            tools.stopForMilliSeconds(2000);

            motorStuff.setAllMotors(-0.2,0,-0.2,0);
            tools.stopForMilliSeconds(1000);
            motorStuff.setAllMotors(0,0,0,0);

        } else if (!isStopRequested()){ //Mineral is left or right
            motorStuff.turnToDegreeV4(degreeRight); //Turns to the right todo changed from 22
            //Waits one second to ensure that the robot has turned completely

            tools.stopForMilliSeconds(1000);
            if(detector.isFound() && !isStopRequested()) { //Gold mineral is on the right side
                telemetry.addData("Where: ", detector.getXPosition());
                telemetry.update();
                tools.stopForMilliSeconds(1000);

                //Drive forward two seconds to push away the mineral
                motorStuff.setAllMotors(0.2,0,0.2,0);
                tools.stopForMilliSeconds(timeDriveForward); //todo 2500

                //Drive backward additional time

                motorStuff.setAllMotors(-0.2,0,-0.2,0);
                tools.stopForMilliSeconds(timeDriveBackward);

                motorStuff.turnToDegreeV4(360-degreeRight); //Changed from 360 - 22

                //waits additional second
                tools.stopForMilliSeconds(1000);

            }
            else if (!isStopRequested()){ //Same for the left side
                telemetry.addData("Where: ", detector.getXPosition());
                telemetry.update();
                tools.stopForMilliSeconds(1000);
                motorStuff.turnToDegreeV4(360 - (degreeLeft + degreeRight)); //Left

                //Drive forward two seconds
                motorStuff.setAllMotors(0.2,0,0.2,0);
                tools.stopForMilliSeconds(timeDriveForward);

                motorStuff.setAllMotors(-0.2,0,-0.2,0);
                tools.stopForMilliSeconds(timeDriveBackward);

                motorStuff.turnToDegreeV4(30); //Changed

                //waits additional second
                tools.stopForMilliSeconds(1000);
            }
        }
        //It doesn't matter, if the mineral was left, right or in the center.
        //This is independent from the the if else statement above.
        //It will drive until one sensor registers the wall, then follow the wall.
        //todo distanceTools.driveToWall(Direction_Enum.Crater);

        distanceTools.driveBackFromWall(Direction_Enum.Crater);

        while ((!blueline.isBlue(hwChss.color_back_right))&& !isStopRequested()) {
            motorStuff.setAllMotors(0,-0.2,0,-0.2);
        }
        motorStuff.setAllMotors(0,0,0,0);
    }
}
