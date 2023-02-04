package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.autos.Mark_I;
import org.firstinspires.ftc.teamcode.autos.mark_ii.methods;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

@Autonomous
public class auto extends LinearOpMode {

    public Drive drive;
    public System system;

    @Override
    public void runOpMode() {
        drive = new Drive(hardwareMap);
        system = new System(hardwareMap);

        //Reset the encoder
        //Make sure it starts in the same position each time, or else!!!
        system.out.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Run forward for this many ticks
        system.out.setTargetPosition(1000);

        //Prepare to run
        system.out.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        //GO!!!
        system.out.setPower(-0.5);

        while (system.out.isBusy()) {
            idle();
        }

        system.out.setPower(0);
    }
}