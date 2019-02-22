package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.hardware.ColorSensor;

public class Tools {

    /**
     * pauses the program for additional seconds
     * @param timeStop double, in Milliseconds
     */
    public void stopForSeconds (double timeStop) {
        double time = System.currentTimeMillis();

        while (System.currentTimeMillis() < time + timeStop) {        }
    }

    public void driveLeftToBlueLine (ColorSensor sensor, FarbHelfer helfer, MotorStuff motor) {
        while (!helfer.isBlue(sensor)){
            motor.setAllMotors(0, -0.2, 0, -0.2);

        }
        motor.setAllMotors(0,0,0,0);
    }
    public void driveRightToBlueLine (ColorSensor sensor, FarbHelfer helfer, MotorStuff motor){
        while (!helfer.isBlue(sensor)){
            motor.setAllMotors(0, 0.2, 0, 0.2);
        }
        motor.setAllMotors(0,0,0,0);
    }


}

