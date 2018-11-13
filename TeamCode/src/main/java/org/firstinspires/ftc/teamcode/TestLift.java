package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Simple class to use both lift motors
@TeleOp (name = "LiftTest")
public class TestLift extends OpMode {
    DcMotor motor_lift;
    DcMotor motor_extends;

    @Override
    public void init() {
        motor_lift = hardwareMap.get(DcMotor.class, "motor_lift");
        motor_extends = hardwareMap.get(DcMotor.class, "motor_extend");

    }

    @Override
    public void loop() {
        motor_lift.setPower(gamepad1.left_stick_x);
        motor_extends.setPower(gamepad1.right_stick_x);
    }

}
