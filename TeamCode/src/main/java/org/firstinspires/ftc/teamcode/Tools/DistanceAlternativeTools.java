package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;

public class DistanceAlternativeTools {
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;
    private Tools tools;
    private LinearOpMode opMode;
    private FarbHelfer blueline;

    private long timeAdvance = 5000;
    private long timeRotate = 1000;
    private long timeDevance = 300;
    private long timeRotateCrater = 3000;
    private long timeDevanceCrater = 400;
    private long timeAdvanceCrater = 4500;
    private long callTime;

    public DistanceAlternativeTools(MotorStuff motorStuff, HardwareChassisSun hwChss, Tools tools, LinearOpMode opMode){
        this.motorStuff = motorStuff;
        this.hwChss = hwChss;
        this.tools = tools;
        blueline = new FarbHelfer();
        this.opMode = opMode;
    }

    public void driveToWall(Direction_Enum direction){
        switch (direction){
            case Left:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeAdvance) && !opMode.isStopRequested()){
                    motorStuff.driveInOneDirection(0.2, 0.2);
                }
                motorStuff.setAllMotors(0,0,0,0);
                callTime = System.currentTimeMillis();
                while ((!this.timeIsUp(timeRotate)) && !opMode.isStopRequested()){
                    motorStuff.setAllMotors(0.4,0,0,0);
                }
                motorStuff.setAllMotors(0,0,0,0);
                break;
            case Right:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeAdvance) && !opMode.isStopRequested()){
                    motorStuff.driveInOneDirection(0.2, 0.2);
                }
                motorStuff.setAllMotors(0,0,0,0);
                callTime = System.currentTimeMillis();
                while ((!this.timeIsUp(timeRotate)) && !opMode.isStopRequested()){
                    motorStuff.setAllMotors(0,0,0.4,0);
                }
                motorStuff.setAllMotors(0,0,0,0);
                break;
            case BlueCrater:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeAdvanceCrater) && !opMode.isStopRequested()){
                    motorStuff.setAllMotors(0,-0.2,0,-0.2);
                }
                callTime = System.currentTimeMillis();
                while ((!this.timeIsUp(timeRotateCrater)&& !opMode.isStopRequested())){
                    motorStuff.setAllMotors(0,0,0.9,0);
                }
                motorStuff.setAllMotors(0,0,0,0);
                break;
        }

    }

    public void driveBackFromWall(Direction_Enum direction){
        switch (direction){
            case Left:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeDevance)&& !opMode.isStopRequested()) {
                    motorStuff.setAllMotors(-0.2,0,-0.2,0);
                }
                break;
            case Right:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeDevance)&& !opMode.isStopRequested()) {
                    motorStuff.setAllMotors(-0.2,0,-0.2,0);
                }
                break;
            case BlueCrater:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeDevanceCrater)&& !opMode.isStopRequested()) {
                    motorStuff.setAllMotors(-0.2,0,-0.2,0);
                }
                break;
        }
        motorStuff.setAllMotors(0,0,0,0);
    }


    public boolean timeIsUp(long time){
        if (time + this.callTime > System.currentTimeMillis()) {
            return false;
        }else{
            return true;
        }
    }
}
