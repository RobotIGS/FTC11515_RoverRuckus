/*This class is used to set the chassi specific terms directions and more to come
* created by coolPseudonym
* Deprecated due to the fact that we wont use this type of chassi
 */

package org.firstinspires.ftc.teamcode.Deprecated.java.Depracated;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
@Deprecated
public class HardwareChassisMerkelIGS extends HardwareChassis {
    public DcMotor lift = null;
    public DcMotor liftExtend = null;

    //CONSTRUCTOR RUN ABSTRACT CLASS AND INITIALIZE HARDWARE
    public HardwareChassisMerkelIGS(HardwareMap ahwMap) {
        super(ahwMap);
        lift = ahwMap.get(DcMotor.class, "lift");
        liftExtend = ahwMap.get(DcMotor.class, "lift_extend");
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
