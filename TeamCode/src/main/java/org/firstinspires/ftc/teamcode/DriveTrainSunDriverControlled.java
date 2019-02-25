package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverOptimized;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

public class DriveTrainSunDriverControlled extends OpMode {
    //declare an Object of Optimized Drive Mode we have decided to use this mode due to its practicality
    private DriveHoverOptimized driveOp;
    //declare given hardwaremap as SunChassis
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;

    @Override
    public void init() {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over Sun hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss);
        //get objects from DriveMode Classes
        driveOp = new DriveHoverOptimized();
    }

    @Override
    public void loop() {
        //this Part is for driving a bit like hovering
        //calculate the needed optimal speed for every motor in its direction
        driveOp.drive(gamepad1.left_stick_x,-gamepad1.left_stick_y, gamepad1.right_trigger);
        //drive with calculated values
        motstff.setAllMotors(driveOp.driveSpeedY, driveOp.driveSpeedX, driveOp.driveSpeedY, driveOp.driveSpeedX);

        //to turn the robot if wanted
        motstff.turnWithGamepad(gamepad1.left_bumper,gamepad1.right_bumper,1);

        //Room to add stuff like Arm, collector etc.
    }
}
