package org.firstinspires.ftc.teamcode.Fahrklassen;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Requested by Felix
 * Is able to set the power of every of the eight motors
 */
@Disabled
@TeleOp (name = "WorkshopAllMotors")
public class WorkshopAllMotors extends OpMode {
    private DcMotor motor_hub1_port0;
    private DcMotor motor_hub1_port1;
    private DcMotor motor_hub1_port2;
    private DcMotor motor_hub1_port3;

    private DcMotor motor_hub2_port0;
    private DcMotor motor_hub2_port1;
    private DcMotor motor_hub2_port2;
    private DcMotor motor_hub2_port3;

    private Servo servo_hub2_port0;
    private Servo servo_hub2_port1;
    private Servo servo_hub2_port2;
    private Servo servo_hub2_port3;

    private boolean is22;
    private boolean is23;

    private boolean servo0;
    private boolean servo1;
    private boolean servo2;
    private boolean servo3;


    @Override
    public void init() {
        /*
        motor_hub1_port0 = hardwareMap.dcMotor.get("motor_hub1_port0");
        motor_hub1_port1 = hardwareMap.dcMotor.get("motor_hub1_port1");
        motor_hub1_port2 = hardwareMap.dcMotor.get("motor_hub1_port2");
        motor_hub1_port3 = hardwareMap.dcMotor.get("motor_hub1_port3");
         */

        motor_hub2_port0 = hardwareMap.dcMotor.get("motor_hub2_port0");
        motor_hub2_port1 = hardwareMap.dcMotor.get("motor_hub2_port1");
        motor_hub2_port2 = hardwareMap.dcMotor.get("motor_hub2_port2");
        motor_hub2_port3 = hardwareMap.dcMotor.get("motor_hub2_port3");

        motor_hub2_port2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        servo_hub2_port0 = hardwareMap.servo.get("servo_hub2_port0");
        servo_hub2_port1 = hardwareMap.servo.get("servo_hub2_port1");
        //servo_hub2_port2 = hardwareMap.servo.get("servo_hub2_port2");
        //servo_hub2_port3 = hardwareMap.servo.get("servo_hub2_port3");


        is22 = false;
        is23 = false;

        servo0 = false;
        servo1 = false;
        servo2 = false;
        servo3 = false;

    }

    @Override
    public void loop() {

        //All on gamepad1
        //Motors
        /*
        motor_hub1_port0.setPower(gamepad1.left_stick_y);
        motor_hub1_port1.setPower(gamepad1.right_stick_y);

        motor_hub1_port2.setPower(gamepad1.left_stick_x);
        motor_hub1_port3.setPower(gamepad1.right_stick_x);
        */


        //trigger rechts rückwärts
        motor_hub2_port0.setPower(gamepad1.right_trigger);
        motor_hub2_port1.setPower(-gamepad1.right_trigger);

        //triger links vorwärts
        motor_hub2_port0.setPower(-gamepad1.left_trigger);
        motor_hub2_port1.setPower(gamepad1.left_trigger);

        //linker stick drehen steuerkreuz
        if (gamepad1.dpad_left) {
            motor_hub2_port0.setPower(0.5);
            motor_hub2_port1.setPower(0.5);
        }

        if (gamepad1.dpad_right) {
            motor_hub2_port0.setPower(-0.5);
            motor_hub2_port1.setPower(-0.5);
        }

        //rechter stick kurven
        //soll wert von stick von trigger auf einem motor abziehen, deshalb kurve
        if (gamepad1.right_stick_x < 0 && gamepad1.left_trigger > 0) {
            motor_hub2_port0.setPower(-gamepad1.right_trigger);
            motor_hub2_port1.setPower(gamepad1.right_trigger + gamepad1.left_stick_x);
        }

        if (gamepad1.right_stick_x > 0 && gamepad1.left_trigger > 0) {
            motor_hub2_port0.setPower(-gamepad1.right_trigger - gamepad1.left_stick_x );
            motor_hub2_port1.setPower(gamepad1.right_trigger);
        }


        
        if (gamepad1.a) {
            motor_hub2_port2.setPower(0.5);
        }
        if (gamepad1.b){
            motor_hub2_port2.setPower(-0.5);
        }

        //motor collector
        if (gamepad1.x) {
            motor_hub2_port3.setPower(0.5);
        }
        if (gamepad1.y) {
            motor_hub2_port3.setPower(-0.5);
        }

        if (!gamepad1.a && !gamepad1.b && !gamepad1.y && !gamepad1.x) {
            motor_hub2_port3.setPower(0);
            motor_hub2_port2.setPower(0);
        }


        //collector hand close
        if (gamepad1.right_bumper) {
            servo_hub2_port0.setPosition(0.5);
            servo_hub2_port1.setPosition(0.5);
        }

        //collector hand open
        if (gamepad1.left_bumper) {
            servo_hub2_port0.setPosition(0.8);
            servo_hub2_port1.setPosition(0.2);
        }




        /*
        if(gamepad1.dpad_up) {
            if(is22) {
                motor_hub2_port2.setPower(0);

            } else {
                motor_hub2_port2.setPower(0.5);
            }
            is22 = !is22;
        }
        if(gamepad1.dpad_down) {
            if(is23) {
                motor_hub2_port3.setPower(0);

            } else {
                motor_hub2_port3.setPower(0.5);
            }
            is23 = !is23;
        }
        */


        /*
        if(gamepad1.a) {
            if(servo0) {
                servo_hub1_port0.setPosition(90);
            } else {
                servo_hub1_port0.setPosition(0);
            }
            servo0 = !servo0;
        }
        if(gamepad1.b) {
            if(servo1) {
                servo_hub1_port1.setPosition(45);
            } else {
                servo_hub1_port1.setPosition(-45);
            }
            servo1 = !servo1;
        }
        if(gamepad1.x) {
            if(servo2) {
                servo_hub1_port2.setPosition(90);
            } else {
                servo_hub1_port2.setPosition(0);
            }
            servo2 = !servo2;
        }
        if(gamepad1.y) {
            if(servo3) {
                servo_hub1_port3.setPosition(0);
            } else {
                servo_hub1_port3.setPosition(-90);
            }
            servo3 = !servo3;
        }
        */
    }
}
