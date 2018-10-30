package Neuronal;

import android.graphics.Bitmap;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import for_camera_opmodes.LinearOpModeCamera;

/*
This Class inherits from the LinerOpMode class, and we hope that therefore we can receive the image
 */

@TeleOp(name = "Malte")
public class CleanOpMode extends LinearOpModeCamera {
    CameraHelper helper;
    @Override
    public void runOpMode() {
        //Bitmap malte = convertYuvImageToRgb(super.yuvImage, super.width, super.height, super.ds);
        //helper = new CameraHelper(malte);
        waitForStart();
        //helper = new CameraHelper(helper.getBitmap());
        //telemetry.addData("test", helper.bild.getPixel(1, 1));
        //HSV[][] transformiert = helper.bitmapToHsv(helper.getBitmap());
        //telemetry.update();
    }

}
