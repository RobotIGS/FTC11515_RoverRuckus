package org.firstinspires.ftc.teamcode.Deprecated.java.Depracated;

import org.firstinspires.ftc.teamcode.Tools.Direction_Enum;
/**All these methods have been tested and did either not funktion or where inoptimal
 *  They where intended to execute the same physikcal funktions as the turn to degree method we are using currently
 **/
@Deprecated
public class DeprecatedTurnToDegree {
/*
    public void turnToDegreeV3(float degreeToturn){

        final float OFFSET = motstff.getDegree();
        final float DESTINATION = (degreeToturn + 360)%360;
        float left = degreeToturn;
        float previousDegrees = 0;
        telemetry.addLine("2");
        telemetry.update();
        double turnSpeed = 0;
        while(left>0/(left < 0.5 && left > -0.5)){
            telemetry.addData("left",left);
            telemetry.addData("Offset",OFFSET);
            telemetry.addData("Destination",DESTINATION);
            telemetry.addData("previousDegrees",previousDegrees);
            telemetry.addData("currentDegrees",motstff.getDegree());
            telemetry.addData("degreetotTurn",degreeToturn);
            telemetry.addData("urnspeed",turnSpeed);
            telemetry.update();
            previousDegrees = motstff.getDegree() - OFFSET;
            turnSpeed = Math.tanh(left/100);
            motstff.turn(turnSpeed, Direction_Enum.Right);
            left += previousDegrees - (motstff.getDegree()-OFFSET);
        }
    }
*/
/*
public void turnToDegreeV2(float degreeToturn){
        final float OFFSET = this.getDegree();
        final float DESTINATION = (degreeToturn + 360)%360;
        float left = degreeToturn;
        float previousDegrees;
        double turnSpeed;
        while(left < 0.5 && left > -0.5){
            previousDegrees = this.getDegree() - OFFSET;
            turnSpeed = Math.tanh(left/SMOOTHNESS);
            this.turn(turnSpeed, Direction_Enum.Right);
            left += previousDegrees - this.getDegree()-OFFSET;
        }
    }
 */
/*
public void turnToDegree(double degrees){
        while (degrees > 1) {
            prevDegrees = this.getDegree();
            turnSpeed = Math.tanh(degrees / SMOOTHNESS);
            turn(turnSpeed, Direction_Enum.Left);

            degrees = degrees - (prevDegrees - this.getDegree());
        }
        setAllMotors(0,0,0,0);
    }
 */
}
