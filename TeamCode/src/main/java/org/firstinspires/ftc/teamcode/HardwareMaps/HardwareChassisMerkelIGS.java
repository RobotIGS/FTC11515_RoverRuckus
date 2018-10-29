/*This class is used to set the chassi specific terms directions and more to come
* created by coolPseudonym
 */
package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareChassisMerkelIGS extends HardwareChassis {
    //CONSTRUCTOR RUN ABSTRACT CLASS AND INITIALIZE HARDWARE
    public HardwareChassisMerkelIGS(HardwareMap ahwMap) {
        super(ahwMap);
        //super.init(ahwMap);
    }

    @Override
    protected void setDirections() {
        //set all directions of the motors to be used more intuitively
        motor_front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_front_left.setDirection(DcMotorSimple.Direction.FORWARD);
        motor_back_right.setDirection(DcMotorSimple.Direction.REVERSE);
        motor_back_left.setDirection(DcMotorSimple.Direction.FORWARD);

        //motor_arm.setDirection(DcMotorSimple.Direction.FORWARD);
    }


}
