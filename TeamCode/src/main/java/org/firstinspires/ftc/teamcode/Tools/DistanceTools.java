package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Direction;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp(name = "Distance")
public class DistanceTools extends LinearOpMode {
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;
    private FarbHelfer blueline;




    @Override
    public void runOpMode() throws InterruptedException {

        //hwChss.distance_left = hardwareMap.get(DistanceSensor.class, "color_distance_left");
        //hwChss.distance_right = hardwareMap.get(DistanceSensor.class, "color_distance_right");
        hwChss = new HardwareChassisSun(hardwareMap);
        motorStuff = new MotorStuff(hwChss, hardwareMap);
        blueline = new FarbHelfer();


        waitForStart();

        driveToWall(Direction.RIGHT);


    }

    public void driveToWall(Direction direction) {
        if (direction == Direction.RIGHT) {

            while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM))) {
                motorStuff.driveInOneDirection(0.2, 0.2);
            }

            motorStuff.setAllMotors(0, 0, 0, 0);

            while (!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM))) {
                hwChss.motor_front_left.setPower(0.2);
                hwChss.motor_back_left.setPower(-0.2);
            }
            motorStuff.setAllMotors(0,0,0,0);
        }
        else if (direction == Direction.LEFT) {

            while (!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM))) {
                motorStuff.driveInOneDirection(0.2, 0.2);
            }

            motorStuff.setAllMotors(0, 0, 0, 0);

            while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM))) {
                hwChss.motor_front_right.setPower(-0.2);
                hwChss.motor_back_right.setPower(0.2);
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
        if (isNaN(numberOfWall) || numberOfWall >= 400) {
            return  false;
        } else {
            return true;
        }
    }

    public HardwareChassisSun getHwChss() {
        return hwChss;
    }

    public void setHwChss(HardwareChassisSun hwChss) {
        this.hwChss = hwChss;
    }

    public MotorStuff getMotorStuff() {
        return motorStuff;
    }

    public void setMotorStuff(MotorStuff motorStuff) {
        this.motorStuff = motorStuff;
    }
}
