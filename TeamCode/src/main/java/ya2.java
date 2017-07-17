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
 * Created by seanryu on 22/04/2017.
 */
@Autonomous(name = "ya2", group = "teamcode")
public class ya2 extends LinearOpMode {
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

        beaconr.setPosition(1.0);
        beaconl.setPosition(1.0);
        clunk.setPosition(1.0);

        waitForStart();

        VuforiaLocalizer.Parameters param = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        param.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        param.vuforiaLicenseKey = "AcIiJzT/////AAAAGWzmiAddjEclrmk3fpDmDs81N4kPImcePi9ZqKK+nzerAAvCjbtqJDZRt7WGiu9bgdxTXH1Vve9LPH/7LtVv/inxCtWP/cHIWa9k9sP4f2OyjJXUjndX6+bVwYVuty7NIlcTfGe2ge2f0CwRm1DH6yiK9CZ5FCMuC58KkwnqK1lVDgAKZobuFpgfjMS8P2rfztE99mragfg5xFT6CK0RyBkci2V+1vs4rwGRoLWLybq2pRX36tttfgJOhUGSeRdF4YiqHRyetPu4hp59howr5JJrrOc0LK1JvK+Thahfx1HFSnagMMuxDS6My7egNTwaNAShdpp93w8xu8gMfhcZd/Wzn0gd2NnIIAPEf/KWllcL\n";
        param.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        VuforiaLocalizerImplSubclass vuforia = new VuforiaLocalizerImplSubclass(param);

        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

        VuforiaTrackables beacons = vuforia.loadTrackablesFromAsset("FTC_2016-17");
        beacons.get(0).setName("Wheels");
        beacons.get(1).setName("Tools");
        beacons.get(2).setName("Lego");
        beacons.get(3).setName("Gears");

        VuforiaTrackableDefaultListener gears = (VuforiaTrackableDefaultListener) beacons.get(3).getListener();

        beacons.activate();

        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorFRight.setPower(0.36);
        motorBRight.setPower(0.36);

        motorFLeft.setPower(0.36);
        motorBLeft.setPower(0.36);



        while (opModeIsActive() && gears.getPose() != null)
        {
            idle();
        }


        motorFRight.setPower(0);
        motorBRight.setPower(0);

        motorFLeft.setPower(0);
        motorBLeft.setPower(0);

        this.sleep(1000);

        //------------hoho

        VectorF angles = anglesFromTarget(gears);

        VectorF trans = navOffWall(gears.getPose().getTranslation(), (Math.toDegrees(angles.get(1)) - 90), new VectorF(500, 0, 400));


        if (trans.get(1) > 0)
        {

            motorFRight.setPower(0.05);
            motorBRight.setPower(0.05);

            motorFLeft.setPower(-0.05);
            motorBLeft.setPower(-0.05);


        }
        else
        {
            motorBRight.setPower(-0.05);
            motorFRight.setPower(-0.05);
            motorBLeft.setPower(0.05);
            motorFLeft.setPower(0.05);
        }



        do
        {
            if (gears.getPose() != null)
            {
                trans = navOffWall(gears.getPose().getTranslation(), Math.toDegrees(angles.get(1)) - 90, new VectorF(500, 0, 400));
            }
            idle();
        } while (opModeIsActive() && Math.abs(trans.get(1)) > 20);


/*
        while (opModeIsActive() && (gears.getPose() == null || (Math.abs(gears.getPose().getTranslation().get(1)) > 10)))
        {
            if (gears.getPose() != null)
            {
                if (gears.getPose().getTranslation().get(1) > 0)
                {
                    motorFLeft.setPower(-0.05);
                    motorBLeft.setPower(-0.05);

                    motorFRight.setPower(0.05);
                    motorBRight.setPower(0.05);
                }
                else
                {
                    motorFLeft.setPower(0.05);
                    motorBLeft.setPower(0.05);

                    motorFRight.setPower(-0.05);
                    motorBRight.setPower(-0.05);
                }
            }
            else
            {
                motorFLeft.setPower(0.05);
                motorBLeft.setPower(0.05);

                motorFRight.setPower(-0.05);
                motorBRight.setPower(-0.05);

            }
        }
*/
        this.sleep(1000);


