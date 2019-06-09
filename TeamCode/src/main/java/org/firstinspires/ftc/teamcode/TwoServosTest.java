package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TwoServoaTest")
public class TwoServosTest extends OpMode {
    private CRServo servo0;
    private CRServo servo1;
    @Override
    public void init() {
        servo0 = hardwareMap.crservo.get("servo0");
        servo1 = hardwareMap.crservo.get("servo1");
    }

    @Override
    public void loop() {
        if(gamepad1.a) {
            servo0.setPower(1);
            servo1.setPower(-1);
        }
        if(gamepad1.b) {
            servo0.setPower(0);
            servo1.setPower(0);
        }
    }
}
