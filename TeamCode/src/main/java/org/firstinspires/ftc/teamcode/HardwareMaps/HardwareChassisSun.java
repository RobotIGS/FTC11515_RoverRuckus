/*This class is used to set the chassi specific terms directions and more to come
 * created by coolPseudonym
 */
package org.firstinspires.ftc.teamcode.HardwareMaps;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareChassisSun extends HardwareChassis{
    public DistanceSensor distance_left;
    public DistanceSensor distance_right;
    public ColorSensor color_back_right;
    public ColorSensor color_back_left;
    public DistanceSensor distance_back_left;
    public DistanceSensor distance_back_right;
    public DcMotor motor_pull;



    //CONSTRUCTOR RUN ABSTRACT CLASS AND INITIALIZE HARDWARE



    public HardwareChassisSun(HardwareMap ahwMap) {
        super(ahwMap);
        distance_left = ahwMap.get(DistanceSensor.class, "color_distance_front_left");
        distance_right= ahwMap.get(DistanceSensor.class, "color_distance_front_right");
        //color_back_left= ahwMap.get(ColorSensor.class, "color_distance_back_left"); //?????
        color_back_right= ahwMap.get(ColorSensor.class, "color_distance_back_right");
        //servoCam = ahwMap.get(Servo.class,  "Front_Cam_Motion");
        //servoCam = ahwMap.servo.get("Front_Cam_Motion");



        //super.init(ahwMap);
        distance_left = ahwMap.get(DistanceSensor.class, "color_distance_front_left");
        distance_right= ahwMap.get(DistanceSensor.class, "color_distance_front_right");
        color_back_left= ahwMap.get(ColorSensor.class, "color_distance_back_left");
        color_back_right= ahwMap.get(ColorSensor.class, "color_distance_back_right");
        distance_back_left = ahwMap.get(DistanceSensor.class, "color_distance_back_left");
        distance_back_right = ahwMap.get(DistanceSensor.class, "color_distance_back_right");

        motor_pull = ahwMap.get(DcMotor.class, "motor_pull");
        motor_pull.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    @Override
    //Inherited from parent
    protected void setDirections() {
        //set all directions of the motors to be used more intuitively
        motor_front_right.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_back_left.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}