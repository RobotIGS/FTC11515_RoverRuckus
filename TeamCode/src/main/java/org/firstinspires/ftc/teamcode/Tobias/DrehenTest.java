package org.firstinspires.ftc.teamcode.Tobias;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp

public class DrehenTest extends OpMode {
    private DcMotor VL;
    private DcMotor VR;
    private DcMotor HL;
    private DcMotor HR;
    private int time;
    private double speed;


    @Override
    public void init() {
        VL = hardwareMap.get(DcMotor.class, "motor_front_left");
        VR = hardwareMap.get(DcMotor.class, "motor_front_right");
        HL = hardwareMap.get(DcMotor.class, "motor_back_left");
        HR = hardwareMap.get(DcMotor.class, "motor_back_right");
        time = 5;
        speed = 0.5;
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            VL.setPower(speed);
            VR.setPower(speed);
            HL.setPower(speed);
            HR.setPower(speed);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            VL.setPower(0.0);
            VR.setPower(0.0);
            HL.setPower(0.0);
            HR.setPower(0.0);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        if(gamepad1.left_trigger == 1){
            time = time - 1;
            telemetry.addData("Zeit: ",time+"  Geschwindigkeit: ",speed);
        }
        if (gamepad1.right_trigger ==1){
            time = time + 1;
            telemetry.addData("Zeit: ",time+"  Geschwindigkeit: ",speed);
        }
        if (gamepad1.left_bumper){
            speed = speed - 0.1;
            telemetry.addData("Zeit: ",time+"  Geschwindigkeit: ",speed);
        }
        if (gamepad1.right_bumper){
            speed = speed + 0.1;
            telemetry.addData("Zeit: ",time+ "  Geschwindigkeit: ",speed);
        }
    }
}
