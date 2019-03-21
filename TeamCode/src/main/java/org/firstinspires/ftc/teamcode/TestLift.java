package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Simple class to use both lift motors
@TeleOp (name = "TestLift")
public class TestLift extends OpMode {
    DcMotor motor_lift;

    @Override
    public void init() {
        motor_lift = hardwareMap.get(DcMotor.class, "motor_lift");


    }

    @Override
    public void loop() {
        motor_lift.setPower(gamepad1.left_stick_y);
    }

}
