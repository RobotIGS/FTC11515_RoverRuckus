package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;



@TeleOp
public class Fahren2 extends OpMode {

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
        if(gamepad1.left_stick_x > 0){
            VR.setPower(gamepad1.left_stick_x / 2);
            HL.setPower(-gamepad1.left_stick_x / 2);
        }
        if(gamepad1.left_stick_x < 0){
            VR.setPower(gamepad1.left_stick_x / 2);
            HL.setPower(gamepad1.left_stick_x - (gamepad1.left_stick_x * 2) /2);
        }
        if(gamepad1.left_stick_y > 0){
            VL.setPower(-gamepad1.left_stick_y / 2);
            HR.setPower(gamepad1.left_stick_y / 2);
        }
        if(gamepad1.left_stick_y < 0){
            VL.setPower(gamepad1.left_stick_y - (gamepad1.left_stick_y *2) /2);
            HR.setPower(gamepad1.left_stick_y / 2);
        }
        if(gamepad1.left_stick_y == 0){
            VL.setPower(0.0);
            HR.setPower(0.0);
        }
        if(gamepad1.left_stick_x == 0){
            VR.setPower(0.0);
            HL.setPower(0.0);
        }
        if(gamepad1.right_stick_x != 0 && gamepad1.right_stick_x == 0){
            VL.setPower(gamepad1.right_stick_x / 2);
            VR.setPower(gamepad1.right_stick_x / 2);
            HL.setPower(gamepad1.right_stick_x / 2);
            HR.setPower(gamepad1.right_stick_x / 2);
        }
    }
}
