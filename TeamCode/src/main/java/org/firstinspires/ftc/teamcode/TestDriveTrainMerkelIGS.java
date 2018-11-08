/*This class is used to test everything related to this chassi in driver controlled period
* created by coolPseudonym
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisMerkelIGS;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp
public class TestDriveTrainMerkelIGS extends OpMode {
    //declare variable to be used for setting the power of the motors
    private float driveSpeed;
    //declare given hardwaremap as MerkelIGS
    HardwareChassisMerkelIGS ghwchss;
    //declare motor stuff object to use setAllMotors command
    MotorStuff motstff;

    @Override
    public void init() {
        //initialize given hardwaremap to MerkelIGS
        ghwchss = new HardwareChassisMerkelIGS(hardwareMap);
        //hand over MerkelIGS hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss);
    }

    @Override
    //MAIN THESE CONCEPTS WILL BE OVERTHROWN IN THE NEAR FUTURE SINCE THIS IS JUST A PROOF OF CONCEPT AND TESTING
    public void loop() {
        //set drivespeed as value of the right trigger to have a variable speed
        //driveSpeed = gamepad1.right_trigger;
        //This if else statements will be changed to event listeners if there`s time also the ability to drive in all 360 degrees
        if(gamepad1.right_stick_y != 0) {
            motstff.setAllMotors(gamepad1.right_stick_y, gamepad1.right_stick_y, gamepad1.right_stick_y, gamepad1.right_stick_y);
        }
        //Turn
        if(gamepad1.left_stick_x < 0 ) {
            motstff.setAllMotors(gamepad1.left_stick_x, -gamepad1.left_stick_x, gamepad1.left_stick_x,-gamepad1.left_stick_x);
        }
        if(gamepad1.left_stick_x > 0 ) {
            motstff.setAllMotors(-gamepad1.left_stick_x, gamepad1.left_stick_x, -gamepad1.left_stick_x, gamepad1.left_stick_x);
        }

            /*
        } else if(gamepad1.dpad_down){
            motstff.setAllMotors(-driveSpeed,-driveSpeed,-driveSpeed,-driveSpeed);
        }else if(gamepad1.dpad_left){
            motstff.setAllMotors(-driveSpeed,driveSpeed,driveSpeed,-driveSpeed);
        }else if(gamepad1.dpad_right){
            motstff.setAllMotors(driveSpeed,-driveSpeed,-driveSpeed,driveSpeed);
        }else{
            //set all motors to 0 if no button is pressed
            motstff.setAllMotors(0,0,0,0);
        }
        */
        if (gamepad1.left_trigger != 0) {
            ghwchss.lift.setPower(gamepad1.left_trigger);

        } else if (gamepad1.right_trigger != 0) {
            ghwchss.lift.setPower(-gamepad1.left_trigger);
        } else {
            ghwchss.lift.setPower(0);
        }

        if (gamepad1.dpad_up){
            ghwchss.liftExtend.setPower(0.5);
        } else if (gamepad1.dpad_down) {
            ghwchss.liftExtend.setPower(0.5);
        } else {
            ghwchss.liftExtend.setPower(0);
        }
    }
}
