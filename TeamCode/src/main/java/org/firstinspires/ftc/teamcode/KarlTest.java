package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisKarl;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp
public class KarlTest extends OpMode {
    HardwareChassisKarl hwchss;
    @Override
    public void init() {
        //declare given hardwaremap as MerkelIGS
        hwchss = new HardwareChassisKarl(hardwareMap);

    }

    @Override
    public void loop() {
        if(gamepad1.a){
            hwchss.servo.setPosition(hwchss.servo.getPosition() + 0.01);
        } else if(gamepad1.b){
            hwchss.servo.setPosition(hwchss.servo.getPosition() - .01);
        }
        telemetry.addData("Position:", hwchss.servo.getPosition());
        telemetry.update();
    }
}
