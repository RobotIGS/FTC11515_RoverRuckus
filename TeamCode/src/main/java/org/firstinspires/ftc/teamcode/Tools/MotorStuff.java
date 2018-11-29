/*This class is used for shortcuts e.g. the setAllMotors method used to set all motors at once instead of having to set all of them individually
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareGyro;

public class MotorStuff {

    //Declare a variable to hand over the right wanted hardwaremap for the right layout
    private HardwareChassis hwchss;
    private HardwareGyro hwgy;
    private final int SMOOTHNESS = 80;
    private double turnSpeed;
    private float prevDegrees;
    /**
     * Constructor
     * @param _hwchss the hardwaremap object that should be used
     */
    public MotorStuff(HardwareChassis _hwchss, HardwareMap hardwareMap) {
        hwchss = _hwchss;
        hwgy = new HardwareGyro(hardwareMap);
        hwgy.init(hardwareMap);
    }
    /*public MotorStuff(HardwareChassis _hwchss, HardwareGyro _hwgy, HardwareMap hardwareMap) {
        hwchss = _hwchss;
        hwgy = _hwgy;
        hwgy.init(hardwareMap);
    }*/

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
    }
    public float getDegree(){
        return this.hwgy.imu.getAngularOrientation(AxesReference.EXTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
    }

    public HardwareGyro getHwgy() {
        return hwgy;
    }

    public void setHwgy(HardwareGyro hwgy) {
        this.hwgy = hwgy;
    }

    public void turnToDegree(double degrees){
        degrees += 180;
        while (degrees > 1) {
            prevDegrees = this.getDegree() + 180;
            turnSpeed = Math.tanh(degrees / SMOOTHNESS);
            turn(turnSpeed, Direction_Enum.Right);

            degrees = degrees - (prevDegrees - this.getDegree());
        }
        setAllMotors(0,0,0,0);
    }
}