package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.autos.Base;
import org.firstinspires.ftc.teamcode.autos.Mark_I;
import org.firstinspires.ftc.teamcode.autos.Mark_II;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

@Autonomous
public class auto extends LinearOpMode {

    public Drive drive;
    public System system;
    public Mark_II code;

    @Override
    public void runOpMode() {

        waitForStart();

        drive = new Drive(hardwareMap);
        system = new System(hardwareMap);

        code = new Mark_II(drive, system);

        code.pos_II(drive, system, 2);
    }
}