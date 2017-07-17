package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegistrar;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.jar.Attributes;

/**
 * Created by seanryu on 22/12/2016.
 */
@TeleOp(name = "colorpractice")
public class colorpractice extends OpMode
{
    ColorSensor color1;
    Servo hi;
    @Override
    public void init()
    {
        telemetry.addData("Status", "Initialized");
        color1 = hardwareMap.colorSensor.get("color1");
        hi = hardwareMap.servo.get("hi");
    }

    @Override
    public void init_loop()
    {
        hi.setPosition(0.5);
    }

    @Override
    public void start()
    {
        color1.enableLed(false);
    }
    @Override
    public void loop()
    {
        telemetry.addData("red", color1.red());
        telemetry.addData("blue", color1.blue());
        telemetry.addData("alpha", color1.alpha());
            if (color1.red() > 3)
            {
                hi.setPosition(0);
            }
            else if (color1.blue() > 3)
            {
                hi.setPosition(1);
            }
        }

    @Override
    public void stop()
    {
        telemetry.addData("stopped", "stopped");
    }
}

