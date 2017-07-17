package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Gamepad;
import java.util.Timer;

/**
 * Created by JeremyChang on 26/12/16.
 */


@TeleOp (name = "Maincode" , group = "TeamCode")
public class Maincode extends OpMode {

    DcMotor motorFRight;
    DcMotor motorFLeft;
    DcMotor motorBRight;
    DcMotor motorBLeft;
    DcMotor eating;
    //DcMotor eating2;
    DcMotor shooting;
    DcMotor railR;
    DcMotor railL;
    Servo beaconr;
    Servo beaconl;
    Servo clunk;
    ColorSensor color1;

    public Maincode() {
    }

    @Override
    public void init() {
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



        motorFRight.setDirection(DcMotor.Direction.REVERSE);
        motorBRight.setDirection(DcMotor.Direction.REVERSE);

        motorBLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        clunk.setPosition(1.0);
        beaconr.setPosition(1.0);
        beaconl.setPosition(1.0);

    }

    /*public void shoooting () {
        if (gamepad2.x) {
            shooting.setPower(0.02);
        }

        else {
            shooting.setPower(0.0);
        }
    }*/

    public void shooooting() {
        if (gamepad2.left_bumper) {
            shooting.setPower(0.50);
        } else if (gamepad2.dpad_up) {
            shooting.setPower(-0.4);
        } else {
            shooting.setPower(0.0);
        }
    }

    /*public void shoooooting () {
        float shoot = -gamepad2.left_trigger;
        shoot = Range.clip(shoot, 0, 1);
        scaleInput(shoot);
        shooting.setPower(shoot);
    }*/

    public void moving() {
        float left = -gamepad1.left_stick_y;
        float right = -gamepad1.right_stick_y;

        right = Range.clip(right, -1, 1);
        left = Range.clip(left, -1, 1);

        scaleInput(right);
        scaleInput(left);

        motorFRight.setPower(right);
        motorFLeft.setPower(left);
        motorBRight.setPower(right);
        motorBLeft.setPower(left);
    }

    public void eating1() {

        if (gamepad2.b) {
            eating.setPower(-0.8);
        }

        else if (gamepad2.a) {
            eating.setPower(0.9);
        }

        else {
            eating.setPower(0.0);
        }

    }


    /*public void eating3() {
        if (gamepad2.right_bumper) {
            eating2.setPower(1.0);
        } else if (gamepad2.dpad_down) {
            eating2.setPower(-1.0);
        } else {
            eating2.setPower(0.0);
        }
    }*/

    public void raiil() {
        if (gamepad2.y) {
            railR.setPower(0.75);
            railL.setPower(-0.75);//올라간다
        } else if (gamepad2.x) {
            railR.setPower(-0.75);
            railL.setPower(0.75);//내려간다
        } else {
            railR.setPower(0);
            railL.setPower(0);
        }
    }

    public void clunkhard() {
        if (gamepad1.right_bumper) {
            clunk.setPosition(0.0);
        } else {
            clunk.setPosition(1.0);
        }
    }

    public void beaconrr() {
        if (gamepad2.dpad_right) {
            beaconr.setPosition(0.0);

        }
        else {
            beaconr.setPosition(1.0);
        }
    }

    public void beaconll() {
        if (gamepad2.dpad_left) {
            beaconl.setPosition(0.0);
        }
        else {
            beaconl.setPosition(1.0);
        }
    }

    /*public void minjae() {
        if (gamepad1.dpad_left)
            railL.setPower(-0.5);//올라간다
        else if(gamepad1.dpad_right)
            railL.setPower(0.5);//내려간다
        else if(gamepad1.dpad_up)
            railR.setPower(0.5);//올라간다
        else if(gamepad1.dpad_down)
            railR.setPower(-0.5);//내려간다
        else {
            railL.setPower(0);
            railR.setPower(0);
        }
    }*/

    /*public void nuna() {
        if (gamepad1.dpad_up) {
            motorBLeft.setPower(0.2);
            motorFLeft.setPower(0.2);
            motorBRight.setPower(0.2);
            motorFRight.setPower(0.2);
        }
        else {
            motorBLeft.setPower(0);
            motorFLeft.setPower(0);
            motorBRight.setPower(0);
            motorFRight.setPower(0);
        }
    }*/
    /*public void autohard() {
        if (gamepad1.b) {
            auto.setPosition(0.8);
        } else {
            auto.setPosition(0.2);
        }
    }
    */

    /*
    public void toggle()
    {
        boolean a = true;
        if (gamepad2.dpad_right)
        {
            a = !a;f
        }

        if (a=true)
        {
            eating.setPower(-1);
        }
        if (a!=true)
        {
            eating.setPower(0);
        }
    }
    */


    @Override
    public void loop() {
        //shoooting();
        shooooting();
        //shoooooting ();
        moving();
        eating1();
        //eating3();
        raiil();
        clunkhard();
        beaconrr();
        beaconll();
        //nuna();
        //minjae();
        //autohard();
        //toggle();

        telemetry.addData("encoder", shooting.getCurrentPosition());

    }

    @Override
    public void stop() {

    }

    double scaleInput(double dVal) {
        double[] scaleArray = {0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24, 0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};

        int index = (int) (dVal * 16.0);
        if (index < 0) {
            index = -index;
        }

        if (index > 16) {


            index = 16;
        }

        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;

    }


}