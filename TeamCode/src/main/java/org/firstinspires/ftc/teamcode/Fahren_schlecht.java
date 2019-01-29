    package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;


@TeleOp (name = "fahren")
public class Fahren_schlecht extends OpMode {
    HardwareChassisSun hwchs = null;
    MotorStuff mtstff = null;
    public double speed;
    @Override
    public void init() {
        hwchs = new HardwareChassisSun(hardwareMap);
        mtstff = new MotorStuff(hwchs,hardwareMap);

    }

    @Override
    public void loop() {
        speed = (double) (gamepad1.left_trigger);
        if (gamepad1.dpad_up) {
            mtstff.setAllMotors(-speed, 0, -speed, 0);
        }
        if (gamepad1.dpad_down) {
            mtstff.setAllMotors(speed, 0, speed, 0);
        }

        if (gamepad1.dpad_right) {
            mtstff.setAllMotors(0, speed, 0, -speed);
        }
        if (gamepad1.dpad_left) {
            mtstff.setAllMotors(0, -speed, 0, speed);
        }
        if(gamepad1.dpad_right){
            mtstff.setAllMotors(0,speed,0,speed);
        }
        if(gamepad1.x){
            mtstff.setAllMotors(speed,speed,speed,speed);
        }
        if(gamepad1.b){
            mtstff.setAllMotors(-speed,-speed,-speed,-speed);
        }
    }
}
