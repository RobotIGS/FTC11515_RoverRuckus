package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;

public class MotorStuff {
    HardwareChassis hwchss;

    public MotorStuff(HardwareChassis ghwchss) {
        hwchss = ghwchss;
    }

    public void setAllMotors(double SpeedFrontLeft, double SpeedFrontRight, double SpeedBackLeft, double SpeedBackRight){
            hwchss.motor_front_left.setPower(SpeedFrontLeft);
            hwchss.motor_front_right.setPower(SpeedFrontRight);
            hwchss.motor_back_left.setPower(SpeedBackLeft);
            hwchss.motor_back_right.setPower(SpeedBackRight);
    }
}