package org.firstinspires.ftc.teamcode.subsystems;

import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.LED;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class System {
    public DcMotor carousel;
    public DcMotor leftUp;
    public DcMotor rightUp;
    public CRServo grabber;
//    public Servo spinRight;
//    public CRServo cascadeDown;
    public TouchSensor led;
    public DcMotor out;

    public System(HardwareMap hardwareMap) {
        leftUp = hardwareMap.get(DcMotor.class, "leftUp"); // Port 0 EXP
        rightUp = hardwareMap.get(DcMotor.class, "rightUp"); // Port 1 EXP
        carousel = hardwareMap.get(DcMotor.class, "carousel"); // Port 2 EXP
        out = hardwareMap.get(DcMotor.class, "out"); // Port 3 EXP
        grabber = hardwareMap.get(CRServo.class, "spinLeft"); // Servo Port 0 EXP
        led = hardwareMap.get(TouchSensor.class, "led"); // 0:1 Analog CH

        out.setDirection(DcMotorSimple.Direction.REVERSE);
        leftUp.setDirection(DcMotorSimple.Direction.REVERSE);
        rightUp.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public void setCarousel(int pos, Telemetry telemetry) {
        carousel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        carousel.setTargetPosition(pos);
        carousel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        carousel.setPower(0.8);
        while (carousel.isBusy()) {
            telemetry.addData("Status", "waiting for finish");
            telemetry.update();
        }
        carousel.setPower(0);
        telemetry.update();
    }

//    public void led() {
//        if (led.isLightOn()) {}
//        else {
//            led.enable(true);
//            if (led.isLightOn()) {}
//            else {
//                led.enableLight(true);
//            }
//        }
//    }
}