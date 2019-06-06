package org.firstinspires.ftc.teamcode.Testing;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;



import java.util.Locale;
@Disabled
@TeleOp(name = "HSV_Test")
public class HSV_Test extends LinearOpMode {

    ColorSensor sensorColor;
    final double SCALE_FACTOR = 255; //Umrechnungsfaktor um von RGB zu HSV zu kommen

    @Override
    public void runOpMode() throws InterruptedException {
        sensorColor = hardwareMap.colorSensor.get("SensorColor");
        float[] hsvValues = new float[3];

        waitForStart();


        // loop and read the RGB and distance data.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive()) {
            // convert the RGB values to HSV values.
            // multiply by the SCALE_FACTOR.
            // then cast it back to int (SCALE_FACTOR is a double)
            //hue is float[0]
            Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
                    (int) (sensorColor.green() * SCALE_FACTOR),
                    (int) (sensorColor.blue() * SCALE_FACTOR),
                    hsvValues);

            // send the info back to driver station using telemetry function for hsv (and rgb)
            /*telemetry.addData("Alpha: ", sensorColor.alpha());
            telemetry.addData("Red: ", sensorColor.red());
            telemetry.addData("Green ", sensorColor.green());
            telemetry.addData("Blue ", sensorColor.blue());*/
            telemetry.addData("Hue: ", hsvValues[0]);
            telemetry.addData("Saturation: ", hsvValues[1]);
            telemetry.addData("Value: ", hsvValues[2]);


            telemetry.update();
        }

    }

}