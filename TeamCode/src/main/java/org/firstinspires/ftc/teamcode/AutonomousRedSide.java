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
 *
 * 22.02.19 Please don't touch. This should work, but need's to be tested again
 */
@TeleOp (name = "AutonomousRedSide")
public class AutonomousRedSide extends LinearOpMode {

    private GoldAlignDetector detector; //Recognizes golden mineral
    private FarbHelfer redline; //Recognizes blue line
    private Tools tools;

    private final int degreeRight = 37;
    private final int degreeLeft = 37;


    @Override
    public void runOpMode() {

        //Init

        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap);
        tools = new Tools();

        DistanceTools distanceTools = new DistanceTools(motorStuff, hwChss, tools);

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

        //Drives forward a certain amount of time
        motorStuff.setAllMotors(0.2,0,0.2,0);
        tools.stopForMilliSeconds(1500);
        motorStuff.setAllMotors(0,0,0,0);

        tools.stopForMilliSeconds(1000);
        //Sees middle mineral. Checks whether is't gold or not.
        boolean isGold = detector.isFound();
        telemetry.addData("Is Gold: " ,isGold);
        telemetry.update();
        if (isGold) { //Middle

            //Drive forward to seconds
            motorStuff.setAllMotors(0.2,0,0.2,0);
            tools.stopForMilliSeconds(2000);
            //Drive until a blue line is registered (robot is in the marker zone)
            while ((!redline.isRed(hwChss.color_back_right)) && (!redline.isRed(hwChss.color_back_right))) {
                motorStuff.setAllMotors(0.2,0,0.2,0);
            }

            motorStuff.setAllMotors(0,0,0,0);
        } else { //Mineral is left or right
            motorStuff.turnToDegreeV4(degreeRight); //Turns to the right
            //Waits one second to ensure that the robot has turned completly
            tools.stopForMilliSeconds(1000);
            if(detector.isFound()){ //Mineral is right
                distanceTools.driveToWall(Direction_Enum.Right);

                //waits additional second
                tools.stopForMilliSeconds(1000);

                motorStuff.setAllMotors(0,0,0,0);
                distanceTools.followWallRedWithoutTurnRightSide(motorStuff.getDegree());
            }
            else { //Same for the left side
                motorStuff.turnToDegreeV4(360-(degreeRight + degreeLeft)); //Left
                motorStuff.setAllMotors(0.2, 0, 0.2, 0);

                tools.stopForMilliSeconds(1000);
                distanceTools.driveToWall(Direction_Enum.Left);

                //Waits additional second
                tools.stopForMilliSeconds(1000);
                //Drives from the wall to the marker zone.
                motorStuff.setAllMotors(0,0,0,0);
                distanceTools.followWallRedWithoutTurnLeft(motorStuff.getDegree());

            }
        }


    }

}
