package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp(name = "Distance")
public class TestDistanceSensor extends LinearOpMode {
    private DistanceSensor distanceSensorLinks;
    private DistanceSensor distanceSensorRechts;
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;


    @Override
    public void runOpMode() throws InterruptedException {
        distanceSensorLinks = hardwareMap.get(DistanceSensor.class, "color_distance_left");
        distanceSensorRechts = hardwareMap.get(DistanceSensor.class, "color_distance_right");
        hwChss = new HardwareChassisSun(hardwareMap);
        motorStuff = new MotorStuff(hwChss);

        waitForStart();

        telemetry.addData("distance", distanceSensorLinks.getDistance(DistanceUnit.MM));
        telemetry.addData("distance", distanceSensorRechts.getDistance(DistanceUnit.MM));
        telemetry.update();

        while (!isThereAWall(distanceSensorLinks.getDistance(DistanceUnit.MM)) && !isThereAWall(distanceSensorRechts.getDistance(DistanceUnit.MM))) {
            motorStuff.driveInOneDirection(0.2,0.2);
            telemetry.addData("distance", distanceSensorLinks.getDistance(DistanceUnit.MM));
            telemetry.addData("distance", distanceSensorRechts.getDistance(DistanceUnit.MM));
            telemetry.update();

        }

        motorStuff.setAllMotors(0,0,0,0);
        if (isThereAWall(distanceSensorRechts.getDistance(DistanceUnit.MM))) {

            while (!isThereAWall(distanceSensorLinks.getDistance(DistanceUnit.MM))) {
                hwChss.motor_front_left.setPower(0.2);
                hwChss.motor_back_left.setPower(-0.2);
            }
        } else if (isNaN(distanceSensorLinks.getDistance(DistanceUnit.MM))) {

            while (!isNaN(distanceSensorRechts.getDistance(DistanceUnit.MM))) {
                //todo fix 
                hwChss.motor_back_right.setPower(0.2);
                hwChss.motor_back_left.setPower(0.2);
            }
        }

        motorStuff.setAllMotors(0,0,0,0);


    }


    private boolean isNaN (double isNumberNaN){
        if (isNumberNaN == isNumberNaN){
            return false;
        } else {
            return true;
        }
    }

    private boolean isThereAWall (double numberOfWall) {
        if (isNaN(numberOfWall) || numberOfWall >= 200) {
            return  false;
        } else {
            return true;
        }
    }
}
