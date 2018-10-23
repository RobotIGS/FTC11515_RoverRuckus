package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/*
    Created by @Paul 22.10.18
    Offers an alternative to our standard, linear,  "if(gamepad...)" that get's called in a loop
    Creates threads, so the requests can be made simultaneously (hopefully)
    By that, lags for the drivers could be minimized.

 */

public class Gamepad_Threads extends LinearOpMode {
    private DcMotor motor_left; //Test Motors
    private DcMotor motor_right; //Test Motors

    @Override
    public void runOpMode() {
        motor_left = hardwareMap.dcMotor.get("motor_left");
        motor_right = hardwareMap.dcMotor.get("motor_right");

        Thread dPadLeft = new Thread(new Runnable() {
            @Override
            public void run() {
                if (gamepad1.dpad_left) {
                    System.out.println(true);
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
                if (gamepad1.dpad_right) {
                    System.out.println(true);
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


    }



}
