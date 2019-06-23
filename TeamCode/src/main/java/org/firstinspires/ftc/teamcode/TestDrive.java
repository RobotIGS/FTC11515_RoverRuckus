package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Disabled
@TeleOp (name = "FahrenTesten")
public class TestDrive extends OpMode {
    private DcMotor motor_port_0;
    private DcMotor motor_port_1;

    private double power_0;
    private double power_1;

    @Override
    public void init() {
        motor_port_0 = hardwareMap.dcMotor.get("motor_0");
        motor_port_1 = hardwareMap.dcMotor.get("motor_1");
        motor_port_0.setDirection(DcMotorSimple.Direction.REVERSE);
        power_0 = 0;
        power_1 = 0;
    }

    @Override
    public void loop() {
        if(gamepad1.right_trigger != 0 || gamepad1.left_trigger != 0) {
            if(gamepad1.right_trigger != 0 && gamepad1.left_trigger == 0) {
                power_0 = gamepad1.right_trigger;
                power_1 = gamepad1.right_trigger;
            }else if(gamepad1.right_trigger == 0 && gamepad1.left_trigger != 0) {
                power_0 = -gamepad1.left_trigger;
                power_1 = -gamepad1.left_trigger;
            }
            if(gamepad1.right_stick_x != 0){
                if(gamepad1.right_stick_x > 0){
                    if(power_0 > 0){
                        power_1 = power_1 - gamepad1.right_stick_x;
                    }else{
                        power_1   = power_1 + gamepad1.right_stick_x;
                    }
                }else{
                    if(power_0 > 0){
                        power_0 = power_0 + gamepad1.right_stick_x;
                    }else{
                        power_0 = power_0 - gamepad1.right_stick_x;
                    }
                }
            }
            motor_port_0.setPower(power_0);
            motor_port_1.setPower(power_1);
        }else if(gamepad1.left_stick_x != 0){
            motor_port_0.setPower(-gamepad1.left_stick_x);
            motor_port_1.setPower(gamepad1.left_stick_x);
        }else {
            motor_port_1.setPower(0);
            motor_port_0.setPower(0);
        }
    }
}
