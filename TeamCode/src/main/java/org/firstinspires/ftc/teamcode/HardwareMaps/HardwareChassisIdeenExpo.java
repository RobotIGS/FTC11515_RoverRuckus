package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareChassisIdeenExpo extends HardwareChassis {

    private DcMotor motor_back_left;
    private DcMotor motor_back_right;
    private DcMotor motor_front_left;
    private DcMotor motor_front_right;

    private DcMotor motor_tilt_collector;
    private DcMotor motor_arm_vertical_coll;
    private DcMotor motor_arm_horizontal_mineral;
    private DcMotor motor_climb;

    public HardwareChassisIdeenExpo(HardwareMap hardwareMap) {
        super(hardwareMap);

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


    @Override
    protected void setDirections() {
        motor_front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_front_right.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_back_left.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}
