/*This class is used to test everything related to this chassi in driver controlled period
 * created by coolPseudonym
 */
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverOptimized;
import org.firstinspires.ftc.teamcode.DriveModes.DriveHoverUnOptimized;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.Direction_Enum;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;

@TeleOp
public class TestDriveTrainSun extends LinearOpMode{
    //declare variable to be used for setting the power of the motors
    private DriveHoverUnOptimized driveUnOp;
    private DriveHoverOptimized driveOp;

    //declare given hardwaremap as MerkelIGS
    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;


    @Override
    public void runOpMode() throws InterruptedException {
        //initialize given hardwaremap to Sun
        ghwchss = new HardwareChassisSun(hardwareMap);
        //hand over MerkelIGS hardwaremap and initialize motor stuff
        motstff = new MotorStuff(ghwchss, hardwareMap);
        //get objects from DriveMode Classes
        driveOp = new DriveHoverOptimized();
        driveUnOp = new DriveHoverUnOptimized();
        //default mode is 0
        //mode = true;
            telemetry.addLine("1syd");
            telemetry.update();
            turnToDegreeV4(90);
            for(;;){}
            //mode = false;
            //telemetry.addLine("2ads");
            //telemetry.update();
        }

//NEEDS TO BE MOVED TO MOTSTUFF BUT NEEDS TESTING IF STILL FUNKTONING PROPERLY
    //IT IS CURRENTLY WORKING BUT NEEDS BIG IMPROVEMENTS TO BE ABLE TO BE USED IN THE FINAL AUTOONOMUS PERIOD
    public void turnToDegreeV4(float degree){
        double difference = 2;
        /*mby remove?*/degree = 360 - degree;
        if(degree > 0){
            float goal = (motstff.getDegree() + degree)%360;
            while(difference>1 || difference<-1){
                difference = -1*/*Math.abs*/(goal-motstff.getDegree());
                motstff.turn(Math.tanh(difference/180),Direction_Enum.Right);
                telemetry.addData("diff",difference);
                telemetry.addData("degree",motstff.getDegree());
                telemetry.update();
            }
        }else{
            float goal = (motstff.getDegree() - degree );
            while(difference>1 || difference<-1){
                difference = /*Math.abs*/(goal-motstff.getDegree());
                motstff.turn(Math.tanh(difference/180),Direction_Enum.Left);
            }
        }
    }
}
