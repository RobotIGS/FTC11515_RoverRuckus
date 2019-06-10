package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "TwoServoaTest")
public class TwoServosTest extends OpMode {
    private CRServo servo0;
    private CRServo servo1;
    @Override
    public void init() {
        servo0 = hardwareMap.get(CRServo.class, "servo0");
        servo1 = hardwareMap.get(CRServo.class, "servo1");
        servo1.setDirection(DcMotorSimple.Direction.REVERSE);
        servo0.setPower(1);
        servo1.setPower(1);

    }

    @Override
    public void loop() {
        telemetry.addData("Port0", servo0.getPortNumber());
        telemetry.addData("Servo1", servo1.getPortNumber());
        telemetry.update();
        if(gamepad1.a) {
            servo0.setPower(1);
            servo1.setPower(1);
        }
        if(gamepad1.b) {
            servo0.setPower(0);
            servo1.setPower(0);
        }
    }
}
