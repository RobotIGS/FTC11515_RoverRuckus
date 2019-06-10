package org.firstinspires.ftc.teamcode.Fahrklassen;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name = "CompetitionIdeenExpo")
public class CompetiitonIdeenExpo extends OpMode {
    private final double SERVO_POS_TRANSMIT = 0;
    private final double SERVO_POS_ELEVATE = 45;
    private final double SERVO_POS_EMIT = 90;
    private boolean IS_UP = false;
    private boolean IS_DOWN = false;

    private DcMotor motor_back_left;
    private DcMotor motor_back_right;
    private DcMotor motor_front_left;
    private DcMotor motor_front_right;

    private DcMotor motor_tilt_collector;
    private DcMotor motor_arm_vertical_coll;
    private DcMotor motor_arm_horizontal_mineral;
    private DcMotor motor_climb;

    private CRServo crservo_collect_left;
    private CRServo crservo_collect_right;

    private Servo servo_throw_out;
    private Servo servo_move_mineral;



    @Override
    public void init() {
        //todo
        motor_tilt_collector = hardwareMap.dcMotor.get("motor_hub1_port3");
        motor_arm_vertical_coll = hardwareMap.dcMotor.get("motor_hub1_port1");
        motor_arm_horizontal_mineral = hardwareMap.dcMotor.get("motor_hub1_port0");
        motor_climb = hardwareMap.dcMotor.get("motor_hub1_port2");

        servo_throw_out = hardwareMap.servo.get("servo_hub1_port3");

        crservo_collect_left = hardwareMap.crservo.get("servo0");
        crservo_collect_right = hardwareMap.crservo.get("servo1");
        crservo_collect_right.setDirection(DcMotorSimple.Direction.REVERSE);

        servo_move_mineral = hardwareMap.servo.get("servo_hub1_port2");
        motor_tilt_collector.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



    }


    @Override
    public void loop() {
        if(gamepad1.dpad_left) {
            motor_arm_horizontal_mineral.setPower(1);
        }
        if(gamepad1.dpad_right) {
            motor_arm_horizontal_mineral.setPower(-1);
        }
        if(!gamepad1.dpad_left && !gamepad1.dpad_right) {
            motor_arm_horizontal_mineral.setPower(0);
        }
        if(gamepad1.dpad_up) {
            motor_arm_vertical_coll.setPower(-1);
        }
        if(gamepad1.dpad_down) {
            motor_arm_vertical_coll.setPower(1);
        }
        if(!gamepad1.dpad_up && !gamepad1.dpad_down) {
            motor_arm_vertical_coll.setPower(0);
        }

        motor_tilt_collector.setPower((gamepad1.left_stick_y * 0.5));
        motor_climb.setPower(gamepad1.right_stick_y);

        if(gamepad1.left_bumper) {
            crservo_collect_left.setPower(1);
            crservo_collect_right.setPower(1);
        }
        if(gamepad1.right_bumper) {
            crservo_collect_left.setPower(0);
            crservo_collect_right.setPower(0);
        }
        //Servo move mineral_ Collect: 0.6 Move: 0.1 (+- 0.05
        if(gamepad1.y) {
            motor_tilt_collector.setPower(1);
            stopForMilliSeconds(250);
            motor_tilt_collector.setPower(0);
            servo_move_mineral.setPosition(0.15); //todo 0.1
            stopForMilliSeconds(500);
            servo_move_mineral.setPosition(0.55);
            stopForMilliSeconds(150); //todo remove maybe
            motor_tilt_collector.setPower(-1);
            stopForMilliSeconds(300);
            motor_tilt_collector.setPower(0);
            stopForMilliSeconds(1750);
            servo_move_mineral.setPosition(0.15); //todo 0.15
            stopForMilliSeconds(500);
            servo_move_mineral.setPosition(0.55);

            stopForMilliSeconds(400);
            servo_move_mineral.setPosition(0.1);
            stopForMilliSeconds(400);
            servo_move_mineral.setPosition(0.55);



        }        if(gamepad1.a) servo_move_mineral.setPosition(0.55);
        if(gamepad1.right_stick_button) servo_move_mineral.setPosition(0.1);

        if(gamepad1.right_bumper) {
            servo_throw_out.setPosition(1);
        }
        if(gamepad1.left_bumper) {
            servo_throw_out.setPosition(-0.8);
        }
        if(gamepad1.guide) {
            servo_throw_out.setPosition(0);
        }



    }

    /**
     * pauses the program for additional seconds
     * @param timeStop double, in Milliseconds
     */
    public void stopForMilliSeconds(double timeStop) {
        double time = System.currentTimeMillis();

        while ((System.currentTimeMillis() < time + timeStop) ) {}
    }
}
