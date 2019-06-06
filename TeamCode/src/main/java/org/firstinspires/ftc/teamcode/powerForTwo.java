package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "FreriksMotorsProgramm")
public class powerForTwo extends OpMode {
    private DcMotor motor;
    private DcMotor motorTwo;


    @Override
    public void init() {
        motor = hardwareMap.dcMotor.get("motor1");
        motorTwo = hardwareMap.dcMotor.get("motor2");
    }

    @Override
    public void loop() {
        if (gamepad1.left_trigger != 0){
            motor.setPower(1);
            motorTwo.setPower(1);
        }else {
            motor.setPower(0);
            motorTwo.setPower(0);
        }
    }
}
