package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;
import org.firstinspires.ftc.teamcode.Tools.TurnStuffCalibration;

@Disabled
@Autonomous (name = "CalibrationMinSpeed")
public class ChassisCalibration extends LinearOpMode {
    private double var;

    @Override
    public void runOpMode() throws InterruptedException {
        Tools tools = new Tools(this);
        HardwareChassisSun hwChss = new HardwareChassisSun(hardwareMap);
        MotorStuff motorStuff = new MotorStuff(hwChss, hardwareMap, this);
        TurnStuffCalibration turnCal = new TurnStuffCalibration(motorStuff);
        

        var = turnCal.getMinimumSpeed();

        while(!isStopRequested()){
            telemetry.addData("Min Speed Value Is", var);
            telemetry.update();
        }
    }
}
