/*package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;

@Deprecated
public class GyroToolsTest extends OpMode {

    /*
    Author Malte and Lars
    The following class is supposed to enable turn chassisun a specific amount of degrees
     */
/*
    private MotorStuff motorstuff = new MotorStuff(new HardwareChassisSun(hardwareMap), hardwareMap );

    private MotorStuff motorstuff = new MotorStuff(new HardwareChassisSun(hardwareMap), hardwareMap );

    public void turn(double Degrees){
        while(Degrees>360){
            Degrees -= 360;
        }
        while(Degrees<-360){
            Degrees += 360;
        }
        if(Degrees>180){
            Degrees -= 360;
        }
        if(Degrees<-180) {
            Degrees += 360;
        }
        double turnspeed = Math.tanh(Degrees);
        motorstuff.setAllMotors(turnspeed,-turnspeed,-turnspeed,turnspeed);
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
*/