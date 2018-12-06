package org.firstinspires.ftc.teamcode.Testing;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp (name = "DriveMethodsTest")
public class DriveMethodsTest extends OpMode {
    MotorStuff motorStuff;
    HardwareChassisSun hardwareChassisSun;

    double SpeedFrontLeft = 0.3;
    double SpeedFrontRight = 0.3;
    double SpeedBackLeft = 0.3;
    double SpeedBackRight = 0.3;


    @Override
    public void init () {
        hardwareChassisSun = new HardwareChassisSun(hardwareMap);
        motorStuff = new MotorStuff(hardwareChassisSun);
    }

    @Override
    public void loop () {
        if (gamepad1.dpad_up){
            motorStuff.driveInOneDirection (SpeedFrontLeft, SpeedBackRight);
        } else if (gamepad1.dpad_down){
            motorStuff.driveBack (SpeedFrontLeft, SpeedBackRight);
        } else if (gamepad1.dpad_left){
            motorStuff.driveLeft(SpeedBackLeft, SpeedFrontRight);
        } else if (gamepad1.dpad_right) {
            motorStuff.driveRight(SpeedBackLeft,SpeedFrontRight);
        } else {
            motorStuff.setAllMotors(0, 0, 0, 0);
        }
    }


}
