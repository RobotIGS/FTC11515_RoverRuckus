package org.firstinspires.ftc.teamcode.HardwareMaps;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareChassisKarl {
    public Servo servo = null;

    private HardwareMap hwmap = null;

    //CONSTRUKTOR GETS HARDWAREMAP OF RIGHT LAYOUT
    public HardwareChassisKarl(HardwareMap ahwMap) {
        //run init hands over hardwaremap of right layout
        init(ahwMap);
    }

    //INIT SHOULD RUN WHEN CONSTRUKTED GETS HARDWAREMAP OF RIGHT LAYOUT
    public void init(HardwareMap hwMap) {
        this.servo = hwMap.get(Servo.class, "karl_servo_1");
    }
}
