package org.firstinspires.ftc.teamcode.teleops;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class Mark_I {
    public Mark_I(Drive drive, System system) {}

    public int[] Run(Drive drive, System system, Gamepad gamepad1, int sM, int z, int x, int r, Telemetry telemetry) {
        drive.frontLeft.setPower(0);
        drive.frontRight.setPower(0);
        drive.backLeft.setPower(0);
        drive.backRight.setPower(0);

        telemetry.addData("speed", sM);
        telemetry.update();

        //Set up the speed multiplier for the round
        double a = gamepad1.left_stick_y;
        double b = gamepad1.left_stick_x;
        double c = gamepad1.right_stick_x;

        if ((a + b + c) == 0) {
            sM = 0;
        } else {
            //Incrementally increase sM
            sM += 1;

            double speed = gamepad1.left_stick_y * 0.02 * sM;
            double turn = -gamepad1.left_stick_x * 0.02 * sM;
            double strafe = gamepad1.right_stick_x * 0.02 * sM;
            drive.frontLeft.setPower((speed + turn) + strafe);
            drive.frontRight.setPower((speed - turn) - strafe);
            drive.backLeft.setPower((speed - turn) + strafe);
            drive.backRight.setPower((speed + turn) - strafe);
        }

        if (gamepad1.dpad_down) {
            system.leftUp.setPower(-0.1);
            system.rightUp.setPower(-0.1);
        } else if (gamepad1.dpad_up) {
            system.leftUp.setPower(0.5);
            system.rightUp.setPower(0.5);
        } else {
            system.leftUp.setPower(0.1);
            system.rightUp.setPower(0.1);
        }

        if (gamepad1.dpad_left) {
            system.carousel.setPower(-.7);
        } else if (gamepad1.dpad_right) {
            system.carousel.setPower(.7);
        } else {
            system.carousel.setPower(0);
        }

        if (gamepad1.a) { //close
            system.grabber.setPower(-1);
        } else if (gamepad1.b) { //open
            system.grabber.setPower(1);
            sleep(210);
            system.grabber.setPower(0);
        }
        //        } else {
        //            system.grabber.setPower(0);
        //        }

        if (gamepad1.x) {
            system.out.setPower(0.5);
        } else if (gamepad1.y) {
            system.out.setPower(-0.5);
        } else {
            system.out.setPower(0);
        }

        if (gamepad1.left_bumper) {
            if (sM > 20) {
                sM -= 1;
            }
        } else if (gamepad1.right_bumper) {
            if (sM < 35) {
                sM += 1;
            }
        }

        //Return sM, z, x, and r using an int array
        int[] toReturn = {sM, z, x, r};
        return toReturn;
    }
}
