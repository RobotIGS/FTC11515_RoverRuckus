package org.firstinspires.ftc.teamcode.DriveModes;

public class DriveHoverUnOptimized {
    public double driveSpeedX;
    public double driveSpeedY;
    public void drive(double gl1X, double gl1Y, double trigger){
        driveSpeedX = trigger * gl1X;
        driveSpeedY = trigger * gl1Y;
    }
}
