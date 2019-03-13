package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;



/*
    This class includes tools to drive using the distance sensors.
    Therefore a chassis that includes distance sensors is required.

    author: @lena @paul
 */

public class DistanceTools {
    private final double wallDistance = 6;
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;
    private Tools tools;
    private LinearOpMode opMode;

    /**
     * Standard constructor
      * @param motorStuff Object is needed, so the method can drive in one direction
     * @param hwChss This is needed, so the method can access the motors and sensors
     * @param tools contains stop and further methods
     */
    public DistanceTools(MotorStuff motorStuff, HardwareChassisSun hwChss, Tools tools, LinearOpMode opMode) {
        this.motorStuff = motorStuff;
        this.hwChss = hwChss;
        this.tools = tools;
        this.opMode = opMode;
    }

    /**
     * When the robot removed the golden mineral, this method will let it drive until it registers a wall
     * @param direction Whether the robot will hit the wall with it's left or it's right side
     */
    public void driveToWall(Direction_Enum direction) {
        //Switch case to differ between statements
        switch (direction) {
            case Left:
                //Drives until left sensor registers a wall.
                while (!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM)) && !opMode.isStopRequested()) {
                    motorStuff.driveInOneDirection(0.2, 0.2);
                }
                motorStuff.setAllMotors(0, 0, 0, 0);
                //Turns until other (right)  sensor also registers a wall, so the robot is parallel to the wall
                while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM)) && !opMode.isStopRequested()) {
                    hwChss.motor_front_right.setPower(-0.2);
                    hwChss.motor_back_right.setPower(0.2);
                }
                break;
            case Right:
                //Drives until right sensor registers a wall.
                while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM)) && !opMode.isStopRequested()) {
                    motorStuff.driveInOneDirection(0.2, 0.2); //drive forward
                }
                motorStuff.setAllMotors(0, 0, 0, 0);

                //Turns until other (left)  sensor also registers a wall, so the robot is parallel to the wall
                /*while (hwChss.distance_left.getDistance(DistanceUnit.MM) != hwChss.distance_right.getDistance(DistanceUnit.MM)) {
                    hwChss.motor_front_left.setPower(0.2);
                    hwChss.motor_back_left.setPower(-0.2);
                }*/
                motorStuff.setAllMotors(0, 0, 0, 0);
                break;

            case BlueCrater:
                //set all motors 0
                motorStuff.setAllMotors(0,0,0,0);
                //Drives until left sensor registers a wall.
                while (!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM)) && !opMode.isStopRequested()) {
                    motorStuff.driveLeft(0.2, 0.2);

                }
                motorStuff.setAllMotors(0, 0, 0, 0);
                break;
        }

        motorStuff.setAllMotors(0, 0, 0, 0);

    }
    /**
     * Checks whether a certain double is NaN
     * This is useful, as the distance sensors return NaN if the distance is too high
     * @param isNumberNaN Number that should be checked
     * @return Whether the number is NaN or Not.
     */
    public boolean isNaN(double isNumberNaN) {
        // Is the only "number" that doesn't equal itself, as it's actually not a number
        return !(isNumberNaN == isNumberNaN);
    }

    /**
     * Checks whether the sensor registers a wall (or any other obstacle)
     * @param numberOfWall The distance value of the sensor (in mm! )
     * @return true when wall is registered, false when not
     */
    private boolean isThereAWall(double numberOfWall) {
        //No wall is seen, if NaN is returned or the returned distance is to high
        if (isNaN(numberOfWall) || numberOfWall >= 800) { //400
            return false;
        } else {
            return true;
        }
    }

    /**
     * Follow the wall to the blue line
     */
    public void followWallBlueCrater(float initialOrientation) {

        FarbHelfer farbHelfer = new FarbHelfer();
        motorStuff.turnToDegreeV4((float) (360 - 25)); //todo changed from 22.5

        while(!farbHelfer.isBlue(hwChss.color_back_right) && !opMode.isStopRequested()){
            float difference = motorStuff.getDegree() - initialOrientation;
            if(triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)) < wallDistance){
                motorStuff.setAllMotors(-0.1, -0.15 - newSigLog(difference),-0.1,-0.15 + newSigLog(difference));
            }
            if (triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)) >= wallDistance || isNaN(triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.15,-0.15 - newSigLog(difference),0.15,-0.15 + newSigLog(difference));
            }
        }
    }
    public void followWallRedCrater(float initialOrientation) {

        FarbHelfer farbHelfer = new FarbHelfer();
        motorStuff.turnToDegreeV4((float) (360 - 25)); //todo changed from 22.5

        while(!farbHelfer.isRed(hwChss.color_back_right) && !opMode.isStopRequested()){
            float difference = motorStuff.getDegree() - initialOrientation;
            if(triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)) < wallDistance){
                motorStuff.setAllMotors(-0.1, -0.15 - newSigLog(difference),-0.1,-0.15 + newSigLog(difference));
            }
            if (triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)) >= wallDistance || isNaN(triDist(hwChss.distance_left.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.15,-0.15 - newSigLog(difference),0.15,-0.15 + newSigLog(difference));
            }
        }
    }
    /**
     * Uses trigonometry to get the absolute length from the sensor (angle: 45°) to the wall
     * @param i the measured distance
     * @return the absolute distance
     */
    private  double triDist(double i){
        return Math.cos(Math.toDegrees(45))*i;
    }

    private double newSigLog(float v ) {
        return ((1 / ( 1 + Math.pow(Math.E, -v))) - 0.5) * 0.02;
    }
    private double newSigLogRight(float v, float distance) {
        v = v - distance;
        return ((1 / ( 1 + Math.pow(Math.E, -v))) - 0.5) * 0.05;
    }


    public void followWallBlueWithoutTurnRightSide(float initialOrientation) {

        FarbHelfer farbHelfer = new FarbHelfer();

        while(!farbHelfer.isBlue(hwChss.color_back_right) && !opMode.isStopRequested()){
            float difference = initialOrientation -  motorStuff.getDegree();
            if(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) < 9){
                motorStuff.setAllMotors(-0.15 ,-0.15 + newSigLog(difference),-0.15 , -0.15  - newSigLog(difference));
            }
            if (triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) >= 9 || isNaN(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.15 ,-0.15 + newSigLog(difference),0.15,-0.15 - newSigLog(difference));
            }
            tools.stopForMilliSeconds(10);
        }
    }

    public void followWallRedWithoutTurnRightSide(float initialOrientation) {

        FarbHelfer farbHelfer = new FarbHelfer();

        while(!farbHelfer.isRed(hwChss.color_back_right) && !opMode.isStopRequested()){
            float difference = initialOrientation -  motorStuff.getDegree();
            if(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) < 9){
                motorStuff.setAllMotors(-0.15 ,-0.15 + newSigLog(difference),-0.15 , -0.15  - newSigLog(difference));
            }
            if (triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) >= 9 || isNaN(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.15 ,-0.15 + newSigLog(difference),0.15,-0.15 - newSigLog(difference));
            }
            tools.stopForMilliSeconds(10);
        }
    }

    public void followWallBlueWithoutTurnLeft(float initialOrientation) {

        FarbHelfer farbHelfer = new FarbHelfer();

        while(!farbHelfer.isBlue(hwChss.color_back_right) && !opMode.isStopRequested()){
            float difference = initialOrientation -  motorStuff.getDegree();
            if(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) < 9){
                motorStuff.setAllMotors(-0.15 ,+0.15 + newSigLog(difference),-0.15 , +0.15  - newSigLog(difference));
            }
            if (triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) >= 9 || isNaN(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.15 ,+0.15 + newSigLog(difference),0.15,+0.15 - newSigLog(difference));
            }
            tools.stopForMilliSeconds(10);
        }
    }

    public void followWallRedWithoutTurnLeft(float initialOrientation) {
        FarbHelfer farbHelfer = new FarbHelfer();

        while(!farbHelfer.isRed(hwChss.color_back_right) && !opMode.isStopRequested()){
            float difference = initialOrientation -  motorStuff.getDegree();
            if(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) < 9){
                motorStuff.setAllMotors(-0.15 ,+0.15 + newSigLog(difference),-0.15 , +0.15  - newSigLog(difference));
            }
            if (triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) >= 9 || isNaN(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.15 ,+0.15 + newSigLog(difference),0.15,+0.15 - newSigLog(difference));
            }
            tools.stopForMilliSeconds(10);
        }
    }

}



