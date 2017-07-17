package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by seanryu on 15/04/2017.
 */
@Autonomous(name = "ssibal", group = "Teamcode")
public class ssibal extends LinearOpMode
{
    DcMotor motorFLeft;
    DcMotor motorBRight;
    DcMotor motorBLeft;
    DcMotor motorFRight;
    DcMotor shooting;
    DcMotor eating;
    DcMotor railL;
    DcMotor railR;
    Servo beaconl;
    Servo   beaconr;
    Servo   clunk;
    ColorSensor color1;
    public void runOpMode() throws InterruptedException
    {
        motorFRight = hardwareMap.dcMotor.get("motorFRight");
        motorFLeft = hardwareMap.dcMotor.get("motorFLeft");

        motorBRight = hardwareMap.dcMotor.get("motorBRight");
        motorBLeft = hardwareMap.dcMotor.get("motorBLeft");

        shooting = hardwareMap.dcMotor.get("shooting");
        eating = hardwareMap.dcMotor.get("eating");
        railL = hardwareMap.dcMotor.get("railL");
        railR = hardwareMap.dcMotor.get("railR");

        beaconr = hardwareMap.servo.get("beaconr");
        beaconl = hardwareMap.servo.get("beaconl");
        clunk = hardwareMap.servo.get("clunk");

        color1 = hardwareMap.colorSensor.get("color1");

        //stick = hardwareMap.opticalDistanceSensor.get("stick");

        color1.enableLed(false);


        motorBRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFRight.setDirection(DcMotorSimple.Direction.REVERSE);

        /*motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/

        beaconr.setPosition(1.0);
        beaconl.setPosition(1.0);
        clunk.setPosition(0);

        waitForStart();


        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorBRight.setTargetPosition(3140);
        motorBLeft.setTargetPosition(3140);
        motorFLeft.setTargetPosition(3140);
        motorFRight.setTargetPosition(3140);

        motorFLeft.setPower(0.3);
        motorBLeft.setPower(0.3);
        motorFRight.setPower(0.3);
        motorBRight.setPower(0.3);

        /*
        this.sleep(4000);
        shoot(230);


        this.sleep(2300);
        this.sleep(1200);
        */

    }
}
