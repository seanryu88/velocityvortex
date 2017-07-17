package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by seanryu on 16/01/2017.
 */

public class crazy extends LinearOpMode
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

        waitForStart();
        auto.setPosition(1.0);

        color1.enableLed(true);
        motorBLeft.setPower(0.5);
        motorBRight.setPower(0.5);
        motorFLeft.setPower(0.5);
        motorFRight.setPower(0.5);

        while (color1.blue()<3)
        {
            motorBLeft.setPower(0.5);
            motorBRight.setPower(0.5);
            motorFLeft.setPower(0.5);
            motorFRight.setPower(0.5);
        }


    }
}
