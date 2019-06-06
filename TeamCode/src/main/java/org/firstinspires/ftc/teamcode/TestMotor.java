package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;

@TeleOp (name = "TestMotorPort0")
public class TestMotor extends OpMode {

    private DcMotor motor_port_0;

    @Override
    public void init() {

        motor_port_0 = hardwareMap.dcMotor.get("test_motor");
    }

    @Override
    public void loop() {
        if(gamepad1.left_trigger != 0 && gamepad1.right_trigger == 0) {
            motor_port_0.setPower(gamepad1.left_trigger);
        }
        if(gamepad1.right_trigger != 0 && gamepad1.left_trigger == 0) {
            motor_port_0.setPower(-gamepad1.right_trigger);
        }
        if(gamepad1.right_trigger == 0 && gamepad1.left_trigger == 0) {
            motor_port_0.setPower(0);
        }
    }
}
