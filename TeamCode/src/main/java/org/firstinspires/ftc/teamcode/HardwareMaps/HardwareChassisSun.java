package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareChassisSun extends HardwareChassis{

    public HardwareChassisSun(HardwareMap ahwMap) {
        super(ahwMap);
    }

    @Override
    protected void setDirections() {
        motor_front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_back_right.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_back_left.setDirection(DcMotorSimple.Direction.FORWARD);
    }
}