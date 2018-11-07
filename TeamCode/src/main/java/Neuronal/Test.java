package Neuronal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/*
Tests the camera helper class, but we don't receive the image
 */
@TeleOp(name = "Image Recognition Test")
public class Test extends LinearOpMode {
    private CameraHelper helper;

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        helper = new CameraHelper(helper.getBitmap());
        telemetry.addData("test", helper.picture.getPixel(1, 1));
        HSV[][] transformiert = helper.bitmapToHsv(helper.getBitmap());
        telemetry.update();
    }
}