package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisHitlIGS;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

public class TestDriveTrainHitlIGS extends OpMode{
    private HardwareChassisHitlIGS hwchss;
    private MotorStuff motstff;
    private double driveSpeed;

    @Override
    public void init() {
        hwchss = new HardwareChassisHitlIGS(hardwareMap);
        motstff = new MotorStuff();
    }

    @Override
    public void loop() {
        driveSpeed = gamepad1.right_trigger;

        if(gamepad1.dpad_up){
            motstff.setAllMotors(0,driveSpeed,driveSpeed,0,true);
        }else if (gamepad1.dpad_down){
            motstff.setAllMotors(0,-1,-1,0,true);
        }else if (gamepad1.dpad_right){
            motstff.setAllMotors(1,0,0,1,true);
        }else if (gamepad1.dpad_left){
            motstff.setAllMotors(-1,0,0,-1,true);
        }else {
            motstff.setAllMotors(0,0,0,0,true);
        }
    }
}

