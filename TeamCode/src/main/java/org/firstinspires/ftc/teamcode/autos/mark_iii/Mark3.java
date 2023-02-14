/*
 * Copyright (c) 2021 OpenFTC Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.firstinspires.ftc.teamcode.autos.mark_iii;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.Drive;
import org.firstinspires.ftc.teamcode.subsystems.System;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;

// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY
// PARKING AUTO WITH APRIL TAGS WORKS PERFECTLY

@Autonomous
public class Mark3 extends LinearOpMode
{
    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;
    public methods mark_ii;
    public Drive drive;
    public System system;

    static final double FEET_PER_METER = 3.28084;

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;

    // UNITS ARE METERS
    double tagsize = 0.166;

    int ID_TAG_OF_INTEREST = 1; // Tag ID 18 from the 36h11 family

    AprilTagDetection tagOfInterest = null;

    @Override
    public void runOpMode()
    {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);
        drive = new Drive(hardwareMap);
        system = new System(hardwareMap);
        mark_ii = new methods(drive, system);

        // arms up!
        // to cone-off-ground position
//        system.leftUp.setPower(0.75);
//        system.rightUp.setPower(0.75);
//        sleep(500);
//        system.leftUp.setPower(0.1);
//        system.rightUp.setPower(0.1);
//        sleep(500);


        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(800,448, OpenCvCameraRotation.UPRIGHT);
                FtcDashboard.getInstance().startCameraStream(camera, 0);
            }

            @Override
            public void onError(int errorCode)
            {

            }
        });

        telemetry.setMsTransmissionInterval(50);

        /*
         * The INIT-loop:
         * This REPLACES waitForStart!
         */
        while (!isStarted() && !isStopRequested())
        {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id == 0)
                    {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }else if(tag.id == 1) {
                    tagOfInterest = tag;
                    tagFound = true;
                    break;
                    } else if(tag.id == 2) {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }
                }

                if(tagFound)
                {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    tagToTelemetry(tagOfInterest);
                }
                else
                {
                    telemetry.addLine("Don't see tag of interest :(");

                    if(tagOfInterest == null)
                    {
                        telemetry.addLine("(The tag has never been seen)");
                    }
                    else
                    {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        tagToTelemetry(tagOfInterest);
                    }
                }

            }
            else
            {
                telemetry.addLine("Don't see tag of interest :(");

                if(tagOfInterest == null)
                {
                    telemetry.addLine("(The tag has never been seen)");
                }
                else
                {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    tagToTelemetry(tagOfInterest);
                }

            }

            telemetry.update();
            sleep(20);
        }

        /*
         * The START command just came in: now work off the latest snapshot acquired
         * during the init loop.
         */

        /* Update the telemetry */
        if(tagOfInterest != null)
        {
            telemetry.addLine("Tag snapshot:\n");
            tagToTelemetry(tagOfInterest);
            telemetry.update();
        }
        else
        {
            telemetry.addLine("No tag snapshot available, it was never sighted during the init loop :(");
            telemetry.update();
        }

        /* Actually do something useful */
        if(tagOfInterest == null)
        {
            /*
             * Insert your autonomous code here, presumably running some default configuration
             * since the tag was never sighted during INIT
             */
            // grab cone
            sleep(500);
            system.grabber.setPower(1);
            sleep(1000);
            system.grabber.setPower(0.1);
            sleep(500);

            // lift to cone-off-ground position
            // turn position is(ms): 500
            system.leftUp.setPower(0.75);
            system.rightUp.setPower(0.75);
            sleep(1000);
            system.leftUp.setPower(0.1);
            system.rightUp.setPower(0.1);

            // goto position
            // position is below
            drive.forward(0.75, 2300, telemetry);
            sleep(500);
            drive.strafeRight(0.75, 350, telemetry);

            // lift to turn position
            // turn position is(ms): 500
            system.leftUp.setPower(0.75);
            system.rightUp.setPower(0.75);
            sleep(500);
            system.leftUp.setPower(0.1);
            system.rightUp.setPower(0.1);

            // carousel to pole position
            // pole position is:
            system.setCarousel(-550, telemetry);

            // lift to apex position
            // apex position requires time(ms):
            system.leftUp.setPower(0.75);
            system.rightUp.setPower(0.75);
            sleep(2000);
            system.leftUp.setPower(0.1);
            system.rightUp.setPower(0.1);

            // out to pole position
            // pole position requires time(ms):
            system.out.setPower(-0.3);
            sleep(3500);
            system.out.setPower(0);

            // down to letgo position
            // apex position requires time(ms):
            system.leftUp.setPower(-0.1);
            system.rightUp.setPower(-0.1);
            sleep(200);
            system.leftUp.setPower(0.1);
            system.rightUp.setPower(0.1);
            sleep(500);

            // pause to #notbounce
            sleep(500);

            // grabber open
            system.grabber.setPower(-1);
            sleep(500);
            system.grabber.setPower(0);
            sleep(500);

            // --------- It all fricking works --------- //
            // reset all
            // in and down
            system.out.setPower(0.3);
            system.leftUp.setPower(0);
            system.rightUp.setPower(0);
            sleep(3500);
            system.out.setPower(0);

            // spin
            system.setCarousel(0, telemetry);

            sleep(500);
        }
        else
        {
            if (tagOfInterest.id == 0) {
                mark_ii.L1(drive, system);
//                sleep(10000);
//                requestOpModeStop();
            }
            else if (tagOfInterest.id == 1) {
                mark_ii.L2(drive, system);
//                sleep(10000);
//                requestOpModeStop();
            }
            else if (tagOfInterest.id == 2) {
                mark_ii.L3(drive, system);
//                sleep(10000);
//                requestOpModeStop();
            }
        }
    }

    void tagToTelemetry(AprilTagDetection detection)
    {
        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z*FEET_PER_METER));
        telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", Math.toDegrees(detection.pose.yaw)));
        telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", Math.toDegrees(detection.pose.pitch)));
        telemetry.addLine(String.format("Rotation Roll: %.2f degrees", Math.toDegrees(detection.pose.roll)));
    }
}
