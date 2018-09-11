package org.firstinspires.ftc.teamcode.Tools;


/*
    Made by @Steffen and Frerik and Tobias

 */

import com.qualcomm.robotcore.hardware.ColorSensor;

public class FarbsensorTest {
    private ColorSensor colorSensor;

    public FarbsensorTest(ColorSensor colorSensor) {
        this.colorSensor = colorSensor;
    }

    public void driveUntilOtherColor() {
        colorSensor.alpha();
        int lichtAlt = 0;


        while(true)
        {
            int lichtNeu = colorSensor.alpha();
            if (lichtAlt <= lichtNeu-10 || lichtAlt >= lichtNeu+10)
            {
                return;
            }

             lichtAlt = lichtNeu;
        }

    }


}