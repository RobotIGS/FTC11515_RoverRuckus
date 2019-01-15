package org.firstinspires.ftc.teamcode;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/*
    Created by @Paul 22.10.18
    Offers an alternative to our standard, linear,  "if(gamepad...)" that get's called in a loop
    Creates threads, so the requests can be made simultaneously (hopefully)
    By that, lags for the drivers could be minimized.

 */

@TeleOp (name = "GamepadThreads")
public class Gamepad_Threads extends LinearOpMode {
    private DcMotor motor_front_left; //Test Motors
    private DcMotor motor_front_right; //Test Motors

    @Override
    public void runOpMode() {
        motor_front_right = hardwareMap.get(DcMotor.class, "motor_vorne_rechts");
        motor_front_right.setDirection(DcMotorSimple.Direction.REVERSE);

        motor_front_left = hardwareMap.get(DcMotor.class, "motor_vorne_links");
        motor_front_left.setDirection(DcMotorSimple.Direction.REVERSE);

        Thread dPadLeft = new Thread(new Runnable() {
            @Override
            public void run() {
                if (gamepad1.b) {
                    motor_front_right.setPower(0.5);
                } else {
                    motor_front_right.setPower(0);
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                run();

            }
        });

        Thread dPadRight = new Thread(new Runnable() {
            @Override
            public void run() {
                if (gamepad1.a) {
                    motor_front_left.setPower(0.5);
                } else {
                    motor_front_left.setPower(0);
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                run();

            }
        });

        waitForStart();

        dPadLeft.start();
        dPadRight.start();

        while (true) {

        }


    }



}
