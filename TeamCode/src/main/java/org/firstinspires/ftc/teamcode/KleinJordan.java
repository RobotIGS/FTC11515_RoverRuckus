package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "KleinJordan")
public class KleinJordan extends OpMode {
    private DcMotor motor;
    @Override
    public void init() {
        motor= hardwareMap.get(DcMotor.class, "motor");
    }

    @Override
    public void loop() {
        // gamepad1.a
        if(gamepad1.a == true) {
            motor.setPower(0.5);
        }
        if(gamepad1.a == false) {
            motor.setPower(0);
        }

    }
}
