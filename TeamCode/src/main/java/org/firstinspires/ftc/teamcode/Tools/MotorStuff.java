/*This class is used for shortcuts e.g. the setAllMotors method used to set all motors at once instead of having to set all of them individually
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;

public class MotorStuff {
    //Declare a variable to hand over the right wanted hardwaremap for the right layout
    HardwareChassis hwchss;

    //CONSTRUCTOR SET hwchss to given (handed over) hardwaremap
    public MotorStuff(HardwareChassis ghwchss) {
        hwchss = ghwchss;
    }

    //this method is used to set all motors at once instead of having to set all of them individually gets speed values by main class
    public void setAllMotors(double SpeedFrontLeft, double SpeedFrontRight, double SpeedBackLeft, double SpeedBackRight){
            hwchss.motor_front_left.setPower(SpeedFrontLeft);
            hwchss.motor_front_right.setPower(SpeedFrontRight);
            hwchss.motor_back_left.setPower(SpeedBackLeft);
            hwchss.motor_back_right.setPower(SpeedBackRight);
    }
}