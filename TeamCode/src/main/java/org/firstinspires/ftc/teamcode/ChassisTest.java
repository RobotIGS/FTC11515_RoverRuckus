package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Chassis Test")
public class ChassisTest extends OpMode {
    private DcMotor motor_lift;
    private Servo servo_arm;


    @Override
    public void init() {
        motor_lift = hardwareMap.get(DcMotor.class, "motor_lift");
        servo_arm = hardwareMap.get(Servo.class, "servo");
    }

    @Override
    public void loop() {

        motor_lift.setPower(gamepad1.left_stick_x);

        if (gamepad1.x) {
            servo_arm.setPosition(0);
        }
        if (gamepad1.b) {
            servo_arm.setPosition(45);
        }
        if (gamepad1.a) {
            servo_arm.setPosition(15);
        }
        if (gamepad1.y) {
            servo_arm.setPosition(30);
        }

    }
}
