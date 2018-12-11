package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisGyro;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp (name = "TestVelocity")
public class TestVelocity extends OpMode {
    HardwareChassisGyro gyro;
    @Override
    public void init() {
        gyro = new HardwareChassisGyro(hardwareMap);
        gyro.init(hardwareMap);

    }

    @Override
    public void loop() {
        telemetry.addData("velocity x: ", gyro.imu.getVelocity().xVeloc);
        telemetry.addData("velocity y:", gyro.imu.getVelocity().yVeloc);
        telemetry.addData("velocity z: ", gyro.imu.getVelocity().zVeloc);
    }
}
