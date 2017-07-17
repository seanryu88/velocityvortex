package org.firstinspires.ftc.teamcode;

import android.graphics.Bitmap;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.vuforia.HINT;
import com.vuforia.Vuforia;


import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by seanryu on 26/12/2016.
 */
@Autonomous(name ="owl", group = "Teamcode")
public class owl extends LinearOpMode
{
    DcMotor motorFLeft;
    DcMotor motorBRight;
    DcMotor motorBLeft;
    DcMotor motorFRight;
    DcMotor shooting;
    DcMotor eating;
    DcMotor eating2;
    DcMotor rail;
    Servo   auto;
    Servo   clunk;
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

        /*motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/

        auto.setPosition(0.8);
        clunk.setPosition(1.0);

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

        this.sleep(4000);
        shoot(230);


        this.sleep(2300);
        dtd(800);
        this.sleep(1200);

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

        motorBRight.setTargetPosition(0);
        motorFRight.setTargetPosition(0);

        motorBLeft.setTargetPosition(1200);
        motorFLeft.setTargetPosition(1200);

        motorFLeft.setPower(0.3);
        motorBLeft.setPower(0.3);
        motorFRight.setPower(0.3);
        motorBRight.setPower(0.3);




        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //The robot turns after going forward

        /*motorFLeft.setTargetPosition(1680);
        motorBLeft.setTargetPosition(1680);
        motorFRight.setTargetPosition(1680);
        motorBRight.setTargetPosition(1680);

        motorFLeft.setPower(1);
        motorBLeft.setPower(1);
        motorFRight.setPower(1);
        motorBRight.setPower(1);

        motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/

        //Vuforia Strarts here



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

        VuforiaTrackableDefaultListener wheels = (VuforiaTrackableDefaultListener) beacons.get(0).getListener();


        shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        eating2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        beacons.activate();


        try
        {
            idle();
        }
        catch (NullPointerException e)
        {
            telemetry.addData("sequence failed", "leggo im");


            shooting.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            motorBRight.setTargetPosition(4630);
            motorBLeft.setTargetPosition(4630);
            motorFLeft.setTargetPosition(4630);
            motorFRight.setTargetPosition(4630);

            motorFLeft.setPower(0.3);
            motorBLeft.setPower(0.3);
            motorFRight.setPower(0.3);
            motorBRight.setPower(0.3);

            this.sleep(20000);

            //code from im, which makes the robot just go forward
        }

        /*
        Trying to catch the Nullpointerexcepction error, a common error happening in the beginnig of the phase
         */


        motorFRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorFLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        motorFRight.setPower(0.48);
        motorBRight.setPower(0.48);

        motorFLeft.setPower(0.48);
        motorBLeft.setPower(0.48);


        while (opModeIsActive() && wheels.getRawPose() == null)
        {
            idle();
        }


        motorFRight.setPower(0);
        motorBRight.setPower(0);

        motorFLeft.setPower(0);
        motorBLeft.setPower(0);



        VectorF angles = anglesFromTarget(wheels);

        VectorF trans = navOffWall(wheels.getPose().getTranslation(), Math.toDegrees(angles.get(0)) - 90, new VectorF(300, 0, 0));

        if (trans.get(0) > 0)
        {
            motorFRight.setPower(-0.2);
            motorBRight.setPower(-0.2);

            motorFLeft.setPower(0.2);
            motorBLeft.setPower(0.2);

        }
        else
        {
            motorBRight.setPower(0.2);
            motorFRight.setPower(0.2);

            motorBLeft.setPower(-0.2);
            motorFLeft.setPower(-0.2);
        }
        do
        {
            if (wheels.getPose() != null)
            {
                trans = navOffWall(wheels.getPose().getTranslation(), Math.toDegrees(angles.get(-0)) - 90, new VectorF(300, 0, 0));
            }
            idle();
        } while (opModeIsActive() && Math.abs(trans.get(0)) > 30);



        motorFLeft.setPower(0);
        motorBLeft.setPower(0);

        motorFRight.setPower(0);
        motorBRight.setPower(0);



        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        motorFLeft.setTargetPosition((int) (motorFLeft.getCurrentPosition() + (Math.hypot(trans.get(-0), trans.get(2) + 200) / 319.024 * 1120)));
        motorBLeft.setTargetPosition((int) (motorBLeft.getCurrentPosition() + (Math.hypot(trans.get(-0), trans.get(2) + 200) / 319.024 * 1120)));

        motorBRight.setTargetPosition((int) (motorBRight.getCurrentPosition() + (Math.hypot(trans.get(-0), trans.get(2) + 200) / 319.024 * 1120)));
        motorFRight.setTargetPosition((int) (motorFRight.getCurrentPosition() + (Math.hypot(trans.get(-0), trans.get(2) + 200) / 319.024 * 1120)));

        motorFLeft.setPower(0.2);
        motorBLeft.setPower(0.2);

        motorFRight.setPower(0.2);
        motorBRight.setPower(0.2);

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


