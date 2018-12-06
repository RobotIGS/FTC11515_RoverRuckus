package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.Tools.FarbHelfer;


@TeleOp(name = "Farbhelfer Test")
public class FarbhelferTest extends OpMode {

    ColorSensor sensorColor;
    FarbHelfer farbHelfer;

    @Override
    public void init() {
        sensorColor = hardwareMap.colorSensor.get("color");
        farbHelfer = new FarbHelfer();

    }

    @Override
    public void loop() {
        telemetry.addData("isRed: ", farbHelfer.isRed(sensorColor));
        telemetry.addData("isBlue: ", farbHelfer.isBlue(sensorColor));
        /*telemetry.addData("colorChange: ", farbHelfer.colorChange(sensorColor));*/
        telemetry.update();
    }
}
