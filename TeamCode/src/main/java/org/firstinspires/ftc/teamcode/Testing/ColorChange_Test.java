package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;
import org.firstinspires.ftc.teamcode.Tools.FarbHelfer;

import java.util.LinkedList;
import java.util.Queue;

@TeleOp (name = "ColorChange_Test")
public class ColorChange_Test extends LinearOpMode {

    ColorSensor sensorColorChanged;
    FarbHelfer farbHelfer;
    Queue<Integer> colorList;
    LinkedList<Integer> averageList;
    float[] hsvNow;
    int colorHSVnow;
    boolean colorIsChanged;

    @Override
    public void runOpMode() throws InterruptedException {
        sensorColorChanged = hardwareMap.colorSensor.get("color");
        farbHelfer = new FarbHelfer();
        hsvNow = farbHelfer.showHSV(sensorColorChanged);
        colorHSVnow = (int) hsvNow[0];
        colorList = new LinkedList<>();
        averageList = new LinkedList<>();
        colorIsChanged = false;

        waitForStart();


        /**
         * while the boolean colorIsChanged isn't true it's continuing the program
         *
         * telemetry shows the green letters at the driver station handy
         * and the boolean value after it
         *
         * while the size of the queue color list is lower than 100 it adds new values to the list
         * if the size is equal 100 it calculates with the method colorChange
         * the average of all values and compares it with the average before
         * after that it removes the very first value and adds an new
         * if the color is changed colorChange it returns a boolean and sets colorIsChanged true
         */
        while (colorIsChanged == false) {

            telemetry.addData("Color changed:", farbHelfer.colorChange(sensorColorChanged,colorList));
            telemetry.addData("isRed: ", farbHelfer.isRed(sensorColorChanged));
            telemetry.addData("isBlue: ", farbHelfer.isBlue(sensorColorChanged));
            telemetry.update();

            while (colorList.size() <= 100) {
                colorList.add(colorHSVnow);
            }

            if (colorList.size() == 100) {
                colorIsChanged = farbHelfer.colorChange(sensorColorChanged, colorList);
                colorList.remove(0);
                colorList.add(colorHSVnow);
            }
        }

    }
}
