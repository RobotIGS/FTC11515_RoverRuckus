package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareChassisIdeenExpo {

    public DcMotor motor_back_left;
    public DcMotor motor_back_right;
    public DcMotor motor_front_left;
    public DcMotor motor_front_right;

    public DcMotor motor_tilt_collector;
    public DcMotor motor_arm_vertical_coll;
    public DcMotor motor_arm_horizontal_mineral;
    public DcMotor motor_climb;

    public HardwareChassisIdeenExpo(HardwareMap hardwareMap) {

        motor_front_left = hardwareMap.dcMotor.get("motor_hub2_port1");
        motor_front_right = hardwareMap.dcMotor.get("motor_hub2_port2");
        motor_back_left = hardwareMap.dcMotor.get("motor_hub2_port0");
        motor_back_right = hardwareMap.dcMotor.get("motor_hub2_port3");

        motor_tilt_collector = hardwareMap.dcMotor.get("motor_hub1_port3");
        motor_arm_vertical_coll = hardwareMap.dcMotor.get("motor_hub1_port1");
        motor_arm_horizontal_mineral = hardwareMap.dcMotor.get("motor_hub1_port0");
        motor_climb = hardwareMap.dcMotor.get("motor_hub1_port2");

        setDirections();
    }


    protected void setDirections() {
        motor_front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_front_right.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_back_left.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}
