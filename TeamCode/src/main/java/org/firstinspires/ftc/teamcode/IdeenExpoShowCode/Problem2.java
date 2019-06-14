package org.firstinspires.ftc.teamcode.IdeenExpoShowCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisIdeenExpo;

@TeleOp (name = "Problem2")
public class Problem2 extends OpMode {
    HardwareChassisIdeenExpo robot;


    @Override
    public void init() {
        //Initializes the motors
        robot = new HardwareChassisIdeenExpo(hardwareMap);

    }

    @Override
    public void loop() {
        //Loop just repeats it's contents all the time, while the robot is running

        //Stick returns values between -1 and 1.
        robot.motor_climb.setPower(gamepad1.left_stick_y);

        if(gamepad1.a && gamepad1.b) {
            robot.motor_front_left.setPower(1);
            robot.motor_back_right.setPower(1);
        } else {
            robot.motor_front_left.setPower(0);
            robot.motor_back_right.setPower(0);
        }
    }
}