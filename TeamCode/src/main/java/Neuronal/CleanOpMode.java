package Neuronal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;

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
        startCamera();
        camera.startPreview();
        Camera.PictureCallback jpeg = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                telemetry.addData("Byte length, ", data.length);
                telemetry.update();
            }
        };
        Camera.ShutterCallback shutterCallback = new Camera.ShutterCallback() {
            @Override
            public void onShutter() {

            }
        };
        try {
            camera.takePicture(shutterCallback, null, jpeg);
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*Bitmap malte = convertYuvImageToRgb(super.yuvImage, super.width, super.height, super.ds);
        helper = new CameraHelper(malte);
        helper = new CameraHelper(helper.getBitmap());
        telemetry.addData("test", helper.picture.getPixel(1, 1));
        HSV[][] transformiert = helper.bitmapToHsv(helper.getBitmap());
        telemetry.update();*/
    }

}
