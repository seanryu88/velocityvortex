package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by seanryu on 21/03/2017.
 */
@Autonomous(name = "intservo", group = "teamcode")
public class intservo extends OpMode
{
    Servo ayo;
    TouchSensor touch1;
    boolean a =true;

    int n = 1;


    public void intservo() {}

    @Override
    public void init()
    {
        touch1=hardwareMap.touchSensor.get("touch1");
        ayo=hardwareMap.servo.get("ayo");
        ayo.setPosition(1);

    }
    public void loop()
    {


        if (touch1.isPressed()) //suspect 3
        {
            n = -n;
        }



        if (n == 1)
        {
            ayo.setPosition(-0.5);
        }
        if (n == -1)//suspect 2
        {
            ayo.setPosition(0.5);
        }

        return;

    }
    public void stop()
    {}
}
