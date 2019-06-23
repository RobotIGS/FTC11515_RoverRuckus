package org.firstinspires.ftc.teamcode.IdeenExpoShowCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Disabled
@Autonomous (name = "Problem3")
public class Problem3 extends LinearOpMode {


    @Override
    public void runOpMode() {

        waitForStart();
        int res = method1(8);
        telemetry.addData("Result: ",  res);
        telemetry.update();
        while (opModeIsActive()) {

        }
    }

    private int method1(int i) {
        if (i < 0) {
            System.out.println("Please insert positive numbers!");
            return i;

        }
        if (i == 1 || i == 2 ) {
            return 0;
        }
        if(i == 3) {
            return 1;
        }
        return method1(i - 1) + method1(i - 2) + method1(i - 3);
    }
}
