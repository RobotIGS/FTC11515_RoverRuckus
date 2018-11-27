/*This class is used for shortcuts e.g. the setAllMotors method used to set all motors at once instead of having to set all of them individually
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;

public class MotorStuff {

    //Declare a variable to hand over the right wanted hardwaremap for the right layout
    private HardwareChassis hwchss;
    private final int SMOOTHNESS = 80;
    private double turnSpeed;
    private float prevDegrees;
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
    public void turn (double speed, Direction_Enum direction){
            if (direction.equals(Direction_Enum.Right)){
                setAllMotors(speed,-speed,-speed,speed);
            }else if(direction.equals(Direction_Enum.Left)){
                setAllMotors(-speed,speed,speed,-speed);
            }
    }/* not yet
    public void turnToDegree(double degrees){
        while (degrees > 0.1 || degrees < -0.1){
            prevDegrees =
            turnSpeed = Math.tanh(degrees/SMOOTHNESS);
            turn(turnSpeed, Direction_Enum.Right);

            degrees =
        }*/
    }
}