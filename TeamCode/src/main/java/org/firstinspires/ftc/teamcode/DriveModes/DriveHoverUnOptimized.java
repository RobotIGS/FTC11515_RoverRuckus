/* this class calculates the power of the motors on Y- and X-Axes using the values of the gamepad Stick and Gamepad Trigger
 * created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.DriveModes;

public class DriveHoverUnOptimized {
    //to be used to calculate the power to set the motors to and to be used by child class
    public double driveSpeedX;
    public double driveSpeedY;

    public void drive(double gl1X, double gl1Y, double trigger){
        //The power is calculated by multiplying trigger and stick value
        driveSpeedX = trigger * gl1X;
        driveSpeedY = trigger * gl1Y;
    }
}
