package org.firstinspires.ftc.teamcode.Tools;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;

public class DistanceAlternativeTools {
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;
    private Tools tools;

    private long timeAdvance;
    private long timeRotate;
    private long callTime;

    public DistanceAlternativeTools(MotorStuff motorStuff, HardwareChassisSun hwChss, Tools tools){
        this.motorStuff = motorStuff;
        this.hwChss = hwChss;
        this.tools = tools;
    }

    public void driveToWall(Direction_Enum direction){
        switch (direction){
            case Left:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeAdvance)){
                    motorStuff.driveInOneDirection(0.2, 0.2);
                }
                motorStuff.setAllMotors(0,0,0,0);
                callTime = System.currentTimeMillis();
                while ((!this.timeIsUp(timeRotate))){
                    motorStuff.setAllMotors(0.2,0,0,0);
                }
                motorStuff.setAllMotors(0,0,0,0);
                break;
            case Right:
                callTime = System.currentTimeMillis();
                while (!this.timeIsUp(timeAdvance)){
                    motorStuff.driveInOneDirection(-0.2, -0.2);
                }
                motorStuff.setAllMotors(0,0,0,0);
                callTime = System.currentTimeMillis();
                while ((!this.timeIsUp(timeRotate))){
                    motorStuff.setAllMotors(0,0,0.2,0);
                }
                motorStuff.setAllMotors(0,0,0,0);
                break;
        }

    }



    public boolean timeIsUp(long time){
        if (time + this.callTime > System.currentTimeMillis()) {
            return false;
        }else{
            return true;
        }
    }
}
