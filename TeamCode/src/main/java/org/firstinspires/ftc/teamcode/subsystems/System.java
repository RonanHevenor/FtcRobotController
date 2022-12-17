package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class System {
    public DcMotor carousel;
    public DcMotor cascade;
    public Servo spinLeft;
    public Servo spinRight;
    public CRServo cascadeDown;

    public System(HardwareMap hardwareMap) {
        carousel = hardwareMap.get(DcMotor.class, "carousel"); // Port 0 EXP
        cascade = hardwareMap.get(DcMotor.class, "cascade"); // Port 2 EXP
        spinLeft = hardwareMap.get(Servo.class, "spinLeft"); // Servo Port 0 EXP
        spinRight = hardwareMap.get(Servo.class, "spinRight"); // Servo Port 5 CH
        cascadeDown = hardwareMap.get(CRServo.class, "cascadeDown"); // Servo Port 1 EXP
    }

    public void Elevate(Integer level) {
        if (level == 0) {
            cascade.setPower(-0.2);
            cascadeDown.setPower(-1);
        } else {
            cascade.setPower(0.2);
            cascadeDown.setPower(1);
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
}