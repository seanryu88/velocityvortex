package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by seanryu on 16/01/2017.
 */
@Autonomous(name = "thesimplerthebetter", group = "Teamcode")
public class thesimplerthebetter extends LinearOpMode
{
    DcMotor motorFLeft;
    DcMotor motorBRight;
    DcMotor motorBLeft;
    DcMotor motorFRight;
    DcMotor shooting;
    DcMotor eating;
    DcMotor eating2;
    DcMotor rail;
    Servo auto;
    Servo   clunk;
    ColorSensor color1;

    @Override
    public void runOpMode() throws InterruptedException
    {
        motorFRight = hardwareMap.dcMotor.get("motor_2");
        motorFLeft = hardwareMap.dcMotor.get("motor_1");

        motorBRight = hardwareMap.dcMotor.get("motor_4");
        motorBLeft = hardwareMap.dcMotor.get("motor_3");

        shooting = hardwareMap.dcMotor.get("shooting");
        eating = hardwareMap.dcMotor.get("eating");
        eating2 = hardwareMap.dcMotor.get("eating2");
        rail = hardwareMap.dcMotor.get("rail");

        auto = hardwareMap.servo.get("auto");
        clunk = hardwareMap.servo.get("clunk");

        color1 = hardwareMap.colorSensor.get("color1");
        auto.setPosition(1.0);

        color1.enableLed(false);


        motorFRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBRight.setDirection(DcMotorSimple.Direction.REVERSE);


        auto.setPosition(1.0);
        clunk.setPosition(1.0);

        waitForStart();

        this.sleep(500);

        //shoot(7000);
        while (shooting.getCurrentPosition()<1450)
        {
            shoot(10000);
            if (shooting.getCurrentPosition() > 1300)
            {
                dtd(800);
            }
        }

        /*this.sleep(1100);

        dtd(800);

        this.sleep(1500);
        eating(5000);

        this.sleep(1000);*/

        if (!motorBLeft.isBusy()) {
            motorFRight.setPower(0.025);
            motorBRight.setPower(0.025);

            motorFLeft.setPower(0.025);
            motorBLeft.setPower(0.025);
        }


    }
    public void dtd(int h)
    {
        eating2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        eating2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        eating2.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        eating2.setTargetPosition(h);

        eating2.setPower(1.0);

        eating2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void shoot(int e)
    {
        shooting.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        shooting.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        shooting.setTargetPosition(e);

        shooting.setPower(0.69);

        shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void eating(int g) {

        eating.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        eating.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        eating.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        eating.setTargetPosition(g);

        eating.setPower(-1);

        eating.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);    }

    public void run(int a, int b, int c, int d)
    {
        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorBRight.setTargetPosition(a);
        motorFRight.setTargetPosition(b);

        motorBLeft.setTargetPosition(c);
        motorFLeft.setTargetPosition(d);

        do
        {

            motorBRight.setPower(1);
            motorFRight.setPower(1);

            motorBLeft.setPower(1);
            motorFLeft.setPower(1);

        }while (motorBRight.getCurrentPosition()<a && motorFRight.getCurrentPosition()<b && motorBLeft.getCurrentPosition()<c && motorFLeft.getCurrentPosition()<d);



    }

}

