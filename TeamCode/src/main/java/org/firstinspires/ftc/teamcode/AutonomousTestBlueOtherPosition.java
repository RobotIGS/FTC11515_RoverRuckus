package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.Direction_Enum;
import org.firstinspires.ftc.teamcode.Tools.DistanceTools;
import org.firstinspires.ftc.teamcode.Tools.FarbHelfer;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;

/*
 * Our actual approach to the autonomous period.
 * Works for blue side, right position
 */
@TeleOp (name = "AutonomousBlueOtherPosition")
public class AutonomousTestBlueOtherPosition extends LinearOpMode {

    private GoldAlignDetector detector; //Recognizes golden mineral

    @Override
    public void runOpMode() {

        //Init
        Tools tools = new Tools();
        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap);
        DistanceTools distanceTools = new DistanceTools(motorStuff, hwChss, tools);

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

        //Drives forward a certain amount of time
        motorStuff.setAllMotors(0.2,0,0.2,0);
        tools.stopForSeconds(1500); //Time to drive forward first time
        motorStuff.setAllMotors(0,0,0,0);

        //Sees middle mineral. Checks whether is't gold or not.
        boolean isGold = detector.isFound();
        telemetry.addData("Is Gold: " ,isGold);
        telemetry.update();
        if (isGold) { //Middle

            //Drive forward two seconds
            motorStuff.setAllMotors(0.2,0,0.2,0);
            tools.stopForSeconds(1500);

            motorStuff.setAllMotors(-0.2,0,-0.2,0);
            tools.stopForSeconds(1000);
            motorStuff.setAllMotors(0,0,0,0);

        } else { //Mineral is left or right
            motorStuff.turnToDegreeV4(45); //Turns to the right todo changed from 22
            //Waits one second to ensure that the robot has turned completely

            tools.stopForSeconds(1000);
            if(detector.isFound()){ //Gold mineral is on the right side


                //Drive forward two seconds to push away the mineral
                motorStuff.setAllMotors(0.2,0,0.2,0);
                tools.stopForSeconds(2000); //todo 2500

                //Drive backward additional time

                motorStuff.setAllMotors(-0.2,0,-0.2,0);
                tools.stopForSeconds(2000);

                motorStuff.turnToDegreeV4(360-45); //Changed from 360 - 22

                //waits additional second
                tools.stopForSeconds(1000);

            }
            else { //Same for the left side
                motorStuff.turnToDegreeV4(360-90); //Left

                //Drive forward two seconds
                motorStuff.setAllMotors(0.2,0,0.2,0);
                tools.stopForSeconds(2000);

                motorStuff.setAllMotors(-0.2,0,-0.2,0);
                tools.stopForSeconds(1000);

                //waits additional second
                tools.stopForSeconds(1000);

                motorStuff.turnToDegreeV4(22); //Changed

                //waits additional second
                tools.stopForSeconds(1000);
            }
        }
        //It doesn't matter, if the mineral was left, right or in the center.
        //This is independent from the the if else statement above.
        //It will drive until one sensor registers the wall, then follow the wall. 
        distanceTools.driveToWall(Direction_Enum.BlueCrater);
        motorStuff.followWallBlue();


    }

}
