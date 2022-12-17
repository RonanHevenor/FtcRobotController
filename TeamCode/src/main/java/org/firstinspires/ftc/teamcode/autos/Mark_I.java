package org.firstinspires.ftc.teamcode.autos;

import static android.os.SystemClock.sleep;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class Mark_I {
    public Mark_I(Drive drive, System system) {
        system.cascade.setPower(-.7);
        sleep(1500);
        system.cascade.setPower(-.2);

        drive.forwardRaw(0.3);
        sleep(1000);
        drive.backwardRaw(0);

        system.Drop();
    }
}
