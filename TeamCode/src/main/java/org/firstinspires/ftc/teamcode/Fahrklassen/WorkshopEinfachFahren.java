package org.firstinspires.ftc.teamcode.Fahrklassen;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Programm für den Workshop.
 * Erlaubt einfaches Fahren mit zwei FahrtMotoren.
 * Zusätzlich Steuerung von zwei Motoren
 */
@TeleOp (name = "WorkshopEinfachFahren")
public class WorkshopEinfachFahren extends OpMode {

    private DcMotor motor_driveLeft;
    private DcMotor motor_driveRight;
    private DcMotor motor_addition_0;
    private DcMotor motor_addition_1;



    @Override
    public void init() {
        motor_driveLeft = hardwareMap.dcMotor.get("motor_hub1_port0");
        motor_driveRight = hardwareMap.dcMotor.get("motor_hub1_port1");
        motor_addition_0 = hardwareMap.dcMotor.get("motor_hub1_port2");
        motor_addition_1 = hardwareMap.dcMotor.get("motor_hub1_port3");

        motor_driveLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_driveRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if(gamepad1.dpad_up && !gamepad1.dpad_left && !gamepad1.dpad_right ) {
            //Drive Forward
            motor_driveLeft.setPower(1);
            motor_driveRight.setPower(1);
        }
        if(gamepad1.dpad_left && !gamepad1.dpad_up && ! gamepad1.dpad_right) {
            //TurnLeft
            motor_driveLeft.setPower(-0.5);
            motor_driveRight.setPower(0.5);
        }
        if(gamepad1.dpad_right && !gamepad1.dpad_up && ! gamepad1.dpad_left) {
            //TurnLeft
            motor_driveRight.setPower(-0.5);
            motor_driveLeft.setPower(0.5);
        }
        motor_addition_0.setPower(gamepad1.left_stick_y);
        motor_addition_1.setPower(gamepad1.right_stick_y);


    }
}