        motorFLeft.setPower(0);
        motorBLeft.setPower(0);

        motorFRight.setPower(0);
        motorBRight.setPower(0);

        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorFLeft.setTargetPosition((int) (motorFLeft.getCurrentPosition() + (Math.hypot(trans.get(1), trans.get(2)+200) / 319.024 * 1120)));
        motorBLeft.setTargetPosition((int) (motorBLeft.getCurrentPosition() + (Math.hypot(trans.get(1), trans.get(2)+200) / 319.024 * 1120)));

        motorBRight.setTargetPosition((int) (motorBRight.getCurrentPosition() + (Math.hypot(trans.get(1), trans.get(2)+200) / 319.024 * 1120)));
        motorFRight.setTargetPosition((int) (motorFRight.getCurrentPosition() + (Math.hypot(trans.get(1), trans.get(2)+200) / 319.024 * 1120)));

        motorFLeft.setPower(0.28);
        motorBLeft.setPower(0.28);

        motorFRight.setPower(0.28);
        motorBRight.setPower(0.28);


        while (opModeIsActive() && motorFRight.isBusy() && motorBRight.isBusy() && motorFLeft.isBusy() && motorBLeft.isBusy())
        {
            idle();
        }


        motorBLeft.setPower(0);
        motorFLeft.setPower(0);

        motorBRight.setPower(0);
        motorFRight.setPower(0);



        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        while (opModeIsActive() && (gears.getPose() == null || (Math.abs(gears.getPose().getTranslation().get(1)) > 10)))
        {
            if (gears.getPose() != null)
            {
                if (gears.getPose().getTranslation().get(1) > 0)
                {
                    motorFLeft.setPower(-0.05);
                    motorBLeft.setPower(-0.05);

                    motorFRight.setPower(0.05);
                    motorBRight.setPower(0.05);
                }
                else
                {
                    motorFLeft.setPower(0.05);
                    motorBLeft.setPower(0.05);

                    motorFRight.setPower(-0.05);
                    motorBRight.setPower(-0.05);
                }
            }
            else
            {
                motorFLeft.setPower(0.05);
                motorBLeft.setPower(0.05);

                motorFRight.setPower(-0.05);
                motorBRight.setPower(-0.05);

            }
        }


        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorBRight.setTargetPosition(motorBRight.getCurrentPosition()+560);
        motorBLeft.setTargetPosition(motorBLeft.getCurrentPosition()+560);
        motorFLeft.setTargetPosition(motorFLeft.getCurrentPosition()+560);
        motorFRight.setTargetPosition(motorFRight.getCurrentPosition()+560);


        motorFLeft.setPower(0.12);
        motorBLeft.setPower(0.12);
        motorFRight.setPower(0.12);
        motorBRight.setPower(0.12);


        /*
        if (color1.red() >= 2) {
            beaconr.setPosition(0);
            beaconl.setPosition(1);
        } else if (color1.blue() >= 2) {
            beaconl.setPosition(0);
            beaconr.setPosition(1);
        }
        */


        beaconr.setPosition(0);




    }
    public VectorF navOffWall(VectorF trans, double robotAngle, VectorF offWall) {
        return new VectorF((float) (trans.get(1) - offWall.get(1) * Math.sin(Math.toRadians(robotAngle)) - offWall.get(2) * Math.cos(Math.toRadians(robotAngle))), trans.get(0), (float) (trans.get(2) + offWall.get(1) * Math.cos(Math.toRadians(robotAngle)) - offWall.get(2) * Math.sin(Math.toRadians(robotAngle))));
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
