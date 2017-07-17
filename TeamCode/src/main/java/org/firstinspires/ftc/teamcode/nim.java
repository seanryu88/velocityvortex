package org.firstinspires.ftc.teamcode;

/**
 * Created by seanryu on 18/01/2017.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class nim extends LinearOpMode {
    DcMotor im;

    public nim () {}

    public void runOpMode() throws InterruptedException {
        im = hardwareMap.dcMotor.get("im");
        im.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        this.sleep(2000);


        im.setTargetPosition(1440);
        im.setPower(0.8);


        //ahah(4000);
    }


    public void ahah(int h)
    {

        im.setTargetPosition(h);

        im.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        im.setPower(0.8);


    }

}
