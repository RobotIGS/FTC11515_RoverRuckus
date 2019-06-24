package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;

@Disabled
@TeleOp (name = "DistanceReadOut")
public class DistanceReadOut extends OpMode {
    private HardwareChassisSun hwChss;

    @Override
    public void init() {
        hwChss = new HardwareChassisSun(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("DistanceRight:", hwChss.distance_right.getDistance(DistanceUnit.MM));
        telemetry.addData("DistanceLeft:", hwChss.distance_left.getDistance(DistanceUnit.MM));
        telemetry.update();
    }
}
