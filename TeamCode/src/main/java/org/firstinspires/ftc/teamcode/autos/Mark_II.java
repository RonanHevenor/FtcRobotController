package org.firstinspires.ftc.teamcode.autos;

import static android.os.SystemClock.sleep;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class Mark_II {
    public Mark_II(Drive drive, System system) {}

    public void L1(Drive drive, System system) {
        //forward
        drive.backwardRaw(0.4);
        sleep(1100);
        drive.backwardRaw(-1);
        drive.backwardRaw(0);

        sleep(1000);
        //spin
        drive.spinRightRaw(0.4);
        sleep(1700);
        drive.spinRightRaw(-1);
        drive.spinRightRaw(0);
    }
    public void L2(Drive drive, System system) {
        //forward
        drive.backwardRaw(0.4);
        sleep(1100);
        drive.backwardRaw(-1);
        drive.backwardRaw(0);

        sleep(1000);
        //spin
        drive.spinRightRaw(0.4);
        sleep(1800);
        drive.spinRightRaw(-1);
        drive.spinRightRaw(0);
    }
    public void L3(Drive drive, System system) {
        //forward
        drive.backwardRaw(0.4);
        sleep(1100);
        drive.backwardRaw(-1);
        drive.backwardRaw(0);

        sleep(1000);
        //spin
        drive.spinRightRaw(0.4);
        sleep(1900);
        drive.spinRightRaw(-1);
        drive.spinRightRaw(0);
    }
}
