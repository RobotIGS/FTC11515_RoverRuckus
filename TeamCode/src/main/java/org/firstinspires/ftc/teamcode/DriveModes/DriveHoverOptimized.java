/*
*  This class uses the Same Concept as the unoptimized Drive Hover class but optimized,
*  this means that contrary to the unoptimized type, the highest value will be set to max motor power and the other to the relation of the two,
*  this should have the result of the powervector in the direction of aimed driving beeing at 100% of the possible power
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.DriveModes;

public class DriveHoverOptimized {
    //declare some variables for X and Y Vector(physical, not IT wise)
    //to be used as vars to write in the calculated values
    private double gameX;
    private double gameY;
    //to be used to calculate the power to set the motors to and to be used by child class
    public double driveSpeedX;
    public double driveSpeedY;

    //main method
    //the Y is negaative due to gamepad
    public void drive(double gl1X, double gl1Y, double trigger) {
        /*  the VAR = (CONDITON) ? (CONDITION) ? OUTCME_0 : OUTCME_1 : OUTCME_2 command works the following:
        *   VAR = (FALSE) ? (FALSE) ? NULL : NULL : OUTCME
        *   VAR = (FALSE ? (TRUE) ? NULL : NULL : OUTCME because if the first is false it von check fr the second condition
        *   VAR = (TRUE) ? (FALSE) ? NULL : OUTCME : NULL
        *   VAR =  (TRUE ? (TRUE) ? OUTCME : NULL : NULL
        *   To find a way a var could be set in one of the outcomes would be nice
        *   This could be a bit more optimated by merging stuff together
         */
        //if one of the values is positive and not 0
        if (gl1X > 0 || gl1Y > 0) {
            //if they're the same
            if (Math.abs(gl1X) == Math.abs(gl1Y)) {
                //if they're of the same sum they and over 0 theyll be set bith to 1 ore negative one if theyre negative
                //gameX = (gl1X != 0) ? (gl1X < 0) ? -1 : 1 : 0;
                //gameY = (gl1Y != 0) ? (gl1Y < 0) ? -1 : 1 : 0;
                gameX = (gl1X < 0) ? -1 : 1;
                gameY = (gl1Y < 0) ? -1 : 1;
            //if one is positive AND one is negative and not 0
            } else if (gl1Y < 0 || gl1X < 0) {
                //if the one is negative and the other is positive
                if (gl1Y < 0 && gl1X > 0 || gl1X < 0 && gl1Y > 0) {
                    gameX = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1X < gl1Y ? -1 : 1 : Math.abs(gl1X) / gl1Y * -1;
                    gameY = (Math.abs(gl1Y) > Math.abs(gl1X)) ? gl1Y < gl1X ? -1 : 1 : Math.abs(gl1Y) / gl1X * -1;
                //if both are negatve
                } else {
                    gameX = (Math.abs(gl1X) < Math.abs(gl1Y)) ? gl1X / gl1Y * -1 : -1;
                    gameY = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1Y / gl1X * -1 : -1;
                }
            //if both are positive
            } else {
                gameX = (Math.abs(gl1X) < Math.abs(gl1Y)) ? gl1X / gl1Y : 1;
                gameY = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1Y / gl1X : 1;
            }
        //if both are negative
        } else if (gl1X < 0 || gl1Y < 0) {
            gameX = (Math.abs(gl1X) < Math.abs(gl1Y)) ? gl1X / gl1Y * -1 : -1;
            gameY = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1Y / gl1X * -1 : -1;
        //if both are 0
        } else {
            gameX = 0;
            gameY = 0;
        }
        //calculate the power to set the motors to by multiplying the trigger value (0-1) with the game value to have controllable optimal speed
        driveSpeedX = trigger * gameX;
        driveSpeedY = trigger * gameY;
    }
}
