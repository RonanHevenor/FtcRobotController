package org.firstinspires.ftc.teamcode.autos;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class oldmark1willorganizelater {
    public oldmark1willorganizelater(Drive drive, System system, Telemetry telemetry) {
        drive.forward(0.1, 1000, telemetry);
    }
}
