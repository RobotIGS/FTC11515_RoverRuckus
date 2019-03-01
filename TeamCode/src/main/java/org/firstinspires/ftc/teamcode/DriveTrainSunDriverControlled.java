package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.sun.source.util.TaskEvent;

import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverOptimized;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
@TeleOp (name = "Driver Controlled with arm")

//this dirve method is for chassis SunnyBoy
public class DriveTrainSunDriverControlled extends OpMode {
    //declare an Object of Optimized Drive Mode we have decided to use this mode due to its practicality
    private DriveHoverOptimized driveOp;
    //declare given hardwaremap as SunChassis
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;
    //declare motors for arm motion
    private DcMotor motor_arm_lift;
    private DcMotor motor_arm_tilt;

    @Override
    public void init() {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over Sun hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss);
        //get objects from DriveMode Classes
        driveOp = new DriveHoverOptimized();
        //initialize motors for arm motion
        motor_arm_lift = hardwareMap.get(DcMotor.class, "motor_arm_lift");
        motor_arm_tilt = hardwareMap.get(DcMotor.class, "motor_arm_tilt");
    }

    @Override
    public void loop() {
       /*
        //this Part is for driving a bit like hovering
        //calculate the needed optimal speed for every motor in its direction
        driveOp.drive(gamepad1.left_stick_x,-gamepad1.left_stick_y, gamepad1.right_trigger);
        //drive with calculated values
        motstff.setAllMotors(driveOp.driveSpeedY, driveOp.driveSpeedX, driveOp.driveSpeedY, driveOp.driveSpeedX);
        */
       //we don't need to drive diagonal

        //drive with dpad for direction and trigger for speed


        if (gamepad1.dpad_up) { //drive forward
            motstff.driveInOneDirection(gamepad1.right_trigger, gamepad1.right_trigger);
        }
        if (gamepad1.dpad_down) { //drive backwards
            motstff.driveBack(gamepad1.right_trigger, gamepad1.right_trigger);
        }
        if (!gamepad1.dpad_up &&  !gamepad1.dpad_down) {
            motstff.driveInOneDirection(0, 0);
        }


        if (gamepad1.dpad_left) { //drive left
            motstff.driveLeft(gamepad1.right_trigger,  gamepad1.right_trigger);
        }
        if (gamepad1.dpad_right) { //drive right
            motstff.driveRight(gamepad1.right_trigger,gamepad1.right_trigger);
        }
        if (!gamepad1.dpad_left && !gamepad1.dpad_right) {
            motstff.driveLeft(0, 0);
        }




        //to turn the robot if wanted
        motstff.turnWithGamepad(gamepad1.left_bumper,gamepad1.right_bumper,1);

        //controlling arm
        if (gamepad2.dpad_up) {
            motor_arm_lift.setPower(0.3); //arm ausfahren //0.3
        } else {
            motor_arm_lift.setPower(0);
        }

        if (gamepad2.dpad_down) {
            motor_arm_lift.setPower(-0.4); //arm einfahren //0.3
        } else {
            motor_arm_lift.setPower(0);
        }

        if (gamepad2.a) {
                motor_arm_tilt.setPower(0.1); //winkel arm nach oben
                motor_arm_lift.setPower(-0.4); //arm parallel einfahren, add until feedback //0.3
            } else {
            motor_arm_tilt.setPower(0);
            motor_arm_lift.setPower(0);
        }

        if (gamepad2.b) {
            motor_arm_tilt.setPower(-0.1); //winkel arm nach unten
            motor_arm_lift.setPower(-0.4); //arm parallel einfahren, add until feedback //0.3
            } else {
            motor_arm_tilt.setPower(0);
            motor_arm_lift.setPower(0);
            }


        //add collector etc.

    }
}
