package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp(name = "Distance")
public class TestDistanceSensor extends OpMode {
    DistanceSensor distanceSensorLinks;
    DistanceSensor distanceSensorRechts;
    MotorStuff motorStuff;
    HardwareChassisSun hwChss;


    @Override
    public void init() {
        distanceSensorLinks = hardwareMap.get(DistanceSensor.class, "color_distance");
        distanceSensorRechts = hardwareMap.get(DistanceSensor.class, "color_distance");
        hwChss = new HardwareChassisSun(hardwareMap);
        motorStuff = new MotorStuff(hwChss);
    }

    @Override
    public void loop() {
        telemetry.addData("distance", distanceSensorLinks.getDistance(DistanceUnit.MM));
        telemetry.addData("distance", distanceSensorRechts.getDistance(DistanceUnit.MM));
        telemetry.update();

        while (!isThereAWall(distanceSensorLinks.getDistance(DistanceUnit.MM)) && !isThereAWall(distanceSensorRechts.getDistance(DistanceUnit.MM))) {
            motorStuff.driveInOneDirection(0.2,0.2);
            telemetry.addData("distance", distanceSensorLinks.getDistance(DistanceUnit.MM));
            telemetry.addData("distance", distanceSensorRechts.getDistance(DistanceUnit.MM));
            telemetry.update();

        }

        if (isThereAWall(distanceSensorRechts.getDistance(DistanceUnit.MM))) {

            while (!isThereAWall(distanceSensorLinks.getDistance(DistanceUnit.MM))) {
                hwChss.motor_back_right.setPower(0.2);
                hwChss.motor_back_left.setPower(0.2);
            }
        } else if (isNaN(distanceSensorLinks.getDistance(DistanceUnit.MM))) {

            while (!isNaN(distanceSensorRechts.getDistance(DistanceUnit.MM))) {
                hwChss.motor_back_right.setPower(-0.2);
                hwChss.motor_back_left.setPower(-0.2);
            }
        }

        motorStuff.setAllMotors(0,0,0,0);



    }


    boolean isNaN (double isNumberNaN){
        if (isNumberNaN == isNumberNaN){
            return false;
        } else {
            return true;
        }
    }

    boolean isThereAWall (double numberOfWall) {
        if (isNaN(numberOfWall) || numberOfWall >= 10) {
            return  false;
        } else {
            return true;
        }
    }
}
