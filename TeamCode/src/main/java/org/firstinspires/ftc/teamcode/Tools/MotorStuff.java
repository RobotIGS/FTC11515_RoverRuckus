/*This class is used for shortcuts e.g. the setAllMotors method used to set all motors at once instead of having to set all of them individually
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisGyro;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;

public class MotorStuff {

    private final int wallDistanceHut = 7;
    //Declare a variable to hand over the right wanted hardwaremap for the right layout
    private HardwareChassis hwchss;
    private HardwareChassisSun hwChss;

    private HardwareChassisGyro hwgy;

    public MotorStuff(HardwareChassis _hwchss, HardwareMap hardwareMap) {
        hwchss = _hwchss;
        hwChss = new HardwareChassisSun(hardwareMap);
        hwgy = new HardwareChassisGyro(hardwareMap);
        hwgy.init(hardwareMap);
        //this.opMde = opMde;
    }

    /**
     * Used to set all motors at once
     * @param SpeedFrontLeft Speed of FrontLeftMotor
     * @param SpeedBackLeft Speed of BackLeftMotor
     * @param SpeedBackRight Speed of BackRightMotor
     * @param SpeedFrontRight Speed of FrontRightMotor
     */
    public void setAllMotors(double SpeedFrontLeft, double SpeedBackLeft, double SpeedBackRight,double SpeedFrontRight){
            hwchss.motor_front_left.setPower(SpeedFrontLeft);
            hwchss.motor_front_right.setPower(SpeedFrontRight);
            hwchss.motor_back_left.setPower(SpeedBackLeft);
            hwchss.motor_back_right.setPower(SpeedBackRight);
    }



    /**
     * Used to let the robot drive forward
     * @param SpeedFrontLeft Speed of MotorFrontLeft
     * @param SpeedFrontRight Speed of MotorFrontRight
     */
    public void driveInOneDirection (double SpeedFrontLeft, double SpeedFrontRight) {
        hwchss.motor_front_left.setPower(SpeedFrontLeft);
        hwchss.motor_back_right.setPower(SpeedFrontRight);
    }


    /**
     * Used to let the robot drive left
     * @param SpeedBackLeft Speed of MotorBackLeft
     * @param SpeedFrontRight Speed of MotorFrontRight
     */
    public void driveLeft (double SpeedBackLeft, double SpeedFrontRight) {
        hwchss.motor_back_left.setPower(-SpeedBackLeft);
        hwchss.motor_front_right.setPower(-SpeedFrontRight);
    }


    /**
     * This method lets the robot turn
     * @param speed The speed at which the robot should drive (higher values not recommended, not accurate
     * @param direction direction enum, whether it should turn to the left or to the right (enum added by paul)
     */
    public void turn (double speed, Direction_Enum direction){
        if (direction.equals(Direction_Enum.Right)){
            setAllMotors(speed,-speed,-speed,speed);
        }else if(direction.equals(Direction_Enum.Left)){
            setAllMotors(-speed,speed,speed,-speed);
        }
    }

    /**
     * Returns actual position of robot
     * @return position as float
     */
    public float getDegree(){
        Orientation angles;
        angles = hwgy.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        return angles.firstAngle + 180;
    }

    public HardwareChassisGyro getHwgy() {
        return hwgy;
    }

    public void setHwgy(HardwareChassisGyro hwgy) {
        this.hwgy = hwgy;
    }

    /**
     * Drive method from Nils and Malte
     * @param degree The amount of degrees the robot should turn. Don't enter negative values
     */
    public void turnToDegreeV4(float degree){
        if(degree<0) {
            //Please don't throw errors. We cannot detect this on the device ~Paul
            throw new Error("negative Wert zum drehen");
        }
        double difference = 2;
        /*mby remove*/degree = 360 - degree;
        float goal = (this.getDegree() + degree)%360;
        while(difference>1 || difference<-1){
            difference = -1*/*Math.abs*/(goal-this.getDegree());
            this.turn(this.personalTanH(difference/200),Direction_Enum.Right);
        }
        this.setAllMotors(0,0,0,0);
    }
    private double personalTanH(double i){
        double minSpeed = 0.15;
        double o = Math.tanh(i);
        if (o <minSpeed && o>0){ o = 0.15;}
        if(o> -minSpeed && o <0){o = -0.15;}
        return o;
    }


}