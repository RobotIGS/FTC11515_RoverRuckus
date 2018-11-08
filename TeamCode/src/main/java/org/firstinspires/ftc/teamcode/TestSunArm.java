package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
@TeleOp
public class TestSunArm extends OpMode {
    //declare given hardwaremap as MerkelIGS
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;

    @Override
    public void init() {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over MerkelIGS hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss);
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            motstff.setAllMotors(0.5,0,0,0);
        }else if(gamepad1.b){
            motstff.setAllMotors(-0.5,0,0,0);
        }else{
            motstff.setAllMotors(0,0,0,0);
        }
    }
}
