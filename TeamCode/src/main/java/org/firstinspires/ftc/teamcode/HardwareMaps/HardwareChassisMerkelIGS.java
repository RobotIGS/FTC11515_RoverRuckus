package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareChassisMerkelIGS extends HardwareChassis {

    public HardwareChassisMerkelIGS(HardwareMap ahwMap) {
        super(ahwMap);
        super.init(ahwMap);
    }

    @Override
    protected void setDirections() {
        motor_front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_back_left.setDirection(DcMotorSimple.Direction.FORWARD);
    }


}
