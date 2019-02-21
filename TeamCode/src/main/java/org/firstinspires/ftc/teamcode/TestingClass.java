package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.HardwareMaps.HardwareChassisSun;
import org.firstinspires.ftc.teamcode.Tools.DistanceTools;
import org.firstinspires.ftc.teamcode.Tools.MotorStuff;
import org.firstinspires.ftc.teamcode.Tools.Tools;


@TeleOp (name = "Test Harry Potter")
public class TestingClass extends LinearOpMode {
    HardwareChassisSun hwChss;
    MotorStuff motorStuff;
    DistanceTools distanceTools;
    Tools tools;
    double wallDistanceHut = 6.5;


    @Override
    public void runOpMode() {

        hwChss = new HardwareChassisSun(hardwareMap);
        motorStuff = new MotorStuff(hwChss, hardwareMap);
        distanceTools = new DistanceTools(motorStuff, hwChss);
        tools = new Tools();

        waitForStart();

        motorStuff.turnToDegreeV4((float)337.5);
        meinHutDerHatDreiEckenDrive();
    }

    public double triDist(double i){
        return Math.cos(Math.toDegrees(45))*i;
    }

    public void meinHutDerHatDreiEckenDrive(){
        while(opModeIsActive()){
            telemetry.addData("Distance Right", hwChss.distance_right.getDistance(DistanceUnit.CM));
            telemetry.addData("Calculated Distance", triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)));
            telemetry.update();
            if(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) < wallDistanceHut ){
                motorStuff.setAllMotors(0.2, -0.2,0.2,-0.2);
            }
            if (triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)) >= wallDistanceHut || distanceTools.isNaN(triDist(hwChss.distance_right.getDistance(DistanceUnit.CM)))) {
                motorStuff.setAllMotors(0.2,0.2,0.2,0.2);
            } else {
                    motorStuff.setAllMotors(0.2, 0,0.2,0);
            }
        }
    }


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
