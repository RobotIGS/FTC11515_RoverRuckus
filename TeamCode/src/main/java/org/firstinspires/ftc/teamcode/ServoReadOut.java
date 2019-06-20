package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "ServoReadOut")
public class ServoReadOut extends OpMode {
    private Servo servo_1;
    private Servo servo_2;
    private Servo servo_3;

    private double i;
    private double x;
    private double y;
    @Override
    public void init() {
        servo_1 = hardwareMap.servo.get("1Servo");
        servo_2 = hardwareMap.servo.get("2Servo");
        servo_3 = hardwareMap.servo.get("3Servo");

        servo_1.setDirection(Servo.Direction.FORWARD);
        servo_2.setDirection(Servo.Direction.FORWARD);
        servo_3.setDirection(Servo.Direction.FORWARD);

        i = 0;
        x = 0;
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            servo_3.setPosition(0.89);
            servo_2.setPosition(0.32);
        }else if(gamepad1.b){
            servo_2.setPosition(0.8);
            servo_3.setPosition(0.3);
        }
        if (gamepad1.x){
            servo_1.setPosition(0.82);
        }
        telemetry.addData("servo1:", servo_1.getPosition());
        telemetry.addData("servo2:", servo_2.getPosition());
        telemetry.addData("servo3:", servo_3.getPosition());
        telemetry.update();
    }
}
