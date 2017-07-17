package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by seanryu on 23/04/2017.
 */
@Autonomous(name = "university", group = "teamcode")
public class university extends LinearOpMode
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

    @Override
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


        motorFRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBRight.setDirection(DcMotorSimple.Direction.REVERSE);

        motorBLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        beaconr.setPosition(1.0);
        beaconl.setPosition(1.0);
        clunk.setPosition(1.0);

        waitForStart();


        motorBLeft.setPower(0.4);
        motorFLeft.setPower(0.4);
        motorBRight.setPower(0.4);
        motorBLeft.setPower(0.4);
        this.sleep(1500);



        motorBLeft.setPower(0.2);
        motorFLeft.setPower(0.2);
        motorBRight.setPower(-0.2);
        motorFRight.setPower(-0.2);
        this.sleep(650);



        motorBLeft.setPower(0.35);
        motorFLeft.setPower(0.35);
        motorBRight.setPower(0.35);
        motorFRight.setPower(0.35);
        this.sleep(1500);

        beaconl.setPosition(0);
    }
    public VectorF navOffWall(VectorF trans, double robotAngle, VectorF offWall) {
        return new VectorF((float) (trans.get(1) - offWall.get(0) * Math.sin(Math.toRadians(robotAngle)) - offWall.get(2) * Math.cos(Math.toRadians(robotAngle))), trans.get(0), (float) (trans.get(2) + offWall.get(0) * Math.cos(Math.toRadians(robotAngle)) - offWall.get(2) * Math.sin(Math.toRadians(robotAngle))));

        //I changed the coordinates of the OffWall function; 0 to 1
    }

    public VectorF anglesFromTarget(VuforiaTrackableDefaultListener image) {
        float[] data = image.getRawPose().getData();
        float[][] rotation = {{data[0], data[1]}, {data[4], data[5], data[6]}, {data[8], data[9], data[10]}};
        double thetaX = Math.atan2(rotation[2][1], rotation[2][2]);
        double thetaY = Math.atan2(-rotation[2][0], Math.sqrt(rotation[2][1] * rotation[2][1] + rotation[2][2] * rotation[2][2]));
        double thetaZ = Math.atan2(rotation[1][0], rotation[0][0]);
        return new VectorF((float) thetaX, (float) thetaY, (float) thetaZ);
    }
}
