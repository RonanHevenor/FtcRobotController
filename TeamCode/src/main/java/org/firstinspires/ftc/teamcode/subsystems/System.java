package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class System {
    public DcMotor carousel;
    public DcMotor cascade;
    public Servo spinLeft;
    public Servo spinRight;
//    public CRServo cascadeDown;
    public TouchSensor touch;
    public LED led;

    public System(HardwareMap hardwareMap) {
        carousel = hardwareMap.get(DcMotor.class, "carousel"); // Port 0 EXP
        cascade = hardwareMap.get(DcMotor.class, "cascade"); // Port 2 EXP
        spinLeft = hardwareMap.get(Servo.class, "spinLeft"); // Servo Port 0 EXP
        spinRight = hardwareMap.get(Servo.class, "spinRight"); // Servo Port 5 CH
//        cascadeDown = hardwareMap.get(CRServo.class, "cascadeDown"); // Servo Port 1 EXP
        touch = hardwareMap.get(TouchSensor.class, "touch"); // Digital Port 3 EXP
        led = hardwareMap.get(LED.class, "led");
    }

    public void Elevate(Integer level) {
        if (level == 0) {
            if (touch.isPressed()) {
                cascade.setPower(0);
            }
            else {
                cascade.setPower(0.3);
//                cascadeDown.setPower(1);
            }
        } else {
            cascade.setPower(-1);
//            cascadeDown.setPower(-1);
        }
    }

    public void Drop() {
        spinLeft.setPosition(1);
        spinRight.setPosition(-1);
    }

    public void Intake() {
        spinLeft.setPosition(-1);
        spinRight.setPosition(1);
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