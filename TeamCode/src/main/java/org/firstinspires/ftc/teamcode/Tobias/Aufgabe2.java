package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Tobias
@TeleOp
public class Aufgabe2 extends OpMode {

    private double Zufall = 0;
    @Override
    public void init() {

    }

    @Override
    public void loop() {
    if(gamepad1.start == true){
        Zufall = Math.floor(Math.random() * 9);
        telemetry.addData("Zufallszahl:",Zufall);
    }
    }
}
