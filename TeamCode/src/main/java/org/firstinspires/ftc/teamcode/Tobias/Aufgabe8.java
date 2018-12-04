package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Aufgabe8 extends OpMode {
    private DcMotor VL;
    private DcMotor VR;
    private DcMotor HL;
    private DcMotor HR;

    @Override
    public void init() {
        VL = hardwareMap.get(DcMotor.class, "motor_front_left");
        VR = hardwareMap.get(DcMotor.class, "motor_front_right");
        HL = hardwareMap.get(DcMotor.class, "motor_back_left");
        HR = hardwareMap.get(DcMotor.class, "motor_back_right");

        VR.setPower(0.5);
        HL.setPower(0.5);

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        VR.setPower(0.0);
        HL.setPower(0.0);

    }

    @Override
    public void loop() {

    }
}
