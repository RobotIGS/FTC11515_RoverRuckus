/* This abstract class is used to create a construkt for all Chassis since this season there will be more than one.
*  Here all general settings for the (yet only) motors which are used by all other inherited basis classes are set.
*  created by coolPseudonym & dreadjack
 */

package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class HardwareChassis {
    //declare all 4 motors as DcMotor to be used furthermore
    public DcMotor motor_front_right = null;
    public DcMotor motor_front_left = null;
    public DcMotor motor_back_right = null;
    public DcMotor motor_back_left = null;

    //declare a variable to get easier use of the right Hardwaremap
    private HardwareMap hwmap = null;
    //CONSTRUKTOR GETS HARDWAREMAP OF RIGHT LAYOUT
    public HardwareChassis(HardwareMap ahwMap) {
        //run init hands over hardwaremap of right layout
        init(ahwMap);
        //run setDirections
        setDirections();
    }

    //INIT SHOULD RUN WHEN CONSTRUKTED GETS HARDWAREMAP OF RIGHT LAYOUT
    public void init(HardwareMap hwMap) {
        //initialize motors with directs to Expansion Hub
        motor_front_right = hwMap.get(DcMotor.class, "motor_front_right");
        motor_front_left = hwMap.get(DcMotor.class, "motor_front_left");
        motor_back_right = hwMap.get(DcMotor.class, "motor_back_right");
        motor_back_left = hwMap.get(DcMotor.class, "motor_back_left");

        //set all motors to 0 to stop possible errors caused by not doing this since "doppelt hält besser"
        motor_front_right.setPower(0);
        motor_front_left.setPower(0);
        motor_back_right.setPower(0);
        motor_back_left.setPower(0);

        //set all motors to run without Encoder because we had alot of issues with them e.g. stuttering MAY BE REMOVED SOON SINCE I WILL TEST THEM ONCE AGAIN
        motor_front_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_front_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_back_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_back_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //set all motors to brake if they`re set to no power especially beacause we got a extending arm which needs do stay in place MAY BE REMOVED IF UNKNOWN PROBLEMS POP UP
        motor_front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor_front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor_back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor_back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    //force a method to set the right directions per wheel-layout
    abstract protected void setDirections();
}