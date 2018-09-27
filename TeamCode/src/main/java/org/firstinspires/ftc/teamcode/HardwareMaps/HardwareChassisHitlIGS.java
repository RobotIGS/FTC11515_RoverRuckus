package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareChassisHitlIGS {
    public DcMotor motor_front_right = null;
    public DcMotor motor_front_left = null;
    public DcMotor motor_back_right = null;
    public DcMotor motor_back_left = null;

    private HardwareMap hwmap = null;

    public HardwareChassisHitlIGS(HardwareMap ahwMap) {
        init(ahwMap);
    }

    public void init(HardwareMap hwMap) {

        motor_front_right = hwMap.get(DcMotor.class, "motor_vorne_rechts");
        motor_front_right.setDirection(DcMotorSimple.Direction.REVERSE);

        motor_front_left = hwMap.get(DcMotor.class, "motor_vorne_links");
        motor_front_left.setDirection(DcMotorSimple.Direction.REVERSE);

        motor_back_right = hwMap.get(DcMotor.class, "motor_hinten_rechts");
        motor_back_right.setDirection(DcMotorSimple.Direction.FORWARD);

        motor_back_left = hwMap.get(DcMotor.class, "motor_vorne_links");
        motor_back_left.setDirection(DcMotorSimple.Direction.FORWARD);

        motor_front_right.setPower(0);
        motor_front_left.setPower(0);
        motor_back_right.setPower(0);
        motor_back_left.setPower(0);

        motor_front_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_front_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_back_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_back_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
