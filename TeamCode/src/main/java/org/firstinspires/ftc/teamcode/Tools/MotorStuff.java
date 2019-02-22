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
     * @param direction direction enum, whether it should turn to the left or to the right (enum added by paul)
     */
    public void turn (int speed, Direction_Enum direction){
            if (direction.equals(Direction_Enum.Right)){
                setAllMotors(speed,-speed,-speed,speed);
            }else if(direction.equals(Direction_Enum.Left)){
                setAllMotors(-speed,speed,speed,-speed);
            }
    }


    public void driveInOneDirection (double SpeedFrontLeft, double SpeedFrontRight) {
        hwchss.motor_front_left.setPower(SpeedFrontLeft);
        hwchss.motor_back_right.setPower(SpeedFrontRight);
    }

    public void driveBack (double SpeedFrontRight, double SpeedBackRight) {
        hwchss.motor_front_left.setPower(-SpeedFrontRight);
        hwchss.motor_back_right.setPower(-SpeedBackRight);
    }

    public void driveLeft (double SpeedBackLeft, double SpeedFrontRight) {
        hwchss.motor_back_left.setPower(-SpeedBackLeft);
        hwchss.motor_front_right.setPower(-SpeedFrontRight);
    }

    public void driveRight (double SpeedFrontRight, double SpeedBackLeft) {
        hwchss.motor_front_right.setPower(SpeedFrontRight);
        hwchss.motor_back_left.setPower(SpeedBackLeft);
    }


    public void turn (double speed, Direction_Enum direction){
        if (direction.equals(Direction_Enum.Right)){
            setAllMotors(speed,-speed,-speed,speed);
        }else if(direction.equals(Direction_Enum.Left)){
            setAllMotors(-speed,speed,speed,-speed);
        }
    }
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

    public void turnToDegreeV4(float degree){
        if(degree<0)
            throw new Error("negative Wert zum drehen");
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

    public void followWallBlue() {
        FarbHelfer farbHelfer = new FarbHelfer();
        turnToDegreeV4((float) (360 - 22.5));

        while(!farbHelfer.isBlue(hwChss.color_back_right)){
            if(triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)) < wallDistanceHut ){
                setAllMotors(0.2, -0.2,0.2,-0.2);
            }
            if (triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)) >= wallDistanceHut || isNaN(triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)))) {
                setAllMotors(0.2,0.2,0.2,0.2);
            } else {
                setAllMotors(0.2, 0,0.2,0);
            }
        }
    }

    private  double triDist(double i){
        return Math.cos(Math.toDegrees(45))*i;
    }


    //Detects whether a number is Nan (Not a Number)
    boolean isNaN (double zahlx){
        if (zahlx == zahlx){
            return false;
        } else {
            return true;
        }
    }
}