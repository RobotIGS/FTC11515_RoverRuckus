package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//Simple class to use both lift motors
@Disabled
@TeleOp (name = "TestLiftDown")
public class TestLiftDown extends OpMode {
    DcMotor motor_lift;
    private DistanceSensor left;
    private DistanceSensor right;

    @Override
    public void init() {
        motor_lift = hardwareMap.get(DcMotor.class, "motor_lift");
        motor_lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left = hardwareMap.get(DistanceSensor.class, "color_distance_back_left");
        right = hardwareMap.get(DistanceSensor.class, "color_distance_back_right");




    }

    @Override
    public void loop() {
        while (left.getDistance(DistanceUnit.MM) > 180) {
            motor_lift.setPower(-0.5);
        }
    }

}
