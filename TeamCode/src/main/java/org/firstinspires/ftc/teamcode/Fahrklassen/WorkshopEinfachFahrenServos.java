package org.firstinspires.ftc.teamcode.Fahrklassen;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "WorkshopEinfachFahrenMitServos")
public class WorkshopEinfachFahrenServos extends OpMode {

    private DcMotor motor_driveLeft;
    private DcMotor motor_driveRight;
    private DcMotor motor_addition_port2;
    private DcMotor motor_addition_port3;
    private DcMotor motor_addition_hub2_port0;

    private Servo servo_1;
    private Servo servo_2;
    private Servo servo_3;


    @Override
    public void init() {
        motor_driveLeft = hardwareMap.dcMotor.get("motor_hub1_port0");
        motor_driveRight = hardwareMap.dcMotor.get("motor_hub1_port1");
        motor_addition_port2 = hardwareMap.dcMotor.get("motor_hub1_port2");
        motor_addition_port3 = hardwareMap.dcMotor.get("motor_hub1_port3");
        motor_addition_hub2_port0 = hardwareMap.dcMotor.get("motor_hub2_port0");

        servo_1 = hardwareMap.servo.get("servo_hub1_port0");
        servo_2 = hardwareMap.servo.get("servo_hub1_port1");
        servo_3 = hardwareMap.servo.get("servo_hub1_port2");

        motor_driveLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_driveRight.setDirection(DcMotorSimple.Direction.REVERSE);

        servo_1.setDirection(Servo.Direction.FORWARD);
        servo_2.setDirection(Servo.Direction.FORWARD);
        servo_3.setDirection(Servo.Direction.FORWARD);

        motor_addition_port2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor_addition_hub2_port0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    @Override
    public void loop() {
        if(gamepad1.dpad_up && !gamepad1.dpad_left && !gamepad1.dpad_right ) {
            //Drive Forward
            motor_driveLeft.setPower(1);
            motor_driveRight.setPower(1);
        }
        if(gamepad1.dpad_left && !gamepad1.dpad_up && ! gamepad1.dpad_right) {
            double speed = 0.5;
            if(gamepad1.right_bumper) speed = 1;
            //TurnLeft
            motor_driveLeft.setPower(speed);
            motor_driveRight.setPower(-speed);

        }
        if(gamepad1.dpad_right && !gamepad1.dpad_up && ! gamepad1.dpad_left) {
            double speed = 0.5;
            if(gamepad1.right_bumper) speed = 1;
            //TurnLeft
            motor_driveLeft.setPower(-speed);
            motor_driveRight.setPower(speed);
        }
        if(!gamepad1.dpad_right && !gamepad1.dpad_up && ! gamepad1.dpad_left && !gamepad1.dpad_down) {
            //TurnLeft
            motor_driveRight.setPower(0);
            motor_driveLeft.setPower(0);
        }
        if(gamepad1.dpad_down && !gamepad1.dpad_left && !gamepad1.dpad_right && !gamepad1.dpad_up ) {
            //Drive Forward
            motor_driveLeft.setPower(-1);
            motor_driveRight.setPower(-1);
        }
        if (gamepad1.left_stick_y != 0) {
            motor_addition_port2.setPower(gamepad1.left_stick_y / 3);
        }else{
            motor_addition_port2.setPower(0);
        }
        if (gamepad1.right_stick_y != 0){
            motor_addition_port3.setPower(gamepad1.right_stick_y/1.5);
        }else{
            motor_addition_port3.setPower(0);
        }
        if(gamepad1.left_trigger != 0) {
            motor_addition_hub2_port0.setPower(gamepad1.left_trigger * 0.4);
        }
        if(gamepad1.right_trigger != 0) {
            motor_addition_hub2_port0.setPower(- gamepad1.right_trigger * 0.4);
        }
        if(gamepad1.left_trigger == 0 && gamepad1.right_trigger == 0) {
            motor_addition_hub2_port0.setPower(0);
        }



        if (gamepad1.a) {
            servo_3.setPosition(0.89);
            servo_2.setPosition(0.32);
        }else if(gamepad1.b){
            servo_2.setPosition(0.8);
            servo_3.setPosition(0.3);
        }


    }
}
