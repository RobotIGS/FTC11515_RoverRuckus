/*This class is used to test everything related to this chassi in driver controlled period
 * created by coolPseudonym
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverOptimized;
import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverUnOptimized;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.Direction_Enum;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp
public class TestDriveTrainSun extends OpMode{
    //declare variable to be used for setting the power of the motors
    private DriveHoverUnOptimized driveUnOp;
    private DriveHoverOptimized driveOp;

    //declare given hardwaremap as MerkelIGS
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;

    private double driveSpeedX;
    private double driveSpeedY;


    private boolean mode;

    @Override
    public void init() {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over MerkelIGS hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss, hardwareMap);
        //get objects from DriveMode Classes
        driveOp = new DriveHoverOptimized();
        driveUnOp = new DriveHoverUnOptimized();
        //default mode is 0
        mode = true;
    }

    @Override
    public void loop() {
        telemetry.addData(motstff.getHwgy().);
        if(mode) {
            motstff.turnToDegree(90);
            mode = false;
        }
        /*driveOp.drive(gamepad1.left_stick_x,-gamepad1.left_stick_y, gamepad1.right_trigger);
        driveUnOp.drive(gamepad1.left_stick_x,-gamepad1.left_stick_y, gamepad1.right_trigger);

        telemetry.addData("Mode:", mode);
        if(gamepad1.y){
            mode++;
        }
        if (mode == 0){
            this.driveSpeedX = driveOp.driveSpeedX;
            this.driveSpeedY = driveOp.driveSpeedY;
        } else if(mode == 1){
            this.driveSpeedX = driveUnOp.driveSpeedX;
            this.driveSpeedY = driveUnOp.driveSpeedY;
        }else{
            mode = 0;
        }
        if (gamepad1.right_bumper){
            motstff.turn(1,Direction_Enum.Right);
        }else if(gamepad1.left_bumper){
            motstff.turn(1,Direction_Enum.Left);
        }
        telemetry.update();

        motstff.setAllMotors(this.driveSpeedY, this.driveSpeedX, this.driveSpeedY, this.driveSpeedX);*/
        }
}

