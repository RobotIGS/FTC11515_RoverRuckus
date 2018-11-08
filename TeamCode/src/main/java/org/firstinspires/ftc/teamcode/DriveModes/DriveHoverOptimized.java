package org.firstinspires.ftc.teamcode.DriveModes;

public class DriveHoverOptimized {

   public double gameX;
   public double gameY;

   public double driveSpeedX;
   public double driveSpeedY;

  /*  public DriveHoverOptimized(double X, double Y){
        this.gl1X = X;
        this.gl1Y = Y;
    }*/

    //gl1X = gamepad1.left_stick_x;
    //gl1Y = -gamepad1.left_stick_y;
    public void drive(double gl1X, double gl1Y, double trigger) {
        if (gl1X > 0 || gl1Y > 0) {
            if (Math.abs(gl1X) == Math.abs(gl1Y)) {
                gameX = (gl1X != 0) ? (gl1X < 0) ? -1 : 1 : 0;
                gameY = (gl1Y != 0) ? (gl1Y < 0) ? -1 : 1 : 0;
            } else if (gl1Y < 0 || gl1X < 0) {
                if (gl1Y < 0 && gl1X >= 0 || gl1X < 0 && gl1Y >= 0) {
                    gameX = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1X < gl1Y ? -1 : 1 : Math.abs(gl1X) / gl1Y * -1;
                    gameY = (Math.abs(gl1Y) > Math.abs(gl1X)) ? gl1Y < gl1X ? -1 : 1 : Math.abs(gl1Y) / gl1X * -1;
                } else {
                    gameX = (Math.abs(gl1X) < Math.abs(gl1Y)) ? gl1X / gl1Y * -1 : -1;
                    gameY = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1Y / gl1X * -1 : -1;
                }
            } else {
                gameX = (Math.abs(gl1X) < Math.abs(gl1Y)) ? gl1X / gl1Y : 1;
                gameY = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1Y / gl1X : 1;
            }
        } else if (gl1X < 0 || gl1Y < 0) {
            gameX = (Math.abs(gl1X) < Math.abs(gl1Y)) ? gl1X / gl1Y * -1 : -1;
            gameY = (Math.abs(gl1X) > Math.abs(gl1Y)) ? gl1Y / gl1X * -1 : -1;
        } else {
            gameX = 0;
            gameY = 0;
        }
        driveSpeedX = trigger * gameX;
        driveSpeedY = trigger * gameY;
    }
}
