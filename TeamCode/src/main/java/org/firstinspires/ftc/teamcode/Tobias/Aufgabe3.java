package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

//Tobias
public class Aufgabe3 extends OpMode {

    private ColorSensor red;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
     if(gamepad1.start = true) {
         System.out.println(red.red());
     }
    }
}


