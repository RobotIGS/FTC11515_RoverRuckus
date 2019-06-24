package org.firstinspires.ftc.teamcode.Fahrklassen;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Programm für den Workshop.
 * Erlaubt einfaches Fahren mit zwei FahrtMotoren.
 * Zusätzlich Steuerung von zwei Motoren
 *
 *
 */
@Deprecated
@Disabled
@TeleOp (name = "WorkshopEinfachFahren")
public class WorkshopEinfachFahren extends OpMode {

    private DcMotor motor_driveLeft;
    private DcMotor motor_driveRight;
    private DcMotor motor_addition_port2;
    private DcMotor motor_addition_port3;

    //private DcMotor motor_addition_hub2;


    @Override
    public void init() {
        motor_driveLeft = hardwareMap.dcMotor.get("motor_hub1_port0");
        motor_driveRight = hardwareMap.dcMotor.get("motor_hub1_port1");
        motor_addition_port2 = hardwareMap.dcMotor.get("motor_hub1_port2");
        motor_addition_port3 = hardwareMap.dcMotor.get("motor_hub1_port3");

        motor_driveLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_driveRight.setDirection(DcMotorSimple.Direction.REVERSE);



        motor_addition_port2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE );

       // motor_addition_hub2 = hardwareMap.dcMotor.get("motor_hub2_port0");
    }

    @Override
    public void loop() {
        if(gamepad1.dpad_up && !gamepad1.dpad_left && !gamepad1.dpad_right ) {
            //Drive Forward
            motor_driveLeft.setPower(1);
            motor_driveRight.setPower(1);
        }
        if(gamepad1.dpad_left && !gamepad1.dpad_up && ! gamepad1.dpad_right) {
            double speed = 0.5;
            if(gamepad1.right_bumper) speed = 1;
            //TurnLeft
            motor_driveLeft.setPower(speed);
            motor_driveRight.setPower(-speed);

        }
        if(gamepad1.dpad_right && !gamepad1.dpad_up && ! gamepad1.dpad_left) {
            double speed = 0.5;
            if(gamepad1.right_bumper) speed = 1;
            //TurnLeft
            motor_driveLeft.setPower(-speed);
            motor_driveRight.setPower(speed);
        }
        if(!gamepad1.dpad_right && !gamepad1.dpad_up && ! gamepad1.dpad_left && !gamepad1.dpad_down) {
            //TurnLeft
            motor_driveRight.setPower(0);
            motor_driveLeft.setPower(0);
        }
        if(gamepad1.dpad_down && !gamepad1.dpad_left && !gamepad1.dpad_right && !gamepad1.dpad_up ) {
            //Drive Forward
            motor_driveLeft.setPower(-1);
            motor_driveRight.setPower(-1);
        }

        motor_addition_port2.setPower(gamepad1.left_stick_y);
        motor_addition_port3.setPower(gamepad1.right_stick_y);
        //motor_addition_hub2.setPower(gamepad1.left_stick_x);


    }
}
