package org.firstinspires.ftc.teamcode.Tools;

import android.hardware.Sensor;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class TestProgramm extends LinearOpMode {
    private FarbsensorTest farbsensorTest;
    private ColorSensor colorSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        colorSensor = hardwareMap.get(ColorSensor.class, "sensor");
        farbsensorTest = new FarbsensorTest(colorSensor);

        farbsensorTest.driveUntilOtherColor();

        telemetry.addData("IstFertig", true);
        telemetry.update();
    }
}
