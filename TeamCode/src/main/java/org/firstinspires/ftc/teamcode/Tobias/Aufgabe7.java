package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class Aufgabe7 extends OpMode {
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

    }

    @Override
    public void loop() {
       VL.setPower(gamepad1.left_trigger);
       HR.setPower(-gamepad1.left_trigger);
    }
}
