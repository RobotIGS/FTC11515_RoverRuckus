package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisHitlIGS;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisMerkelIGS;

public class MotorStuff extends LinearOpMode{
    private HardwareChassisHitlIGS hwchssH;
    private HardwareChassisMerkelIGS hwchssM;


    public void runOpMode() throws InterruptedException {
        hwchssH = new HardwareChassisHitlIGS(hardwareMap);
        hwchssM = new HardwareChassisMerkelIGS(hardwareMap);
    }

    public void setAllMotors(double SpeedFrontLeft, double SpeedFrontRight, double SpeedBackLeft, double SpeedBackRight, boolean isHitlIGS){
        if (isHitlIGS){
            hwchssH.motor_front_left.setPower(SpeedFrontLeft);
            hwchssH.motor_front_right.setPower(SpeedFrontRight);
            hwchssH.motor_back_left.setPower(SpeedBackLeft);
            hwchssH.motor_back_right.setPower(SpeedFrontRight);

        }else{
            hwchssM.motor_front_left.setPower(SpeedFrontLeft);
            hwchssM.motor_front_right.setPower(SpeedFrontRight);
            hwchssM.motor_back_left.setPower(SpeedBackLeft);
            hwchssM.motor_back_right.setPower(SpeedFrontRight);

        }
        //telemetry.addLine("[FATAL ERROR] isHitlIGS");
        //telemetry.update();
    }
}