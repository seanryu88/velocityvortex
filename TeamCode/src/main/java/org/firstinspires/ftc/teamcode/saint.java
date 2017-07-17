package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by Jeremy Chang on 2017-04-22.
 */

@Autonomous
public class saint extends LinearOpMode
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
    Servo beaconr;
    Servo clunk;
    ColorSensor color1;

    public saint() {}

    public void runOpMode() throws InterruptedException {

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


        motorFRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBRight.setDirection(DcMotorSimple.Direction.REVERSE);

        motorBLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        beaconr.setPosition(1.0);
        beaconl.setPosition(1.0);
        clunk.setPosition(1.0);



        waitForStart();

        //eating2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        /*motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/

        this.sleep(3000);





        motorBLeft.setPower(0.35);
        motorFLeft.setPower(0.35);
        motorBRight.setPower(0.35);
        motorBLeft.setPower(0.35);
        this.sleep(1500);

        motorBLeft.setPower(0);
        motorFLeft.setPower(0);
        motorBRight.setPower(0);
        motorFRight.setPower(0);
        shooting.setPower(0.56); //54 1 ball 13.3 //12.8v-0.58 2 balls
        this.sleep(4000);
        eating.setPower(0.55);
        this.sleep(3000);

        motorFRight.setPower(0.35);
        motorFLeft.setPower(0.35);
        motorBRight.setPower(0.35);
        motorBLeft.setPower(0.35);
        this.sleep(1500);
        stop();
        /*telemetry.addData("1","1");

        shooting.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry.addData("2","2");
        shooting.setTargetPosition(220);

        telemetry.addData("3","3");
        shooting.setPower(0.1);


        telemetry.addData("4","4");

        this.sleep(2000);

        eating2.setPower(1);

        telemetry.addData("5", "5");

        this.sleep(2000);


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

        motorBRight.setTargetPosition(3000);
        motorBLeft.setTargetPosition(3000);
        motorFLeft.setTargetPosition(3000);
        motorFRight.setTargetPosition(3000);

        motorFLeft.setPower(0.3);
        motorBLeft.setPower(0.3);
        motorFRight.setPower(0.3);
        motorBRight.setPower(0.3);

        shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        telemetry.addData("hello", "world");

        telemetry.update();

        this.sleep(8000);*/





    }
    //shooting(10000);
        /*while (shooting.getCurrentPosition()  < 1430)
        {
            shooting(10000);
            if (shooting.getCurrentPosition() == 1300)
            {
                dtd(1000);
            }
            this.sleep(2000);
        }
        drive(8000, 8000, 8000, 8000);
    }*/



    /*public void drive(int a, int b, int c, int d)
    {
        telemetry.addData("in drive","111");
        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setTargetPosition(motorFLeft.getCurrentPosition()+a);
        motorBLeft.setTargetPosition(motorBLeft.getCurrentPosition()+b);
        motorFRight.setTargetPosition(motorFRight.getCurrentPosition()+c);
        motorBRight.setTargetPosition(motorBRight.getCurrentPosition()+d);

        telemetry.addData("in drive","222");

        motorFLeft.setPower(0.6);
        motorBLeft.setPower(0.6);
        motorFRight.setPower(0.6);
        motorBRight.setPower(0.6);

        telemetry.addData("in drive","3333");
    }
    public void shooting(int e)
    {
        //telemetry.addData("6","6");

        shooting.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //telemetry.addData("7","7");
        //shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        telemetry.addData("8","8");
        shooting.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry.addData("9","9");
        shooting.setTargetPosition(e);
        telemetry.addData("10","10");
        shooting.setPower(0.5);
        telemetry.addData("11","11");
        shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        telemetry.addData("12","12");
    }*/

}