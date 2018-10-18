package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp
public class TestDriveTrainSun extends OpMode{

    private double driveSpeed;

    private HardwareChassisSun ghwchss;
    private MotorStuff motstff;

    @Override
    public void init() {
        ghwchss = new HardwareChassisSun(hardwareMap);
        motstff = new MotorStuff(ghwchss);
    }

    @Override
    public void loop() {
        driveSpeed = gamepad1.right_trigger;

        if (gamepad1.dpad_up) {
            motstff.setAllMotors(driveSpeed, 0, 0, driveSpeed);
        } else if (gamepad1.dpad_down) {
            motstff.setAllMotors(-driveSpeed, 0, 0, -driveSpeed);
        } else if (gamepad1.dpad_right) {
            motstff.setAllMotors(0, driveSpeed, driveSpeed, 0);
        } else if (gamepad1.dpad_left) {
            motstff.setAllMotors(0, -driveSpeed, -driveSpeed, 0);
        } else if (gamepad1.a) {
            motstff.setAllMotors(0, 0.5, 0, 0);
        } else if(gamepad1.b){
            motstff.setAllMotors(0, -0.25, 0, 0);
        }else{
            motstff.setAllMotors(0,0,0,0);
        }
    }
}

