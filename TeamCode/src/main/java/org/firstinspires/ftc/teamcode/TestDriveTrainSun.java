package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

public class TestDriveTrainSun extends OpMode{

    private double driveSpeed;

    private HardwareChassisSun hwchss;
    private MotorStuff motstff;

    @Override
    public void init() {
        hwchss = new HardwareChassisSun(hardwareMap);
        motstff = new MotorStuff(hwchss);
    }

    @Override
    public void loop() {
        driveSpeed = gamepad1.right_trigger;

        if(gamepad1.dpad_up){
            motstff.setAllMotors(0,driveSpeed,driveSpeed,0);
        }else if (gamepad1.dpad_down){
            motstff.setAllMotors(0,-1,-1,0);
        }else if (gamepad1.dpad_right){
            motstff.setAllMotors(1,0,0,1);
        }else if (gamepad1.dpad_left){
            motstff.setAllMotors(-1,0,0,-1);
        }else {
            motstff.setAllMotors(0,0,0,0);
        }
    }
}

