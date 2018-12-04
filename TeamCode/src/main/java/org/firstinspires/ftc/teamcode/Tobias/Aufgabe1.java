package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Tobias
@TeleOp
public class Aufgabe1 extends OpMode {

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
    if(gamepad1.right_trigger == 1){
        VL.setPower(-0.5);
        HR.setPower(0.5);
    }
    if(gamepad1.left_trigger == 1){
        VL.setPower(0.5);
        HR.setPower(-0.5);
    }
    if(gamepad1.left_bumper){
        VL.setPower(-0.5);
        VR.setPower(-0.5);
        HL.setPower(-0.5);
        HR.setPower(-0.5);
    }
    if(gamepad1.right_bumper){
        VL.setPower(0.5);
        VR.setPower(0.5);
        HL.setPower(0.5);
        HR.setPower(0.5);
    }
    if(!gamepad1.right_bumper && !gamepad1.left_bumper && gamepad1.left_trigger == 0 && gamepad1.right_trigger == 0){
        VL.setPower(0.0);
        VR.setPower(0.0);
        HL.setPower(0.0);
        HR.setPower(0.0);
    }
}}