        while (opModeIsActive() && wheels.getPose() == null || Math.abs(wheels.getPose().getTranslation().get(-0)) > 10)
        {
            if (wheels.getPose() != null)
            {
                if (wheels.getPose().getTranslation().get(-0) > 0)
                {
                    motorFLeft.setPower(0.1);
                    motorBLeft.setPower(0.1);

                    motorFRight.setPower(-0.1);
                    motorBRight.setPower(-0.1);
                }
                else
                {
                    motorFLeft.setPower(-0.1);
                    motorBLeft.setPower(-0.1);

                    motorFRight.setPower(0.1);
                    motorBRight.setPower(0.1);
                }

            }
            else
            {
                motorFRight.setPower(-0.1);
                motorBRight.setPower(-0.1);

                motorFLeft.setPower(0.1);
                motorBLeft.setPower(0.1);

            }
        }
        //Make sure to loot at the signs of the power - I just multiplied (-) to all powers


        motorFLeft.setPower(0);
        motorBLeft.setPower(0);

        motorBRight.setPower(0);
        motorFRight.setPower(0);


        /*motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        motorBLeft.setTargetPosition(3000);
        motorBRight.setTargetPosition(3000);
        motorFLeft.setTargetPosition(3000);
        motorFRight.setTargetPosition(3000);

        motorFLeft.setPower(0.1);
        motorBLeft.setPower(0.1);

        motorBRight.setPower(0.1);
        motorFRight.setPower(0.1);
        telemetry.addData("phase", "8");*/


        /*motorFLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorBRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        motorFLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorFRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motorBRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        motorBLeft.setTargetPosition(600);
        motorBRight.setTargetPosition(-600);
        motorFLeft.setTargetPosition(600);
        motorFRight.setTargetPosition(-600);

        motorFLeft.setPower(0.1);
        motorBLeft.setPower(0.1);

        motorBRight.setPower(0.1);
        motorFRight.setPower(0.1);*/

        if (opModeIsActive())
        {
            auto.setPosition(1);



            while (color1.alpha()<2)
            {
                motorFLeft.setPower(0.1);
                motorBLeft.setPower(0.1);
                motorFRight.setPower(0.1);
                motorBRight.setPower(0.1);
            }

            while (color1.alpha()>2)
            {
                if (color1.red() > 3)
                {
                    auto.setPosition(0.8);
                }
                else if (color1.blue() > 3)
                {
                    auto.setPosition(0.2);
                }
            }




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

            motorBRight.setTargetPosition(200);
            motorBLeft.setTargetPosition(200);
            motorFLeft.setTargetPosition(200);
            motorFRight.setTargetPosition(200);

            motorFLeft.setPower(0.3);
            motorBLeft.setPower(0.3);
            motorFRight.setPower(0.3);
            motorBRight.setPower(0.3);
        }
        stop();
    }

    public VectorF navOffWall(VectorF trans, double robotAngle, VectorF offWall)
    {
        return new VectorF((float) (trans.get(-0) - offWall.get(-0) * Math.sin(Math.toRadians(robotAngle)) - offWall.get(2) * Math.cos(Math.toRadians(robotAngle))), trans.get(1), (float) (trans.get(2) + offWall.get(0) * Math.cos(Math.toRadians(robotAngle)) - offWall.get(2) * Math.sin(Math.toRadians(robotAngle))));
    }

    public VectorF anglesFromTarget(VuforiaTrackableDefaultListener image)
    {
        float [] data = image.getRawPose().getData();
        float [] [] rotation = {{data[0], data[1]}, {data[4], data[5], data[6]}, {data[8], data[9], data[10]}};
        double thetaX = Math.atan2(rotation[2][1], rotation[2][2]);
        double thetaY = Math.atan2(-rotation[2][0], Math.sqrt(rotation[2][1] * rotation[2][1] + rotation[2][2] * rotation[2][2]));
        double thetaZ = Math.atan2(rotation[1][0], rotation[0][0]);
        return new VectorF((float)thetaX, (float)thetaY, (float)thetaZ);
    }

    public void dtd(int h)
    {
        eating2.setTargetPosition(h);
        eating2.setPower(1.0);
    }

    public void shoot(int e)
    {
        shooting.setTargetPosition(e);

        shooting.setPower(0.2);
    }

    /*public void drive(int a, int b, int c, int d)
    {
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


            motorFLeft.setPower(1);
            motorBLeft.setPower(1);
            motorFRight.setPower(1);
            motorBRight.setPower(1);

    }*/

    public void beacon()
    {

        auto.setPosition(1);



        while (color1.alpha()<2)
        {
            motorFLeft.setPower(0.1);
            motorBLeft.setPower(0.1);
            motorFRight.setPower(0.1);
            motorBRight.setPower(0.1);
        }

        while (color1.alpha()>2)
        {
            if (color1.red() > 3)
            {
                auto.setPosition(0.8);
            }
            else if (color1.blue() > 3)
            {
                auto.setPosition(0.2);
            }
        }




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

