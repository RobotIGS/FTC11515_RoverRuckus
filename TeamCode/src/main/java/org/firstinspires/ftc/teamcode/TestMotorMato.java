package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "TestMotorMato")
public class TestMotorMato extends OpMode {
    private DcMotor dcMotor;
    @Override
    public void init() {
        dcMotor = hardwareMap.dcMotor.get("horizontaler_arm");
    }

    @Override
    public void loop() {
        if(gamepad1.x) dcMotor.setPower(0.5);
        if(gamepad1.y) dcMotor.setPower(-0.5);
        if(gamepad1.b) dcMotor.setPower(0);
    }
}
