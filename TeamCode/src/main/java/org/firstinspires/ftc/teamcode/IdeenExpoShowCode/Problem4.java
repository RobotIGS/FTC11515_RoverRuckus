package org.firstinspires.ftc.teamcode.IdeenExpoShowCode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;



@TeleOp(name = "Problem4")
public class Problem4 extends OpMode {
    private DcMotor motor_hub2_port1;
    private DcMotor motor_hub2_port3;
    @Override
    public void init() {
        motor_hub2_port1 = hardwareMap.dcMotor.get("motor_hub2_port1");
        motor_hub2_port3 = hardwareMap.dcMotor.get("motor_hub2_port3");

        motor_hub2_port1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_hub2_port3.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
        //Das Ziel ist, dass der Roboter vorwärts fährt.
        if (gamepad1.left_trigger != 0){
            motor_hub2_port1.setPower(1);
            motor_hub2_port3.setPower(1);
        } else {
            motor_hub2_port1.setPower(0);
            motor_hub2_port3.setPower(0);
        }
    }
}


