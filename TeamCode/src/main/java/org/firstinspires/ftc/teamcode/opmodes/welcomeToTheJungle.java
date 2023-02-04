package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

@TeleOp
public class welcomeToTheJungle extends LinearOpMode {

    Drive drive;
    System system;

    @Override
    public void runOpMode() {
        Drive drive = new Drive(hardwareMap);
        System system = new System(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.left_stick_y > 0.5) {
//                system.cascade.setPower(1);
            } else if (gamepad1.left_stick_y < -0.5) {
//                system.cascade.setPower(-1);
            } else {
//                system.cascade.setPower(0.2);
            }
        }
    }
}
