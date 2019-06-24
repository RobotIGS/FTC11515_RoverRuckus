package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassis;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;

public class Tools {
    private LinearOpMode opMode;

    public Tools(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    /**
     * pauses the program for additional seconds
     * @param timeStop double, in Milliseconds
     */
    public void stopForMilliSeconds(double timeStop) {
        double time = System.currentTimeMillis();

        while ((System.currentTimeMillis() < time + timeStop) && !opMode.isStopRequested()) {}
    }

    /**
     * Lets the robot drive left to a blue line
     * @param sensor Sensor to register the line with
     * @param helfer ColorHelper object, initialized
     * @param motor MotorStuff object, initialized
     */
    public void driveLeftToBlueLine (ColorSensor sensor, FarbHelfer helfer, MotorStuff motor) {
        while (!helfer.isBlue(sensor) && !opMode.isStopRequested()){
            motor.setAllMotors(0, -0.2, 0, -0.2);
        }
        motor.setAllMotors(0,0,0,0);
    }
    /**
     * Lets the robot drive right to a blue line
     * @param sensor Sensor to register the line with
     * @param helfer ColorHelper object, initialized
     * @param motor MotorStuff object, initialized
     */
    public void driveRightToBlueLine (ColorSensor sensor, FarbHelfer helfer, MotorStuff motor){
        while (!helfer.isBlue(sensor) && !opMode.isStopRequested()){
            motor.setAllMotors(0, 0.2, 0, 0.2);
        }
        motor.setAllMotors(0,0,0,0);
    }

    public void kickMarkerLeft(HardwareChassisSun hwChss) {
        hwChss.servoMarkerLeft.setPosition(0);
        stopForMilliSeconds(1000);
        hwChss.servoMarkerLeft.setPosition(90);
        stopForMilliSeconds(1000);
    }
    public void kickMarkerRight(HardwareChassisSun hwChss) {
        hwChss.servoMarkerRight.setPosition(90);
        stopForMilliSeconds(1000);
        hwChss.servoMarkerRight.setPosition(0);
        stopForMilliSeconds(1000);
    }


}

