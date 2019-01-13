package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Simple class to use both lift motors
@TeleOp (name = "Einsammler")
public class TestLift extends OpMode {
    DcMotor motor_lift;

    @Override
    public void init() {
        motor_lift = hardwareMap.get(DcMotor.class, "motor");


    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            motor_lift.setPower(0.5);
        } else if (gamepad1.dpad_down) {
            motor_lift.setPower(-0.5);
        } else {
            motor_lift.setPower(0);
        }
    }

}
