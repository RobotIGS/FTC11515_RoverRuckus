package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

//Tobias
public class Aufgabe4 extends OpMode {

    private ColorSensor CS;
    private DcMotor VL;
    private DcMotor HR;

    @Override
    public void init() {
        VL = hardwareMap.get(DcMotor.class, "front_left");
        HR = hardwareMap.get(DcMotor.class, "back_right");
        VL.setPower(0.5);
        HR.setPower(0.5);

    }

    @Override
    public void loop() {
     if(CS.red() > CS.blue() && CS.red() > CS.green() && CS.red() > 50){
       VL.setPower(0.0);
       HR.setPower(0.0);
     }
    }
}
