package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

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
    private FarbHelfer blueline; //Recognizes blue line


    @Override
    public void runOpMode() {

        Servo servoCam;
        //Init

        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap);
        DistanceTools distanceTools = new DistanceTools(motorStuff, hwChss);
        Tools tools = new Tools();

        blueline = new FarbHelfer();

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

        servoCam = hardwareMap.servo.get("front_cam_motion");
        servoCam = hardwareMap.get(Servo.class, "front_cam_motion");
        //servoCam.setDirection(Servo.Direction.FORWARD);


        //Drives forward a certain amount of time
        motorStuff.setAllMotors(0.2,0,0.2,0);
        long time  = System.currentTimeMillis();
        tools.stopForSeconds(2000);
        motorStuff.setAllMotors(0,0,0,0);

        //Sees middle mineral. Checks whether is't gold or not.
        boolean isGold = detector.isFound();
        telemetry.addData("Is Gold: " ,isGold);
        telemetry.update();
        if (isGold) { //Middle

            //Drive forward two seconds
            motorStuff.setAllMotors(0.2,0,0.2,0);
            tools.stopForSeconds(2000);

            motorStuff.setAllMotors(-0.2,0,-0.2,0);
            tools.stopForSeconds(1000);
            motorStuff.setAllMotors(0,0,0,0);

            //drive to wall
            distanceTools.driveToWall(Direction_Enum.BlueCrater);

            //waits additional seconds
            tools.stopForSeconds(1000);
            tools.driveLeftToBlueLine(hwChss.color_back_right, blueline, motorStuff);
        } else { //Mineral is right
            motorStuff.turnToDegreeV4(22); //Turns to the right
            //Waits one second to ensure that the robot has turned completly
            time  = System.currentTimeMillis();
            tools.stopForSeconds(1000);
            if(detector.isFound()){ //Gold mineral is on the right side


                //Drive forward two seconds to push away the mineral
                motorStuff.setAllMotors(0.2,0,0.2,0);
                time = System.currentTimeMillis();
                while ((System.currentTimeMillis() < time+2500)) {
                    motorStuff.setAllMotors(0.2,0,0.2,0);
                }

                //Drive backward additional time
                time = System.currentTimeMillis();
                while ((System.currentTimeMillis() < time+1000)) {
                    motorStuff.setAllMotors(-0.2,0,-0.2,0);
                }

                //waits additional seconds
                tools.stopForSeconds(1000);

                motorStuff.turnToDegreeV4(360-22);

                //waits additional second
                tools.stopForSeconds(1000);

                //drive to wall
                distanceTools.driveToWall(Direction_Enum.BlueCrater);

                tools.driveLeftToBlueLine(hwChss.color_back_right, blueline, motorStuff);

            }
            else { //Same for the left side
                motorStuff.turnToDegreeV4(360-45); //Left

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

                //drive to wall
                distanceTools.driveToWall(Direction_Enum.BlueCrater);

                tools.driveLeftToBlueLine(hwChss.color_back_right, blueline, motorStuff);
                motorStuff.setAllMotors(0,0,0,0);

            }
        }


    }

}
