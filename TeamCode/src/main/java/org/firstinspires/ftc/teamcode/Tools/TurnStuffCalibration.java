package org.firstinspires.ftc.teamcode.Tools;

public class TurnStuffCalibration {
    private MotorStuff mtstuff;

    public TurnStuffCalibration(MotorStuff mtstuff){
        this.mtstuff = mtstuff;
    }

    public double[] Calibration(){
        double[] values = new double[2];
        values[0] = this.getminimumapeed();

        double smoothness = 360;
        for(double i = 50;i<=250;i+=5){
            double currentOffset = this.calculateAverage(i);
            if(smoothness>currentOffset){smoothness=currentOffset;}
        }
        values[1] = smoothness;
        return values;
    }




    public double getminimumapeed(){
        boolean stop = false;
        double percent = 0;

        double prevdegrees;
        for(double i = 0; !stop;i+=0.01){
            prevdegrees =mtstuff.getDegree();
            mtstuff.turn(i,Direction_Enum.Right);
            gowaitinkitchen(1);
            if(Math.abs(prevdegrees-mtstuff.getDegree())>1){
                percent = i;
                stop = true;
            }
            gowaitinkitchen(1);
        }

        return percent;
    }

    public double calculateAverage(double smoothnes){
        double average = 0;
        double overshoot;
        double[] overshootArray = new double[37];
        double goal;
        for(double i = 0; i!= 360;i+=10){
            goal = (mtstuff.getDegree() + i)%360;
            mtstuff.turnToDegreeV4((float)(i));
            this.gowaitinkitchen(1);
            overshoot = Math.abs(goal-mtstuff.getDegree());




            overshootArray[((int)(i))/10] = overshoot;
        }
        overshoot = 0;
        for(int i = 0; i< overshootArray.length;i++){
            overshoot += overshootArray[i];
        }
        average = overshoot/overshootArray.length;


        return average;
    }

    public int calibrate(int initialSmoothnes){
        int smoothnes = initialSmoothnes;

        return smoothnes;
    }
    private void gowaitinkitchen(double sekunden){
        double prevtime = System.currentTimeMillis();
        while(prevtime+ sekunden*1000 > System.currentTimeMillis()){}
    }


}
