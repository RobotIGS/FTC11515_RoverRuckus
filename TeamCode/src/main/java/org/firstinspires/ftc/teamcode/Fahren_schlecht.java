package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;


@TeleOp (name = "fahren")
public class Fahren_schlecht extends OpMode {
    HardwareChassisSun hwchs = null;
    MotorStuff mtstff = null;
    @Override
    public void init() {
        hwchs = new HardwareChassisSun(hardwareMap);
        mtstff = new MotorStuff(hwchs,hardwareMap);

    }

    @Override
    public void loop() {
        if()

    }
}
