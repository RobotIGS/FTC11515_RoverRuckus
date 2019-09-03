package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverOptimized;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.Direction_Enum;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@Disabled
@TeleOp (name =  "PressConference")
public class DriveRobotPress extends OpMode {
    //declare an Object of Optimized Drive Mode we have decided to use this mode due to its practicality
    private DriveHoverOptimized driveOp;
    //declare givegbgn hardwaremap as SunChassis
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;
    //declare motors for arm motion

    private DcMotor motor_pull;


    private DcMotor motor_sweep;
    private DcMotor motor_driveOut;
    private Servo servo_collector;

    @Override
    public void init() {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over Sun hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss);
        //get objects from DriveMode Classes
        driveOp = new DriveHoverOptimized();
        //initialize motors for arm motion


        motor_pull = hardwareMap.get(DcMotor.class, "motor_pull");
        motor_pull.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        servo_collector = hardwareMap.get(Servo.class, "servo_collector");
        motor_sweep = hardwareMap.get(DcMotor.class, "motor_sweep");
        motor_driveOut = hardwareMap.get(DcMotor.class, "motor_driveOut");


    }

    @Override
    public void loop() {
        if(gamepad1.right_trigger != 0) {
            motstff.driveInOneDirection(gamepad1.right_trigger, gamepad1.right_trigger);
        }
        if(gamepad1.left_trigger != 0) {
            motstff.driveBack(gamepad1.left_trigger, gamepad1.left_trigger);
        }
        /*if(!gamepad1.left_bumper && !gamepad1.right_bumper) {
            motstff.driveInOneDirection(0,0);
        }*/
        if(gamepad1.dpad_left) {
            motstff.turn(0.5, Direction_Enum.Left);
        }
        if(gamepad1.dpad_right) {
            motstff.turn(0.5, Direction_Enum.Right);
        }
        if(!gamepad1.dpad_left && !gamepad1.dpad_right) {
            ghwchss.motor_front_right.setPower(0);
            ghwchss.motor_back_left.setPower(0);
        }

        if(gamepad1.left_stick_y > 0) {
            ghwchss.motor_pull.setPower(0.5);
        }
        if(gamepad1.left_stick_y < 0) {
            ghwchss.motor_pull.setPower(-0.5);
        }
        if(gamepad1.left_stick_y == 0) {
            ghwchss.motor_pull.setPower(0);
        }
        if (!gamepad1.dpad_left && !gamepad1.dpad_right && gamepad1.left_trigger == 0 && gamepad1.right_trigger == 0 ) {
            motstff.setAllMotors(0,0,0,0);
        }

    }
}








