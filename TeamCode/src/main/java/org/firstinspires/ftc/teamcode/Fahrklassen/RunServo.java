package org.firstinspires.ftc.teamcode.Fahrklassen;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@Disabled
@TeleOp (name = "RunServo")
public class RunServo extends OpMode {

    Servo v;
    @Override
    public void init() {
        v = hardwareMap.servo.get("servo_hub1_port0");
    }

    @Override
    public void loop() {
        if(gamepad1.a) v.setPosition(0);
        if(gamepad1.b) v.setPosition(90);
    }
}
