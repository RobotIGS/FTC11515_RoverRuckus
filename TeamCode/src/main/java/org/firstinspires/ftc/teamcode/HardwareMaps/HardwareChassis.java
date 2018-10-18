package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class HardwareChassis {
    public DcMotor motor_front_right = null;
    public DcMotor motor_front_left = null;
    public DcMotor motor_back_right = null;
    public DcMotor motor_back_left = null;

    private HardwareMap hwmap = null;

    public HardwareChassis(HardwareMap ahwMap) {
        init(ahwMap);
        setDirections();
    }


    public void init(HardwareMap hwMap) {

        motor_front_right = hwMap.get(DcMotor.class, "motor_front_right");
        motor_front_left = hwMap.get(DcMotor.class, "motor_front_left");
        motor_back_right = hwMap.get(DcMotor.class, "motor_back_right");
        motor_back_left = hwMap.get(DcMotor.class, "motor_back_left");


        motor_front_right.setPower(0);
        motor_front_left.setPower(0);
        motor_back_right.setPower(0);
        motor_back_left.setPower(0);


        motor_front_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_front_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_back_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_back_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        motor_front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor_front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor_back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor_back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    abstract protected void setDirections();
}
