package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by seanryu on 03/01/2017.
 */
@TeleOp(name = "plz")
public class plz extends LinearOpMode
{
    DcMotor motorFrontRight,motorFrontLeft, motorBackRight, motorBackLeft;
    int leftFrontPos, leftBackPos, rightFrontPos, rightBackPos;

    @Override
    public void runOpMode() throws InterruptedException {

        // opticalDistanceSensor = hardwareMap.opticalDistanceSensor.get("sensor_ods");

        motorFrontRight = hardwareMap.dcMotor.get("front_right");
        motorFrontLeft = hardwareMap.dcMotor.get("front_left");
        motorBackRight = hardwareMap.dcMotor.get("back_right");
        motorBackLeft = hardwareMap.dcMotor.get("back_left");

        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        // Reset enoders to zero
        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        waitOneFullHardwareCycle(); // We use these in attempt to gain stability.


        motorFrontLeft.setTargetPosition(2440);
        motorFrontRight.setTargetPosition(2440);
        motorBackLeft.setTargetPosition(2440);
        motorBackRight.setTargetPosition(2440);

        leftFrontPos = motorFrontLeft.getCurrentPosition();
        leftBackPos = motorBackLeft.getCurrentPosition();
        rightFrontPos = motorFrontRight.getCurrentPosition();
        rightBackPos = motorBackRight.getCurrentPosition();

        motorFrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(leftBackPos < 2440 && leftFrontPos < 2440 && rightBackPos < 2440 && rightFrontPos < 2440){
            motorFrontLeft.setPower(-0.5);
            motorFrontRight.setPower(-0.5);
            motorBackLeft.setPower(-0.5);
            motorBackRight.setPower(-0.5);

            leftFrontPos = motorFrontLeft.getCurrentPosition();
            leftBackPos = motorBackLeft.getCurrentPosition();
            rightFrontPos = motorFrontRight.getCurrentPosition();
            rightBackPos = motorBackRight.getCurrentPosition();
        }

        telemetry.addData("2 ", "motorFrontLeft:  " + String.format("%d", motorFrontLeft.getTargetPosition()));
        telemetry.addData("3 ", "motorFrontRight:  " + String.format("%d", motorFrontRight.getTargetPosition()));
        telemetry.addData("4 ", "motorBackLeft:  " + String.format("%d", motorBackLeft.getTargetPosition()));
        telemetry.addData("5 ", "motorBackRight:  " + String.format("%d", motorBackRight.getTargetPosition()));
    }
}
