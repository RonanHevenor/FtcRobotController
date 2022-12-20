package org.firstinspires.ftc.teamcode.autos;

import static android.os.SystemClock.sleep;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class Mark_II {
    public Mark_II(Drive drive, System system) {}

//            R--------R    |   B---------B
//                  L1            L3
//            ----------    |   -----------
//             I    L2            L2    II
//            ----------    |   -----------
//                  L3            L1
//            R---------    |   ----------B
//                  L1            L3
//            ----------    |   -----------
//             III  L2            L2    IV
//            ----------    |   -----------
//                  L3            L1
//            B--------R    |   B---------R

    public void pos_II(Drive drive, System system, int scan) {
        if (scan == 1) {
//            // more advanced, uses lazy susan
//            //strafe right 2.5 tiles
//            drive.spinLeftRaw(0.3);
//            //cascade up
//            system.cascade.setPower(1);
//            sleep(2500);
//            system.cascade.setPower(0.2);
//            sleep(10000);
//            // grabber let go
//            // cascade down halfway
//            // strafe left 0.5 tiles
//            // lazy susan 180
//            // cascade down 2 in.
//            // grabber intake
//            // cascade up halfway
//            //
        } else if (scan == 2) {
            //other - more basic, not yet finished
            drive.backwardRaw(0.3);
            sleep(3000);
            drive.backwardRaw(-1);
            drive.backwardRaw(0);
            sleep(1000);
            drive.strafeRightRaw(0.3);
            sleep(1200);
            drive.strafeLeftRaw(-1);
            drive.backwardRaw(0);
            system.cascade.setPower(1);
            sleep(5000);
            drive.spinLeftRaw(0.3);
            sleep(700);
            drive.spinRightRaw(1);
            drive.forwardRaw(0);
            drive.spinLeftRaw(0.3);
            sleep(750);
            drive.spinRightRaw(1);
            drive.forwardRaw(0);

            // drop

            // now go to parking spot
                //backtrack
            drive.spinRightRaw(0.3);
            sleep(700);
            drive.spinLeftRaw(1);
            drive.forwardRaw(0);
            drive.spinRightRaw(0.3);
            sleep(750);
            drive.spinLeftRaw(1);
            drive.forwardRaw(0);
            sleep(1000);
                //backward
            drive.forwardRaw(0.3);
            sleep(1000);
            drive.forwardRaw(0);
            sleep(1000);
        } else if (scan == 3) {

        }
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
