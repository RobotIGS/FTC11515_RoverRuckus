/*This class is used for shortcuts e.g. the setAllMotors method used to set all motors at once instead of having to set all of them individually
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;

public class MotorStuff {

    //Declare a variable to hand over the right wanted hardwaremap for the right layout
    private HardwareChassis hwchss;

    /**
     * Constructor
     * @param ghwchss the hardwaremap object that should be used
     */
    public MotorStuff(HardwareChassis ghwchss) {
        hwchss = ghwchss;
    }

    //this method is used to set all motors at once instead of having to set all of them individually gets speed values by main class
    public void setAllMotors(double SpeedFrontLeft, double SpeedBackLeft, double SpeedBackRight,double SpeedFrontRight){
            hwchss.motor_front_left.setPower(SpeedFrontLeft);
            hwchss.motor_front_right.setPower(SpeedFrontRight);
            hwchss.motor_back_left.setPower(SpeedBackLeft);
            hwchss.motor_back_right.setPower(SpeedBackRight);
    }

    /**
     * This method lets the robot turn
     * @param speed The speed at which the robot should drive (higher values not recommended, not accurate
     * @param direction Direction enum, whether it should turn to the left or to the right (enum added by paul)
     */
    public void turn (int speed, Direction_Enum direction){
            if (direction.equals(Direction_Enum.Right)){
                setAllMotors(speed,-speed,-speed,speed);
            }else if(direction.equals(Direction_Enum.Left)){
                setAllMotors(-speed,speed,speed,-speed);
            }
    }



    public void driveInOneDirection (double SpeedOneDirection) {
        hwchss.motor_front_left.setPower(SpeedOneDirection);
        hwchss.motor_back_right.setPower(SpeedOneDirection);
    }


    public void driveBack (double SpeedBack) {
        hwchss.motor_front_left.setPower(-SpeedBack);
        hwchss.motor_back_right.setPower(-SpeedBack);
    }

    public void driveLeft (double SpeedLeft) {
        hwchss.motor_back_left.setPower(-SpeedLeft);
        hwchss.motor_front_right.setPower(-SpeedLeft);
    }

    public void driveRight (double SpeedRight) {
        hwchss.motor_front_right.setPower(SpeedRight);
        hwchss.motor_back_left.setPower(SpeedRight);
    }


}