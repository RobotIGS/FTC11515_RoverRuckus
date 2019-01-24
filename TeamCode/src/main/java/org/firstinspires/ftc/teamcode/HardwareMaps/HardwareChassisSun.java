/*This class is used to set the chassi specific terms directions and more to come
 * created by coolPseudonym
 */
package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareChassisSun extends HardwareChassis{
    public DistanceSensor distance_left;
    public DistanceSensor distance_right;
    public ColorSensor color_back_left;
    public ColorSensor color_back_right;



    //CONSTRUCTOR RUN ABSTRACT CLASS AND INITIALIZE HARDWARE
    public HardwareChassisSun(HardwareMap ahwMap) {
        super(ahwMap);
        distance_left = ahwMap.get(DistanceSensor.class, "color_distance_front_left");
        distance_right= ahwMap.get(DistanceSensor.class, "color_distance_front_right");
        color_back_left= ahwMap.get(ColorSensor.class, "color_distance_front_right"); //?????
        color_back_right= ahwMap.get(ColorSensor.class, "color_distance_front_right");


        //super.init(ahwMap);
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