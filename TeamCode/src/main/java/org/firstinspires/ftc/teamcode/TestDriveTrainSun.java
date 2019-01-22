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
import org.firstinspires.ftc.teamcode.Tools.TurnStuffCalibration;

@TeleOp
public class TestDriveTrainSun extends LinearOpMode{
    //declare variable to be used for setting the power of the motors
    private DriveHoverUnOptimized driveUnOp;
    private DriveHoverOptimized driveOp;
    private TurnStuffCalibration cal;

    //declare given hardwaremap as MerkelIGS

    private HardwareChassisSun ghwchss;
    //declare motor stuff object to use setAllMotors command
    private MotorStuff motstff;

    //private LinearOpMode opMode;

    float[] array = new float[7];
    int rand;
    @Override
    public void runOpMode() throws InterruptedException {
            //initialize given hardwaremap to Sun
            ghwchss = new HardwareChassisSun(hardwareMap);
            //hand over MerkelIGS hardwaremap and initialize motor stuff
            motstff = new MotorStuff(ghwchss, hardwareMap);
            //get objects from DriveMode Classes
            driveOp = new DriveHoverOptimized();
            driveUnOp = new DriveHoverUnOptimized();
            cal = new TurnStuffCalibration(motstff);




        /*
        array = new float[7];
         for(float i = 1; i<=7;i++){
             array[(int)(i-1)] = i*45;
         }
         rand = (int)(Math.floor(Math.random()*7));

            //>telemetry.addData("degree", array[rand]);
            //telemetry.update();
            //for (double t = System.currentTimeMillis(); t + 5000 > System.currentTimeMillis();t=t)
            //waitForStart();
       // motstff.turnToDegreeV4(array[rand]);


        telemetry.addData("speed",cal.getminimumapeed());
        telemetry.update();

        cal.calculateAverage(150);*/
        //cal.getminimumapeed();

        //cal.gowaitinkitchen(1);
       // telemetry.addData("asfs",cal.calculateAverage(150));
        //telemetry.update();
        //double[] test = new double[2];

        //motstff.turnToDegreeV4(90); //this "works"

        //cal.gowaitinkitchen(2); //this works

        //telemetry.addData("minimum speed is:",cal.getminimumapeed()); //this works

        telemetry.addData("the average overshooting with smoothness 120 is:",cal.calculateAverage(120));
        //motstff.turnToDegreeV4(90);
        //cal.calculateAverage(100);
        //cal.gowaitinkitchen(1);

        //test = cal.calibration();
        //telemetry.addData("minspeed",test[0]);
        //telemetry.addData("smooth",test[1]);
        telemetry.addData("Ein Hinweis!",69);
        telemetry.update();
        cal.gowaitinkitchen(20);
        //cal.gowaitinkitchen(1000);
        }

//NEEDS TO BE MOVED TO MOTSTUFF BUT NEEDS TESTING IF STILL FUNKTONING PROPERLY
    //IT IS CURRENTLY WORKING BUT NEEDS BIG IMPROVEMENTS TO BE ABLE TO BE USED IN THE FINAL AUTOONOMUS PERIOD
    public void turnToDegreeV4inopmode(float degree){
        if(degree<0)
            throw new Error("negative Wert zum drehen");
        double difference = 2;
        /*mby remove*/degree = 360 - degree;
        float goal = (motstff.getDegree() + degree)%360;
        while(difference>1 || difference<-1){
            difference = -1*/*Math.abs*/(goal-motstff.getDegree());
            this.motstff.turn(motstff.personalTanH(difference/motstff.SMOOTHNESS),Direction_Enum.Right);
        }
    }
}
