package org.firstinspires.ftc.teamcode;

import android.drm.DrmInfoRequest;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldAlignDetector;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.DistanceTools;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp (name = "TestAutonomous")

public class TestAutonomous extends LinearOpMode {
    private GoldAlignDetector detector;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "DogeCV 2018.0 - Gold Align Example");

        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        DistanceTools distanceTools = new DistanceTools();
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap);
        distanceTools.setHwChss(hwChss);
        distanceTools.setMotorStuff(motorStuff);

        detector = new GoldAlignDetector(); // Cr

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


        motorStuff.setAllMotors(0.2,0,0.2,0);

        long time  = System.currentTimeMillis();
        while (System.currentTimeMillis() < time+1000) { }

        motorStuff.setAllMotors(0,0,0,0);

        boolean isGold = detector.isFound();
        telemetry.addData("Is Gold: " ,isGold);
        telemetry.update();
        if (isGold) { //Middle
            motorStuff.setAllMotors(0.2,0,0.2,0);

            time  = System.currentTimeMillis();
            while (System.currentTimeMillis() < time+2500) { }

            motorStuff.setAllMotors(0,0,0,0);

        } else {
            motorStuff.turnToDegreeV4(45 / 2); //Right
            time  = System.currentTimeMillis();
            while (System.currentTimeMillis() < time+1000) { }
            if(detector.isFound()){
                distanceTools.driveToWall(Direction.RIGHT);
            }
            else {
                motorStuff.turnToDegreeV4(360-45); //Left
                motorStuff.setAllMotors(0.2, 0, 0.2, 0);

                time  = System.currentTimeMillis();
                while (System.currentTimeMillis() < time+1000) { }
                distanceTools.driveToWall(Direction.LEFT);

            }
        }


    }

}
