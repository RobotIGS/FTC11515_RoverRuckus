package org.firstinspires.ftc.teamcode.IdeenExpoShowCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisIdeenExpo;

public class Problem2 extends LinearOpMode {
    HardwareChassisIdeenExpo robot;

    @Override
    public void runOpMode() throws InterruptedException {
        //Init
        robot = new HardwareChassisIdeenExpo(hardwareMap);
        waitForStart();


    }
}