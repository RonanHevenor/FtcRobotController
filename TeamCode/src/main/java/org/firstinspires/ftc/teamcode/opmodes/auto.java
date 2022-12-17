package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.autos.Base;
import org.firstinspires.ftc.teamcode.autos.Mark_I;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

@Autonomous
public class auto extends LinearOpMode {

    public Drive drive;
    public System system;
    public Mark_I code;

    @Override
    public void runOpMode() {
        drive = new Drive(hardwareMap);
        system = new System(hardwareMap);

        code = new Mark_I(drive, system);
    }
}