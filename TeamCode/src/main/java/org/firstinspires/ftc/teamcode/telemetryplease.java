package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Gamepad;
import java.util.Timer;
import java.util.TimerTask;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by JeremyChang on 1/15/17.
 */
public class telemetryplease extends OpMode {

    DcMotor motorFRight;
    DcMotor motorFLeft;
    DcMotor motorBRight;
    DcMotor motorBLeft;
    DcMotor eating;
    DcMotor eating2;
    DcMotor shooting;
    DcMotor rail;
    Servo auto;
    Servo clunk;

    public telemetryplease () {}

    @Override
    public void init () {
        motorFRight = hardwareMap.dcMotor.get("motor_2");
        motorFLeft = hardwareMap.dcMotor.get("motor_1");
        motorBRight = hardwareMap.dcMotor.get("motor_4");
        motorBLeft = hardwareMap.dcMotor.get("motor_3");
        eating = hardwareMap.dcMotor.get("eating");
        eating2 = hardwareMap.dcMotor.get("eating2");
        shooting = hardwareMap.dcMotor.get("shooting");
        rail = hardwareMap.dcMotor.get("rail");
        auto = hardwareMap.servo.get("auto");
        clunk = hardwareMap.servo.get("clunk");


        motorFRight.setDirection(DcMotor.Direction.REVERSE);
        motorBRight.setDirection(DcMotor.Direction.REVERSE);



        //Timer timer = new Timer();

        //timer.schedule(new WorkTask(), 5000,3000);

    }

    @Override
    public void loop () {

        shoot();
        telemetry.addData("encoder",shooting.getCurrentPosition());




    }

    public void shoot() {
        if(gamepad1.a) {
            shooting.setPower(0.5);
        }
        else {
            shooting.setPower(0.0);
            shooting.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }
    }

}