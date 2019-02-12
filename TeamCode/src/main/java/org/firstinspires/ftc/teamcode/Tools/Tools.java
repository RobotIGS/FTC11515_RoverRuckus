package org.firstinspires.ftc.teamcode.Tools;

public class Tools {

    /**
     * pauses the program for additional seconds
     * @param timeStop double, in Milliseconds
     */
    public void wait (double timeStop) {
        double time = System.currentTimeMillis();

        while (System.currentTimeMillis() < time + timeStop) {        }
    }
}

