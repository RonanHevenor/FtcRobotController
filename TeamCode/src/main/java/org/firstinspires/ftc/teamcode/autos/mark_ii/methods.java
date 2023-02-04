package org.firstinspires.ftc.teamcode.autos.mark_ii;

import static android.os.SystemClock.sleep;

import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;

public class methods {
    public methods(Drive drive, System system) {}

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

//    public void pos_II(Drive drive, System system, int scan) {
//        if (scan == 1) {
////            // more advanced, uses lazy susan
////            //strafe right 2.5 tiles
////            drive.spinLeftRaw(0.3);
////            //cascade up
////            system.cascade.setPower(1);
////            sleep(2500);
////            system.cascade.setPower(0.2);
////            sleep(10000);
////            // grabber let go
////            // cascade down halfway
////            // strafe left 0.5 tiles
////            // lazy susan 180
////            // cascade down 2 in.
////            // grabber intake
////            // cascade up halfway
////            //
//        } else if (scan == 2) {
//            //other - more basic, not yet finished
//            drive.backwardRaw(0.3);
//            sleep(3000);
//            drive.backwardRaw(-1);
//            drive.backwardRaw(0);
//            sleep(1000);
//            drive.strafeRightRaw(0.3);
//            sleep(1200);
//            drive.strafeLeftRaw(-1);
//            drive.backwardRaw(0);
//            system.cascade.setPower(1);
//            sleep(5000);
//            drive.spinLeftRaw(0.3);
//            sleep(700);
//            drive.spinRightRaw(1);
//            drive.forwardRaw(0);
//            drive.spinLeftRaw(0.3);
//            sleep(750);
//            drive.spinRightRaw(1);
//            drive.forwardRaw(0);
//
//            // drop
//
//            // now go to parking spot
//            //backtrack
//            drive.spinRightRaw(0.3);
//            sleep(700);
//            drive.spinLeftRaw(1);
//            drive.forwardRaw(0);
//            drive.spinRightRaw(0.3);
//            sleep(750);
//            drive.spinLeftRaw(1);
//            drive.forwardRaw(0);
//            sleep(1000);
//            //backward
//            drive.forwardRaw(0.3);
//            sleep(1000);
//            drive.forwardRaw(0);
//            sleep(1000);
//        } else if (scan == 3) {
//
//        }
//    }

    public void L1(Drive drive, System system) {
        //forward
        drive.forwardRaw(0.4);
        sleep(1100);
        drive.forwardRaw(-1);
        drive.forwardRaw(0);

        sleep(1000);
        //strafe
        drive.strafeLeftRaw(0.4);
        sleep(1500);
        drive.strafeLeftRaw(-1);
        drive.strafeLeftRaw(0);
    }

    public void L2(Drive drive, System system) {
        //forward
        drive.forwardRaw(0.4);
        sleep(1100);
        drive.forwardRaw(-1);
        drive.forwardRaw(0);
    }

    public void L3(Drive drive, System system) {
        //forward
        drive.forwardRaw(0.4);
        sleep(1300);
        drive.forwardRaw(-1);
        drive.forwardRaw(0);

        //slides up and spin carousel
//        system.cascade.setPower(-1);
//        system.down.setPower(-0.4);
        sleep(800);
//        system.cascade.setPower(0);
//        system.down.setPower(0);

        system.carousel.setPower(-.7);
        sleep(1100);
        system.carousel.setPower(0);

        sleep(1000);
        //strafe
        drive.strafeLeftRaw(-0.4);
        sleep(1900);
        drive.strafeLeftRaw(1);
        drive.strafeLeftRaw(0);
    }
}
