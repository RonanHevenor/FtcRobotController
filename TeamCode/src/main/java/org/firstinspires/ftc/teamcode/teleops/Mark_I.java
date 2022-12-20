package org.firstinspires.ftc.teamcode.teleops;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class Mark_I {
    public Mark_I(Drive drive, System system) {}

    public void Run(Drive drive, System system, Gamepad gamepad1) {
        double speed = gamepad1.left_stick_y;
        double turn = -gamepad1.right_stick_x;
        double strafe = gamepad1.left_stick_x;
        drive.frontLeft.setPower((speed + turn) + strafe);
        drive.frontRight.setPower((speed - turn) - strafe);
        drive.backLeft.setPower((speed - turn) + strafe);
        drive.backRight.setPower((speed + turn) - strafe);

        if (gamepad1.dpad_up) {
            system.Elevate(1);
        } else if (gamepad1.dpad_down) {
            system.Elevate(0);
        } else {
            if (system.touch.isPressed()) {
                system.cascade.setPower(0);
//            system.cascadeDown.setPower(0);
            } else {
                system.cascade.setPower((-.2));
            }
        }

        if (gamepad1.dpad_left) {
            system.carousel.setPower(1);
        } else if (gamepad1.dpad_right) {
            system.carousel.setPower(-1);
        } else {
            system.carousel.setPower(0);
        }

        if (gamepad1.a) {
            system.spinLeft.setPosition(-1);
            system.spinRight.setPosition(1);
        } else if (gamepad1.b) {
            system.spinLeft.setPosition(1);
            system.spinRight.setPosition(-1);
        }
    }
}
