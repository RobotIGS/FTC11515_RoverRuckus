package org.firstinspires.ftc.teamcode.Tools;

public class TurnStuffCalibration {
    private MotorStuff motstff;

    public TurnStuffCalibration(MotorStuff motstff){
        this.motstff = motstff;
    }
    /* got small problems
    public double[] calibration(){
        double[] values = new double[2];
        values[0] = getminimumapeed();



        motstff.MINSPEED = values[0];
        double smoothness = 360;

        motstff.turnToDegreeV4(20);
        gowaitinkitchen(1);
        calculateAverage(100);

        gowaitinkitchen(1);
        for(double i = 50;i<=250;i+=5){
            double currentOffset = calculateAverage(i);
            if(smoothness>currentOffset){smoothness=currentOffset;}
        }
        values[1] = smoothness;
        return values;
    }
    */


    /**
     * This Method calculates the Minimum Speed / Power the motors need to be set to in order to move the robot
     * This is needed because the chassis will have different amounts of weigh and resistance trough its development
     * The waiting call needs uptaded to bbe opmode sleeping
     * @return amount of power needed to move the robot
     */
    public double getMinimumSpeed(){
        boolean stop = false;
        double percent = 0;

        double prevdegrees;
        for(double i = 0; !stop;i+=0.01){
            prevdegrees = motstff.getDegree();
            motstff.turn(i,Direction_Enum.Right);
            gowaitinkitchen(2);
            if(Math.abs(prevdegrees - motstff.getDegree())>1){
                percent = i;
                stop = true;
            }
            motstff.setAllMotors(0,0,0,0);
            gowaitinkitchen(0.5);
        }
        return percent;
    }

    /*
    * became obsolete due to getminimumspeed
    public double calculateAverage(double smoothness){
        motstff.SMOOTHNESS = smoothness;
        double average = 0;
        double overshoot;
        double[] overshootArray = new double[37];
        double goal;
        for(double i = 10; i!= 360;i+=10){
            goal = (motstff.getDegree() + i)%360;
            motstff.turnToDegreeV4((float)(i));
            this.gowaitinkitchen(1);
            overshoot = Math.abs(goal- motstff.getDegree());
            overshootArray[((int)(i))/10] = overshoot;
        }
        overshoot = 0;
        for(int i = 0; i< overshootArray.length;i++){
            overshoot += overshootArray[i];
        }
        average = overshoot/overshootArray.length;
        return average;
    }
*/
    /**
     * This Method is used to immitate the LinearOpMode exclusive sleep() method
     * This is archived with a timmed while method
     * @param seconds amount of time to wait in seconds
     */
    public void gowaitinkitchen(double seconds){
        double prevtime = System.currentTimeMillis();
        while(prevtime+ seconds*1000 > System.currentTimeMillis()){}
    }


}
