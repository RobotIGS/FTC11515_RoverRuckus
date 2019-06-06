package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;

/**
 * Contains methods to let the robot drive, when we use the backup op mode.
 */
public class DistanceAlternativeTools {
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;
    private LinearOpMode opMode;

    private final long timeAdvance = 3500;
    private final long timeAdvanceRight = 5000;
    private final long timeRotate = 500;
    private final long timeDevance = 300;
    private final long timeRotateCrater = 5000;
    private final long timeDevanceCrater = 700;
    private final long timeAdvanceCrater = 3900;
    private final double powerRotateCraterWall = 0.9;
    private long callTime;

    public DistanceAlternativeTools(MotorStuff motorStuff, HardwareChassisSun hwChss, Tools tools, LinearOpMode opMode){
        this.motorStuff = motorStuff;
        this.hwChss = hwChss;
        this.opMode = opMode;
    }

    /**
     * When the robot removed the golden mineral, this method will let it drive until it registers a wall
     * @param direction From which position the robot will come. Crater or not crater left and not crater right
     */
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
                    motorStuff.setAllMotors(0,0,0.4,0);
                }
                motorStuff.setAllMotors(0,0,0,0);
                break;
            case Right:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeAdvanceRight) && !opMode.isStopRequested()){
                    motorStuff.driveInOneDirection(0.2, 0.2);
                }
                motorStuff.setAllMotors(0,0,0,0);
                callTime = System.currentTimeMillis();
                while ((!this.timeIsUp(timeRotate)) && !opMode.isStopRequested()){
                    motorStuff.setAllMotors(0.4,0,0,0);
                }
                motorStuff.setAllMotors(0,0,0,0);
                break;
            case Crater:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeAdvanceCrater) && !opMode.isStopRequested()){
                    motorStuff.setAllMotors(0,-0.4,0,-0.4);
                }
                callTime = System.currentTimeMillis();
                while ((!this.timeIsUp(timeRotateCrater)&& !opMode.isStopRequested())){
                    motorStuff.setAllMotors(0,0,this.powerRotateCraterWall,0);
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
            case Crater:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeDevanceCrater)&& !opMode.isStopRequested()) {
                    motorStuff.setAllMotors(-0.2,0,-0.2,0);
                }
                break;
        }
        motorStuff.setAllMotors(0,0,0,0);
    }


    /**
     * Checks if method has been executed a certain time
     * @param time Check if this span of time us up
     * @return true or false
     */
    public boolean timeIsUp(long time){
        if (time + this.callTime > System.currentTimeMillis()) {
            return false;
        }else{
            return true;
        }
    }
}
