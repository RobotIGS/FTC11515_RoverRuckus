package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.DistanceTools;
import org.firstinspires.ftc.teamcode.Tools.FarbHelfer;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;

/**
 * @author paul, lena
 * This class lets the robot drive until he detects a wall with his distance sensors
 */
@Deprecated
@Disabled
@TeleOp(name = "Distance")
public class DriveToWall extends OpMode {
    private final double wallDistanceHut = 6.5;
    private DistanceSensor distanceSensorLinks;
    private DistanceSensor distanceSensorRechts;
    private DistanceTools distanceTools;
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;
    private FarbHelfer farbHelfer;
    private Tools tools;

    @Override
    public void init() {
        distanceSensorLinks = hardwareMap.get(DistanceSensor.class, "color_distance");
        distanceSensorRechts = hardwareMap.get(DistanceSensor.class, "color_distance");
        tools = new Tools();
        hwChss = new HardwareChassisSun(hardwareMap);
        motorStuff = new MotorStuff(hwChss, hardwareMap);
        distanceTools = new DistanceTools(motorStuff, hwChss, tools );
        farbHelfer = new FarbHelfer();
    }

    @Override
    public void loop() {
        telemetry.addData("distance", distanceSensorLinks.getDistance(DistanceUnit.MM));
        telemetry.addData("distance", distanceSensorRechts.getDistance(DistanceUnit.MM));
        telemetry.update();

        while (isNaN(distanceSensorLinks.getDistance(DistanceUnit.MM)) && isNaN(distanceSensorRechts.getDistance(DistanceUnit.MM))) {
            motorStuff.driveInOneDirection(0.2,0.2);
            telemetry.addData("distance", distanceSensorLinks.getDistance(DistanceUnit.MM));
            telemetry.addData("distance", distanceSensorRechts.getDistance(DistanceUnit.MM));
            telemetry.update();

        }

        if (isNaN(distanceSensorRechts.getDistance(DistanceUnit.MM))) {

            while (isNaN(distanceSensorRechts.getDistance(DistanceUnit.MM))) {
                hwChss.motor_back_right.setPower(0.2);
                hwChss.motor_back_left.setPower(0.2);
            }
        } else if (isNaN(distanceSensorLinks.getDistance(DistanceUnit.MM))) {

            while (isNaN(distanceSensorLinks.getDistance(DistanceUnit.MM))) {
                hwChss.motor_back_right.setPower(-0.2);
                hwChss.motor_back_left.setPower(-0.2);
            }
        }



    }
    public void followWallBlue() {
        motorStuff.turnToDegreeV4((float) (360-22.5));

        while(!farbHelfer.isBlue(hwChss.color_back_right)){
            if(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) < wallDistanceHut ){
                motorStuff.setAllMotors(0.2, -0.2,0.2,-0.2);
            }
            if (triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) >= wallDistanceHut || distanceTools.isNaN(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.2,0.2,0.2,0.2);
            } else {
                motorStuff.setAllMotors(0.2, 0,0.2,0);
            }
        }
    }

    private  double triDist(double i){
        return Math.cos(Math.toDegrees(45))*i;
    }


    //Detects whether a number is Nan (Not a Number)
    boolean isNaN (double zahlx){
        if (zahlx == zahlx){
            return false;
        } else {
            return true;
        }
    }
}
