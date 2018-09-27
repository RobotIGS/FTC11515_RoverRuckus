package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisMerkelIGS;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

public class TestDriveTrainMerkelIGS extends OpMode {

    private double driveSpeed;

    HardwareChassisMerkelIGS hwchss;
    MotorStuff motstff;

    @Override
    public void init() {
        hwchss = new HardwareChassisMerkelIGS(hardwareMap);
        motstff = new MotorStuff(hwchss);
    }

    @Override
    public void loop() {
        driveSpeed = gamepad1.right_trigger;

        if(gamepad1.dpad_up){
            motstff.setAllMotors(driveSpeed,driveSpeed,driveSpeed,driveSpeed);
        } else if(gamepad1.dpad_down){
            motstff.setAllMotors(-driveSpeed,-driveSpeed,-driveSpeed,-driveSpeed);
        }else if(gamepad1.dpad_left){
            motstff.setAllMotors(-driveSpeed,driveSpeed,driveSpeed,-driveSpeed);
        }else if(gamepad1.dpad_right){
            motstff.setAllMotors(driveSpeed,-driveSpeed,-driveSpeed,driveSpeed);
        }else{
            motstff.setAllMotors(0,0,0,0);
        }
    }
}
