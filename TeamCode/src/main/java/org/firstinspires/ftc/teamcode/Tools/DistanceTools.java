package org.firstinspires.ftc.teamcode.Tools;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;


/*
    This class includes tools to drive using the distance sensors.
    Therefore a chassis that includes distance sensors is required.

    author: @lena @paul
 */

public class DistanceTools {
    private MotorStuff motorStuff;
    private HardwareChassisSun hwChss;

    Tools tools = new Tools();


    /**
     * Standard constructor
      * @param motorStuff Object is needed, so the method can drive in one direction
     * @param hwChss This is needed, so the method can access the motors and sensors
     */
    public DistanceTools(MotorStuff motorStuff, HardwareChassisSun hwChss) {
        this.motorStuff = motorStuff;
        this.hwChss = hwChss;
    }

    /**
     * When the robot removed the golden mineral, this method will let it drive until it registers a wall
     * @param direction Whether the robot will hit the wall with it's left or it's right side
     */
    public void driveToWall(Direction_Enum direction) {
        //if statement to differ between left and right
        if (direction == Direction_Enum.Right) {
            //Drives until right sensor registers a wall.
            while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM))) {
                motorStuff.driveInOneDirection(0.2, 0.2); //drive forward
                tools.stopForSeconds(1000);
            }
            motorStuff.setAllMotors(0, 0, 0, 0);

            //Turns until other (left)  sensor also registers a wall, so the robot is parallel to the wall
            while (hwChss.distance_left.getDistance(DistanceUnit.MM) != hwChss.distance_right.getDistance(DistanceUnit.MM)/*!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM)))*/) {
                hwChss.motor_front_left.setPower(0.2);
                hwChss.motor_back_left.setPower(-0.2);
            }
            motorStuff.setAllMotors(0, 0, 0, 0);






            //Reversed to the code above
        } else if (direction == Direction_Enum.Left) {
            //Drives until left sensor registers a wall.
            while (!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM))) {
                motorStuff.driveInOneDirection(0.2, 0.2);
            }

            motorStuff.setAllMotors(0, 0, 0, 0);
            //Turns until other (right)  sensor also registers a wall, so the robot is parallel to the wall
            while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM))) {
                hwChss.motor_front_right.setPower(-0.2);
                hwChss.motor_back_right.setPower(0.2);
            }
        } else  if (direction == Direction_Enum.BlueCrater) {
            //set all motors 0
            motorStuff.setAllMotors(0,0,0,0);

            //Drives until left sensor registers a wall.
            while (!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM))) {
                motorStuff.driveLeft(0.2, 0.2);

            }
            motorStuff.setAllMotors(0, 0, 0, 0);
            /*
             motorStuff.turn(0.2, Direction_Enum.Right );
            tools.stopForSeconds(2000);
            //Turns until other (right)  sensor also registers a wall, so the robot is parallel to the wall
            while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM))) {
                motorStuff.setAllMotors(0.2, -0.2, -0.2, 0.2);
            }

            //wait additional seconds
            double time = System.currentTimeMillis();
            tools.stopForSeconds(1000);
            while (hwChss.distance_left.getDistance(DistanceUnit.MM) > hwChss.distance_right.getDistance(DistanceUnit.MM/*hwChss.distance_left.getDistance(DistanceUnit.MM) <= 300 && hwChss.distance_right.getDistance(DistanceUnit.MM) <= 300)){
                motorStuff.driveBack(0.2,0.2);
            }
            */
        }

        motorStuff.setAllMotors(0, 0, 0, 0);

    }

/*
    public void dtriveToWall_Left (Direction_Enum direction) {
        if (direction == Direction_Enum.BlueCrater) {
            //Drives until left sensor registers a wall.
            while (!isThereAWall(hwChss.distance_left.getDistance(DistanceUnit.MM))) {
                motorStuff.driveLeft(0.2, 0.2);
            }
            motorStuff.setAllMotors(0, 0, 0, 0);

            //Turns until other (right)  sensor also registers a wall, so the robot is parallel to the wall
            while (!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM))) {
                hwChss.motor_front_right.setPower(0.2);
                hwChss.motor_back_right.setPower(0.2);
            }
            motorStuff.setAllMotors(0, 0, 0, 0);


        }
    } */



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
     * @return If a wall is registered
     */
    public boolean isThereAWall(double numberOfWall) {
        //No wall is seen, if NaN is returned or the returned distance is to high
        if (isNaN(numberOfWall) || numberOfWall >= 800) { //400
            return false;
        } else {
            return true;
        }
    }



    public void driveToWallWithCompass(double initial_oriantation){
        while(!isThereAWall(hwChss.distance_right.getDistance(DistanceUnit.MM))){
            motorStuff.driveInOneDirection(0.2, 0.2);
        }
        motorStuff.setAllMotors(0,0,0,0);
        motorStuff.turnToDegreeV4(   (float)(       45 +     initial_oriantation - motorStuff.getDegree()   +    360)    );
    }

}



