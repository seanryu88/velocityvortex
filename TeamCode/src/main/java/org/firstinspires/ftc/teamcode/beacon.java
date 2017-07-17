package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by seanryu on 14/01/2017.
 */

    @Autonomous(name ="beacon", group = "Teamcode")
    public class beacon extends LinearOpMode {

    DcMotor motorFLeft;
    DcMotor motorBRight;
    DcMotor motorBLeft;
    DcMotor motorFRight;
    DcMotor shooting;
    DcMotor eating;
    DcMotor eating2;
    DcMotor rail;
    Servo auto;
    Servo clunk;
    ColorSensor color1;

    @Override
    public void runOpMode() throws InterruptedException {
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

        color1.enableLed(false);


        motorFRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBRight.setDirection(DcMotorSimple.Direction.REVERSE);


        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        auto.setPosition(0.6);
        clunk.setPosition(1.0);

        waitForStart();

        telemetry.addData("red", color1.red());
        telemetry.addData("blue", color1.blue());
        telemetry.addData("alpha", color1.alpha());

        auto.setPosition(1);



        while (color1.alpha()<2)
        {
            motorFLeft.setPower(0.03);
            motorBLeft.setPower(0.03);
            motorFRight.setPower(0.03);
            motorBRight.setPower(0.03);
        }

        if (color1.red() > 2)
        {
            auto.setPosition(0.8);
        }
        else auto.setPosition(0.2);




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

        motorBRight.setTargetPosition(1120);
        motorBLeft.setTargetPosition(1120);
        motorFLeft.setTargetPosition(1120);
        motorFRight.setTargetPosition(1120);

        motorFLeft.setPower(0.3);
        motorBLeft.setPower(0.3);
        motorFRight.setPower(0.3);
        motorBRight.setPower(0.3);
    }
}

