package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.DistanceTools;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;


@TeleOp (name = "testing")
public class TestingClass extends LinearOpMode {
    HardwareChassisSun hwChss;


    @Override
    public void runOpMode() throws InterruptedException {
        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap);
        DistanceTools distanceTools = new DistanceTools(motorStuff, hwChss);
        Tools tools = new Tools();
        distanceTools.driveToWallWithCompass(motorStuff.getDegree());
    }

    public void drivezickzack() {
        while ( hwChss.color_back_right. < 10) {

        }
    }
}
