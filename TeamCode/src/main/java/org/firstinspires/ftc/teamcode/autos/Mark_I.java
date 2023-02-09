package org.firstinspires.ftc.teamcode.autos;

import static android.os.SystemClock.sleep;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class Mark_I {
    public Mark_I() {}

    public void forward(Drive drive, System system, Telemetry telemetry, int numTiles) {
        drive.forward(0.1, 1110*numTiles, telemetry);
    }

    public void spinLeft(Drive drive, System system, Telemetry telemetry, int numTiles) {
//        drive.spinLeft(0.1, 1110*numTiles, telemetry);
    }
}
