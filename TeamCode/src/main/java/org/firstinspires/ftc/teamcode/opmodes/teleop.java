package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.teleops.Mark_I;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

@TeleOp
public class teleop extends LinearOpMode {

    public Drive drive;
    public System system;
    public Mark_I run;

    @Override
    public void runOpMode() {
        drive = new Drive(hardwareMap);
        system = new System(hardwareMap);
        run = new Mark_I(drive, system);
        int speed = 0;
        int z = 0;
        int x = 0;
        int r = 0;

        drive.Run_without_encoder();

        telemetry.addData("Initialized", "Ready to start");
        waitForStart();

        while (opModeIsActive()) {
            int[] returned = run.Run(drive, system, gamepad1, speed, z, x, r, telemetry);
            speed = returned[0];
            z = returned[1];
            x = returned[2];
            r = returned[3];
            telemetry.update();
        }
    }
}
// Hi Susan, good luck :) I believe in you!
