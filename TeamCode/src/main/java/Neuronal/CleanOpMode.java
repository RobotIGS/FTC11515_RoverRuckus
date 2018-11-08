package Neuronal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.SurfaceHolder;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import for_camera_opmodes.LinearOpModeCamera;

/*
This Class inherits from the LinerOpMode class, and we hope that therefore we can receive the image
 */

@TeleOp(name = "Malte")
public class CleanOpMode extends LinearOpModeCamera {
    @Override
    public void runOpMode() {
        //Bitmap malte = convertYuvImageToRgb(super.yuvImage, super.width, super.height, super.ds);
        //helper = new CameraHelper(malte);
        waitForStart();

        startCamera();
        System.out.println("TEST");
        telemetry.addData("Test", true);
        telemetry.update();
        Camera.PreviewCallback callback = new Camera.PreviewCallback() {
            @Override
            public void onPreviewFrame(byte[] data, Camera camera) {
                Camera.Parameters paramters = camera.getParameters();
                width = paramters.getPreviewSize().width;
                height = paramters.getPictureSize().height;
                YuvImage yuv = new YuvImage(data, ImageFormat.NV21, width, height, null);
                for (int r = 0; r < 100; r++) {
                    System.out.println("Malte");
                }
                telemetry.addData("Test", false);
                telemetry.update();
            }
        };

        camera.setPreviewCallback(callback);
        camera.startPreview();
      




        /*Bitmap malte = convertYuvImageToRgb(super.yuvImage, super.width, super.height, super.ds);
        helper = new CameraHelper(malte);
        helper = new CameraHelper(helper.getBitmap());
        telemetry.addData("test", helper.picture.getPixel(1, 1));
        HSV[][] transformiert = helper.bitmapToHsv(helper.getBitmap());
        telemetry.update();*/
    }

}
