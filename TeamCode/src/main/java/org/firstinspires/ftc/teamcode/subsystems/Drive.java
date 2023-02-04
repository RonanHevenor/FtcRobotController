package org.firstinspires.ftc.teamcode.subsystems;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drive {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    public Drive(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotor.class, "leftFront"); // Port 0 CH
        frontRight = hardwareMap.get(DcMotor.class, "rightFront"); // Port 1 CH
        backLeft = hardwareMap.get(DcMotor.class, "leftRear"); // Port 2 CH
        backRight = hardwareMap.get(DcMotor.class, "rightRear"); // Port 3 CH

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void spinLeftRaw(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power*-1);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void spinRightRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power*-1);
    }

    public void strafeLeftRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power*-1);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power);
    }

    public void strafeRightRaw(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power*-1);
    }

    public void backwardRaw(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power*-1);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power*-1);
    }

    public void forwardRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void forwardRaw() {
        forwardRaw(1);
    }

    public void strafeLeftRaw() {
        strafeLeftRaw(1);
    }

    public void strafeRightRaw() {
        strafeRightRaw(1);
    }

    public void backwardRaw() {
        backwardRaw(1);
    }

    public void spinLeftRaw() {
        spinLeftRaw(1);
    }

    public void spinRightRaw() {
        spinRightRaw(1);
    }

    public void Run_without_encoder() {
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void run_using_encoder() {
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void run_to_position() {
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void stop_and_reset_encoders() {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void forward(double power, int ticks, Telemetry telemetry) {
        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        stop_and_reset_encoders();

        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);

        run_to_position();

        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);

        while (backLeft.isBusy()) {
            telemetry.addData("Status", "waiting for finish");
            telemetry.update();
        }
    }

    public void spinLeft(double power, int ticks, Telemetry telemetry) {
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        stop_and_reset_encoders();

        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);

        run_to_position();

        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);

        while (backLeft.isBusy()) {
            telemetry.addData("Status", "waiting for finish");
            telemetry.update();
        }

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }
}