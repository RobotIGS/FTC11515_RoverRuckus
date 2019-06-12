package org.firstinspires.ftc.teamcode.IdeenExpoShowCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisIdeenExpo;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;

public class Problem1 extends LinearOpMode {
    private HardwareChassisIdeenExpo robot;
    private MotorStuff motorStuff;
    private Tools tools;

    @Override
    public void runOpMode() {
        //Init
        robot = new HardwareChassisIdeenExpo(hardwareMap);
        motorStuff = new MotorStuff(robot);
        tools = new Tools(this);
        waitForStart();

        aufgabe1(0);



    }

    private void aufgabe1(int n) {
        int x = n, y = 1;
        y = x;
        x++;
        int z = -1;
        int v = 0;
        if (x == y) {
            System.out.println("0.5");
        } else {
            while (x > 0) {
                y = y + v;
                x = x - (y - x);
                z = z * -1;
                v++;
                System.out.println("x" + x);
                System.out.println("y" + y);

                if (z == -2) return;
            }
            System.out.println("v" + v);
            System.out.println("z:   " + z);
            if (v == 4 && z == -1) {
                motorStuff.driveBack(0.5, 0.5);
                tools.stopForMilliSeconds(1000);
                motorStuff.setAllMotors(0,0,0,0);
            }
            if (v == 3 && z == 1) {
                //Forward
                motorStuff.driveInOneDirection(0.5, 0.5);
                tools.stopForMilliSeconds(1000);
                motorStuff.setAllMotors(0,0,0,0);
            } else {
                motorStuff.driveLeft(0.5, 0.5);
                tools.stopForMilliSeconds(1000);
                motorStuff.setAllMotors(0,0,0,0);
            }
        }
    }
}
