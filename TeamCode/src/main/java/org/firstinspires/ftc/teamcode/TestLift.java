package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//Simple class to use both lift motors
@TeleOp (name = "TestLift")
public class TestLift extends OpMode {
    DcMotor motor_lift;
    private DistanceSensor left;
    private DistanceSensor right;

    @Override
    public void init() {
        motor_lift = hardwareMap.get(DcMotor.class, "motor_lift");
        motor_lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left = hardwareMap.get(DistanceSensor.class, "color_distance_back_left");
        right = hardwareMap.get(DistanceSensor.class, "color_distance_back_right");




    }

    @Override
    public void loop() {
        motor_lift.setPower(-gamepad1.left_stick_y);
        telemetry.addData("left", left.getDistance(DistanceUnit.MM));
        telemetry.addData("right", right.getDistance(DistanceUnit.MM));
        telemetry.update();
    }

}
