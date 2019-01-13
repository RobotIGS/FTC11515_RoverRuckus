package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverOptimized;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
@TeleOp (name = "SatoriusControlled")
public class DriverControlledSatorius extends OpMode {

    HardwareChassisSun hwChss;
    MotorStuff ms;
    DriveHoverOptimized dr;


    @Override
    public void init() {
        hwChss = new HardwareChassisSun(hardwareMap);
        ms = new MotorStuff(hwChss, hardwareMap);
        dr = new DriveHoverOptimized();
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_y == 0 && gamepad1.left_stick_x != 0) {
            ms.driveInOneDirection(gamepad1.left_stick_x, gamepad1.left_stick_x);
        }
        if (gamepad1.left_stick_x == 0 && gamepad1.left_stick_y != 0) {
            ms.driveLeft(gamepad1.left_stick_y, gamepad1.left_stick_y);
        }
        if (gamepad1.right_stick_x != 0 && gamepad1.right_stick_y != 0) {
            ms.setAllMotors(gamepad1.right_stick_x, gamepad1.right_stick_y, gamepad1.right_stick_x, gamepad1.right_stick_x);
        }
        if (gamepad1.left_stick_x == 0 && gamepad1.left_stick_x == 0 && (gamepad1.right_stick_x == 0  || gamepad1.right_stick_y == 0)) {
            ms.setAllMotors(0,0,0,0);
        }


    }
}
