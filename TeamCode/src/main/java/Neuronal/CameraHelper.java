package Neuronal;

import android.graphics.Bitmap;
import android.graphics.Color;

import for_camera_opmodes.OpModeCamera;
/*
This class recieves an Image and converts it to an HSV[][]
Also able to convert HSV[][] to bitmap

 */

public class CameraHelper extends OpModeCamera {
     Bitmap bild;
    int width; // initializing  lenght
    int height; // initializing  height
    HSV[][] hsv_pic; // initializing  the foundation of the HSV matrix

    // @ bild
    // is the bitmap containing the RGB information of the picture
    public CameraHelper(Bitmap bild) {
        this.bild = bild;
        this.hsv_pic = bitmapToHsv(bild);
        this.width = bild.getWidth();
        this.height = bild.getHeight();
    }
    public CameraHelper() { }

    public Bitmap getBitmap() {
        //super.init();
        Bitmap platz =  convertYuvImageToRgb(super.yuvImage, super.width, super.height, super.ds); //todo
        //super.stopCamera();
        return  platz;
    }


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
    // @ r,g,b
    // the r,g,b values
    //returns the hsv values of the RGB values
    private float[] convert_RGB_To_HSV(int r, int g, int b){
        float[] hsv = new float[3];
        double test;
        Color.RGBToHSV(r,g,b,hsv);
        return hsv;
    }

    public Bitmap HSVtoBitmap(HSV[][] hsv){
        int color;
        Bitmap bit = this.bild;
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

    public void visualize(){




    }



    public Bitmap getBild() {
        return bild;
    }

    public void setBild(Bitmap bild) {
        this.bild = bild;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}


// helper class for HSV
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