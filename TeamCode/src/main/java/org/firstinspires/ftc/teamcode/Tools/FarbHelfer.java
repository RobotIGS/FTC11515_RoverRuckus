package org.firstinspires.ftc.teamcode.Tools;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.ColorSensor;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;

/* Lena */

public class FarbHelfer {
    int colorHSVnow;
    int listSize;
    int averageLastHue;
    int total;
    float[] hsvNow;
    Queue<Integer> colorList;
    Queue<Integer> averageList;
    final double SCALE_FACTOR = 255; //Umrechnungsfaktor



    int wertvorxsekunden;
    int x = 2;

    boolean isColorChangend;

    /**
     * it returns true if the color is red
     * red is between 0-60° or 330-360° (hue) and with saturation over 0.3
     * @param colorSenseRed is the color sensor we get our values from
     * @return it true or false
     */
    public boolean isRed(ColorSensor colorSenseRed){
        float[] hsvIsRed = showHSV(colorSenseRed);

        if (hsvIsRed[0] >= 0 && hsvIsRed[0] <= 60 && hsvIsRed[1] >= 0.27) {
            return true;
        }

        if (hsvIsRed[0] >= 330 && hsvIsRed[0] <= 360){
            return true;
        }

        return false;

    }

    /**
     * it returns true if the color is blue
     * blue is between 120-290° (hue) and with saturation over 0.3
     * @param colorSenseBlue is the color sensor we get our values from
     * @return true or false
     */
    public boolean isBlue(ColorSensor colorSenseBlue) {
        float[] hsvIsBlue = showHSV(colorSenseBlue);

        if (hsvIsBlue[0] >= 120 && hsvIsBlue[0] <= 290 && hsvIsBlue[1] >= 0.27){
            return true;
        }

        return false;
    }


    /**
     * the boolean gives a true back if the color has changed
     * it checks if the queue is larger than 100 and adds values while it isn't
     * if the list is as long as 100 it deletes a value and adds a new one
     * it calculates the average of the queue and compares it to the average a second ago
     * @param colorSenseChange is the color sensor we get our values from
     * @return true or false
     */
    public boolean colorChange(ColorSensor colorSenseChange) {
        colorList = new LinkedList<>();
        averageList = new LinkedList<>();
        hsvNow = showHSV(colorSenseChange);
        colorHSVnow = (int) hsvNow[0];
        listSize = colorList.size();
        averageLastHue = 0;
        total = 0;
        isColorChangend = true;


                while (listSize <= 100) {
                    colorList.add(colorHSVnow);

                }

                if (listSize == 100) {
                    colorList.remove(0);
                    colorList.add(colorHSVnow);
                }




                for (int hue: colorList){
                    total = total + hue;
                }

                averageLastHue = total / 100;

                if((System.currentTimeMillis()*1000)%x == 0) {
                    wertvorxsekunden = averageLastHue;
                }

                if((averageLastHue < wertvorxsekunden-3 && averageLastHue > wertvorxsekunden+3)){
                    isColorChangend = true;
                }


        return isColorChangend;

    }

    /**
     * it converts rgb to hsv-values
     * @param HSVvalues is the color sensor we get the rgb-values from
     * @return it returns hsv-values
     */
    private float[] showHSV (ColorSensor HSVvalues) {
        float[] hsv = new float[3];

        Color.RGBToHSV((int) (HSVvalues.red() * SCALE_FACTOR),
                (int) (HSVvalues.green() * SCALE_FACTOR),
                (int) (HSVvalues.blue() * SCALE_FACTOR),
                hsv);

        return hsv;

    }

}
