/*This class is used to test everything related to this chassis in driver controlled period
 * created by coolPseudonym //Nope
 *
 * Paul: I stole Nils code and changed it I'm SO EVIL, I WILL TAKE OVER THE WORLD!!!
 *
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
public class TestDriveTrainSun_Threads extends OpMode{
    //declare variable to be used for setting the power of the motors
    private DriveHoverUnOptimized driveUnOp;
    private DriveHoverOptimized driveOp;

    //private double proportion;

    //declare given hardwaremap as MerkelIGS
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;

    private double X;
    private double Y;


    private byte mode;

    @Override
    public void init() {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over MerkelIGS hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss);

        driveOp = new DriveHoverOptimized();
        driveUnOp = new DriveHoverUnOptimized();

        mode = 0;

        Thread drive = new Thread(new Runnable() {
            @Override
            public void run() {
                driveOp.drive(gamepad1.left_stick_x,-gamepad1.left_stick_y, gamepad1.right_trigger);
                driveUnOp.drive(gamepad1.left_stick_x,-gamepad1.left_stick_y, gamepad1.right_trigger);
                run();
            }
        });

    }

    @Override
    //MAIN THESE CONCEPTS WILL BE OVERTHROWN IN THE NEAR FUTURE SINCE THIS IS JUST A PROOF OF CONCEPT AND TESTING
    public void loop() {


        telemetry.addData("Mode:", mode);
        if(gamepad1.y){
            mode++;
        }

        if (mode == 0){
            X = driveOp.driveSpeedX;
            Y = driveOp.driveSpeedY;
        } else if(mode == 1){
            X = driveUnOp.driveSpeedX;
            Y = driveUnOp.driveSpeedY;
        }else{
            mode = 0;
        }

        if (gamepad1.right_bumper){
            motstff.turn(1,Direction_Enum.Right);
        }else if(gamepad1.left_bumper){
            motstff.turn(1,Direction_Enum.Left);
        }
        /*telemetry.addData("SpeedX", driveOp.driveSpeedX);
        telemetry.addData("SpeedY", driveOp.driveSpeedY);
*/
        telemetry.update();

        motstff.setAllMotors(Y,X,Y,X);
        }
}

