package Neuronal;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.test.suitebuilder.annotation.SmallTest;

import for_camera_opmodes.OpModeCamera;
/*
This class receives an Image and converts it to an HSV[][]
Also able to convert HSV[][] to bitmap

 */

public class CameraHelper extends OpModeCamera {
     Bitmap picture;
    private int width; // initializing  length
    private int height; // initializing  height
    private HSV[][] hsv_pic; // initializing  the foundation of the HSV matrix

    /**
     *Constructor. Sets the attributes according to the bitmap
     *
     * @param picture The bitmap that the class will use (the picture to be analyzed)
     */
    public CameraHelper(Bitmap picture) {
        this.picture = picture;
        this.hsv_pic = bitmapToHsv(picture);
        this.width = picture.getWidth();
        this.height = picture.getHeight();
    }

    /**
     * Standard empty constructor
     */
    public CameraHelper() { }

    /**
     *Receive bitmap
     * @return Took image of inherited camera class
     */
    //todo untested
    public Bitmap getBitmap() {
        //super.init();
        Bitmap platz =  convertYuvImageToRgb(super.yuvImage, super.width, super.height, super.ds); //todo
        //super.stopCamera();
        return  platz;
    }

    /**
     * Simplifies image to an hsv table (double array)
     * @param bit The bitmap that should be converted
     * @return
     */
    public HSV[][] bitmapToHsv(Bitmap bit){
        HSV[][] hsv = new HSV[this.height][this.width];

        for (int i = 0; i <= this.height + 1; i++) {
            for (int j = 0; j <= this.width + 1; i++) {
                int pixel = bit.getPixel(i, j);
                int red = (pixel >> 16) & 0xff; //<--\
                int blue = (pixel >> 8) & 0xff; // converting the single int into the 3 different HSV values
                int green = (pixel >> 0) & 0xff;// <--/
                hsv[i][j] = new HSV(this.convert_RGB_To_HSV(red, green, blue));
            }
        }

            return hsv;
    }

    /**
     * Converts a rgb to hsv value
     * @param r red value
     * @param g green value
     * @param b blue value
     * @return hsv value, as float
     */
    private float[] convert_RGB_To_HSV(int r, int g, int b){
        float[] hsv = new float[3];
        double test;
        Color.RGBToHSV(r,g,b,hsv);
        return hsv;
    }

    /**
     * Converts hsv images to a bitmaps
     * @param hsv table (double array) of hsv objects
     * @return desired bitmap
     */
    public Bitmap HSVtoBitmap(HSV[][] hsv){
        int color;
        Bitmap bit = this.picture;
        for (int i = 0; i < hsv.length; i++ ){ //For width
            for (int j = 0; j < hsv[i].length; j++) { // For length
                float[] pixelHSV = new float[3];
                pixelHSV[0] =  hsv[i][j].h;
                pixelHSV[1] =  hsv[i][j].s;
                pixelHSV[2] =  hsv[i][j].v;

                color = Color.HSVToColor(pixelHSV);
                bit.setPixel(i,j,color);
            }
        }

        return bit;
    }


    public void visualize(){ }

}

/**
 * Helper class, contains three floats and thus a hsv value.
 */
class HSV{
    float v;
    float s;
    float h;
    public HSV(float[] arr){
        this.h = arr[0];
        this.s = arr[1];
        this.v = arr[2];

    }
}