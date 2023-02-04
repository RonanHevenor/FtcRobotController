package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class System {
    public DcMotor carousel;
    public DcMotor leftUp;
    public DcMotor rightUp;
    public CRServo grabber;
//    public Servo spinRight;
//    public CRServo cascadeDown;
    public LED led;
    public DcMotor out;

    public System(HardwareMap hardwareMap) {
        leftUp = hardwareMap.get(DcMotor.class, "leftUp"); // Port 0 EXP
        rightUp = hardwareMap.get(DcMotor.class, "rightUp"); // Port 1 EXP
        carousel = hardwareMap.get(DcMotor.class, "carousel"); // Port 2 EXP
        out = hardwareMap.get(DcMotor.class, "out"); // Port 3 EXP
        grabber = hardwareMap.get(CRServo.class, "spinLeft"); // Servo Port 0 EXP
        led = hardwareMap.get(LED.class, "led");


        leftUp.setDirection(DcMotorSimple.Direction.REVERSE);
        rightUp.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void led() {
        if (led.isLightOn()) {}
        else {
            led.enable(true);
            if (led.isLightOn()) {}
            else {
                led.enableLight(true);
            }
        }
    }
}