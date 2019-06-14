package org.firstinspires.ftc.teamcode.IdeenExpoShowCode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisIdeenExpo;
import org.firstinspires.ftc.teamcode.Tools.Tools;


/*
 Der Imu ("imu") ist ein Sensor, welcher wie ein Kompass funktioniert aber auch
 die Beschleunigung und ähnliches messen kann
 Robot ist eine Instanz, welche verschiedene Methoden zum Steuern des
 Roboters enthält.
 Beide werden von der Superklasse vererbt.
 Es sei davon auszugehen, dass diese initialisiert sind und
 funktionieren.
 */
@Deprecated
public class Redacted /*extends LinearOpMode*/ {
    /*private HardwareChassisIdeenExpo robot;
    private Tools tools;

    @Override
    public void runOpMode() {
        //Unit: m / s^2
        double[] accValuesX = new double[10];
        double[] accValuesY = new double[10];


        robot.drive(0.5); //Drive forward, with a relative speed of 0.5
        Tools.stopForMilliSeconds(1000);
        accValuesX[1] = imu.getAcceleration().xaccel;
        accValuesY[1] = imu.getAcceleration().yaccel;
        Tools.stopForMilliSeconds(1000);
        for(int i = 2; i < 6; i++) {
            accValuesX[i] = imu.getAcceleration().xaccel;
            accValuesY[i] = imu.getAcceleration().yaccel;
            Tools.stopForMilliSeconds(1000);
        }
        robot.drive(0.7);
        for(int i = 6; i < 10; i++) {
            accValuesX[i] = imu.getAcceleration().xaccel;
            accValuesY[i] = imu.getAcceleration().yaccel;
            Tools.stopForMilliSeconds(1000);
        }
        System.out.println(accValuesX);
        System.out.println(accValuesY);

    }

    private double[] method1(double[] acc, int timeDiff) {
        double[] t = new double[acc.length];
        for(int i = 0; i < acc.length; i++) {
            for(int n = 0; n < i+1; n++) {
                t[i] += timeDiff * acc[n];
            }
        }
        return t;
    }*/
}
