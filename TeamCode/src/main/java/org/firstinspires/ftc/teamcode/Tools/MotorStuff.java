/*This class is used for shortcuts e.g. the setAllMotors method used to set all motors at once instead of having to set all of them individually
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareGyro;

public class MotorStuff {

    //Declare a variable to hand over the right wanted hardwaremap for the right layout
    private HardwareChassis hwchss;
    private HardwareGyro hwgy;
    //private OpMode opMde;
    private final int TTD_TAN_SMOOTHNESS = 180;
    private double ttd_difference;
    private double ttd_goal;
    /**
     * Constructor
     * @param _hwchss the hardwaremap object that should be used
     */

    public MotorStuff(HardwareChassis _hwchss, HardwareMap hardwareMap) {
        hwchss = _hwchss;
        hwgy = new HardwareGyro(hardwareMap);
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
    //Paul, sorry for bad coding
    public void driveInOneDirection (double SpeedFrontLeft, double SpeedFrontRight) {
        hwchss.motor_front_left.setPower(SpeedFrontLeft);
        hwchss.motor_back_right.setPower(SpeedFrontRight);
    }

    public void driveBack (double SpeedFrontRight, double SpeedBackRight) {
        hwchss.motor_front_left.setPower(-SpeedFrontRight);
        hwchss.motor_back_right.setPower(-SpeedBackRight);
    }

    public void driveLeft (double SpeedFrontLeft, double SpeedBackRight) {
        hwchss.motor_back_left.setPower(-SpeedFrontLeft);
        hwchss.motor_front_right.setPower(-SpeedBackRight);
    }

    public void driveRight (double SpeedFrontRight, double SpeedBackLeft) {
        hwchss.motor_front_right.setPower(SpeedFrontRight);
        hwchss.motor_back_left.setPower(SpeedBackLeft);
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
        Orientation angles;
        angles = hwgy.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        return angles.firstAngle + 180;
    }

    public HardwareGyro getHwgy() {
        return hwgy;
    }

    public void setHwgy(HardwareGyro hwgy) {
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
            this.turn(this.personalTanH(difference/180),Direction_Enum.Right);
        }
    }
    private double personalTanH(double i){
        double minSpeed = 0.18;
        double o = Math.tanh(i);
        if (o <minSpeed && o>0){ o = 0.18;}
        if(o> -minSpeed && o <0){o = -0.18;}
        return 0;
    }
}
