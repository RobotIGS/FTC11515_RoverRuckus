package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverOptimized;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp (name = "BAUTEAM_FAHREN")
public class BauteamFahrenOptimal extends OpMode {
    private HardwareChassisSun ghwchss;
    private DriveHoverOptimized driveOp;
    private MotorStuff motstff;

    private double driveSpeedX;
    private double driveSpeedY;

    @Override
    public void init() {
        ghwchss = new HardwareChassisSun(hardwareMap);

        motstff = new MotorStuff(ghwchss, hardwareMap);

        driveOp = new DriveHoverOptimized();
    }

    @Override
    public void loop() {
        driveOp.drive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_trigger);
        this.driveSpeedX = driveOp.driveSpeedX;
        this.driveSpeedY = driveOp.driveSpeedY;

        motstff.setAllMotors(driveSpeedY, driveSpeedX,driveSpeedY,driveSpeedX);
    }
}
