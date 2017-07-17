package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by seanryu on 26/12/2016.
 */
@TeleOp(name = "Jinseo")
public class Jinseo extends OpMode
{
    TouchSensor touch1;
    DcMotor motor1;
    boolean touched = true;
    @Override
    public void init()
    {
        telemetry.addData("status", "initialized");
        touch1 = hardwareMap.touchSensor.get("touch1");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    @Override
    public void init_loop()
    {
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    @Override
    public void start()
    {
        telemetry.addData("status", "started");
    }
    @Override
    public void loop()
    {
        while (touch1.isPressed())
        {
            motor1.setPower(0.1);
        }
        if (!touch1.isPressed())
        {
            stop();
        }
    }
    @Override
    public void stop()
    {
    }
}
