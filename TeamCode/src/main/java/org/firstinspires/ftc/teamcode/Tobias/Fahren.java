package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Tobias
@TeleOp
public class Fahren extends OpMode {

    private DcMotor VL;
    private DcMotor VR;
    private DcMotor HL;
    private DcMotor HR;
    private Boolean Drive1 = true;

    @Override
    public void init() {
        VL = hardwareMap.get(DcMotor.class, "motor_front_left");
        VR = hardwareMap.get(DcMotor.class, "motor_front_right");
        HL = hardwareMap.get(DcMotor.class, "motor_back_left");
        HR = hardwareMap.get(DcMotor.class, "motor_back_right");

    }

    @Override
    public void loop() {
        if(Drive1 == true) {
            //Vorwärts
            if (gamepad1.right_trigger > 0) {
                VL.setPower(-gamepad1.right_trigger / 2);
                HR.setPower(gamepad1.right_trigger / 2);
            }
            //Rückwärts
            if (gamepad1.left_trigger > 0) {
                VL.setPower(gamepad1.left_trigger / 2);
                HR.setPower(-gamepad1.left_trigger / 2);

            }
            //Links drehen
            if (gamepad1.left_bumper) {
                VL.setPower(-0.5);
                VR.setPower(-0.5);
                HL.setPower(-0.5);
                 HR.setPower(-0.5);
            }
            //Rechts drehen
            if (gamepad1.right_bumper) {
                VL.setPower(0.5);
                VR.setPower(0.5);
                HL.setPower(0.5);
                HR.setPower(0.5);
            }
            //Links und rechts
            if (gamepad1.left_stick_x > 0.0) {
                VR.setPower(-gamepad1.left_stick_x / 2);
                HL.setPower(gamepad1.left_stick_x / 2);
            }
            if (gamepad1.left_stick_x < 0.0) {
                VR.setPower(-gamepad1.left_stick_x / 2);
                HL.setPower(gamepad1.left_stick_x / 2);
            }
            //Stoppen
            if (!gamepad1.right_bumper && !gamepad1.left_bumper && gamepad1.left_trigger == 0 && gamepad1.right_trigger == 0 && gamepad1.left_stick_x == 0.0) {
                VL.setPower(0.0);
                VR.setPower(0.0);
                HL.setPower(0.0);
                HR.setPower(0.0);
            }

        }else {
            if (gamepad1.right_trigger > 0) {
                VL.setPower(gamepad1.right_trigger / 2);
                HR.setPower(gamepad1.right_trigger / 2);
            }
            if (gamepad1.left_trigger > 0) {
                VL.setPower(-gamepad1.left_trigger / 2);
                HR.setPower(-gamepad1.left_trigger / 2);

            }
            if (gamepad1.left_bumper) {
                VL.setPower(-0.5);
                VR.setPower(0.5);
                HL.setPower(-0.5);
                HR.setPower(0.5);
            }
            if (gamepad1.right_bumper) {
                VL.setPower(0.5);
                VR.setPower(-0.5);
                HL.setPower(0.5);
                HR.setPower(-0.5);
            }
            if (!gamepad1.right_bumper && !gamepad1.left_bumper && gamepad1.left_trigger == 0 && gamepad1.right_trigger == 0) {
                VL.setPower(0.0);
                VR.setPower(0.0);
                HL.setPower(0.0);
                HR.setPower(0.0);
            }
        }
        if(gamepad1.y == true){
           if(Drive1 == true){
               Drive1 = false;
               telemetry.addData("Drive-Mode: ",2);

            }else {
               Drive1 = true;
               telemetry.addData("Drive-Mode: ", 1);

           }
        }




    }}

