/*This class is used to test everything related to this chassi in driver controlled period
 * created by coolPseudonym
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp
public class TestDriveTrainSun extends OpMode{
    //declare variable to be used for setting the power of the motors
    private double driveSpeed;
    //declare given hardwaremap as MerkelIGS
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;

    @Override
    public void init() {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over MerkelIGS hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss);
    }

    @Override
    //MAIN THESE CONCEPTS WILL BE OVERTHROWN IN THE NEAR FUTURE SINCE THIS IS JUST A PROOF OF CONCEPT AND TESTING
    public void loop() {
        driveSpeed = gamepad1.right_trigger;
        //This if else statements will be changed to event listeners if there`s time also the ability to drive in all 360 degrees

        if (gamepad1.dpad_up) {
            motstff.setAllMotors(driveSpeed, 0, 0, driveSpeed);
        } else if (gamepad1.dpad_down) {
            motstff.setAllMotors(-driveSpeed, 0, 0, -driveSpeed);
        } else if (gamepad1.dpad_right) {
            motstff.setAllMotors(0, driveSpeed, driveSpeed, 0);
        } else if (gamepad1.dpad_left) {
            motstff.setAllMotors(0, -driveSpeed, -driveSpeed, 0);
        } else if (gamepad1.a) {
            motstff.setAllMotors(0, 0.5, 0, 0);
        } else if(gamepad1.b){
            motstff.setAllMotors(0, -0.25, 0, 0);
        }else{
            //set all motors to 0 if no button is pressed
            motstff.setAllMotors(0,0,0,0);
        }
    }
}

