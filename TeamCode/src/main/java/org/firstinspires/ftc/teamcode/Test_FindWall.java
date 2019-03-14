package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.DistanceTools;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;

/**
 * In this class, we created methods, so the robot will, when at the wall, follow it, without
 * kicking away another mineral.
 */
@TeleOp (name = "Test Find Wall")
public class Test_FindWall extends LinearOpMode {
    private HardwareChassisSun hwChss;
    private MotorStuff motorStuff;
    private DistanceTools distanceTools;
    private Tools tools;
    //Constant, that describes how close the robot should be to the wall
    private final double WALL_DISTANCE = 6.5;


    @Override
    public void runOpMode() {

        tools = new Tools(this);
        hwChss = new HardwareChassisSun(hardwareMap);
        motorStuff = new MotorStuff(hwChss, hardwareMap, this);
        distanceTools = new DistanceTools(motorStuff, hwChss, tools, this);


        waitForStart();
        orientateToSensorRight(hwChss.distance_right, hwChss.distance_left);
    }

    /**
     * Uses trigonometry to get the absolute length from the sensor (angle: 45°) to the wall
     * @param i the measured distance
     * @return the absolute distance
     */
    private double triDist(double i){
        return Math.cos(Math.toDegrees(45))*i;
    }

    /**
     * The robot drives and keeps a certain distance from the wall.
     * It will drive left or right to keep the distance.
     * The direction the robot drives to has to be in the direction of the wall
     */
    private void keepDistanceFromWall(){
        while(opModeIsActive()){
            telemetry.addData("Distance Right", hwChss.distance_right.getDistance(DistanceUnit.CM));
            telemetry.addData("Calculated Distance", triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)));
            telemetry.update();
            if(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) < WALL_DISTANCE){
                motorStuff.setAllMotors(0.2, -0.2,0.2,-0.2);
            }
            if (triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) >= WALL_DISTANCE || distanceTools.isNaN(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.2,0.2,0.2,0.2);
            } else {
                    motorStuff.setAllMotors(0.2, 0,0.2,0);
            }
        }
    }
    public void orientateToSensorRight(DistanceSensor right, DistanceSensor left) {
        double distanceRight = right.getDistance(DistanceUnit.MM);
        while (((left.getDistance(DistanceUnit.MM) > distanceRight) || isNaN(left.getDistance(DistanceUnit.MM)) )&& !isStopRequested() ) {
            hwChss.motor_back_left.setPower(0.2);
        }
        hwChss.motor_back_left.setPower(0);
    }

    public boolean isNaN(double isNumberNaN) {
        // Is the only "number" that doesn't equal itself, as it's actually not a number
        return !(isNumberNaN == isNumberNaN);
    }
    /**
     *Plan was to let the robot drive in a zig zag pattern, was this isn't possible,
     * because the robot is too big.
     */
    @Deprecated
    public void driveHarryPotter() {
        while (opModeIsActive()) {
            telemetry.addData("Distance Right", hwChss.distance_right.getDistance(DistanceUnit.CM));
            telemetry.update();
            if (hwChss.distance_right.getDistance(DistanceUnit.CM) <= 5){
                telemetry.addData("Distance Right", hwChss.distance_right.getDistance(DistanceUnit.CM));
                telemetry.update();
                motorStuff.setAllMotors(0.2,-0.2,0.2,-0.2);
            } else {
                telemetry.addData("Distance Right", hwChss.distance_right.getDistance(DistanceUnit.CM));
                telemetry.update();
                motorStuff.setAllMotors(0.2, 0,0.2,0);
            }
        }
    }
}
