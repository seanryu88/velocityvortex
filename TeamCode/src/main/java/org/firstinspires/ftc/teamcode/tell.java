package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by seanryu on 03/01/2017.
 */
@TeleOp(name = "tell")
public class tell extends OpMode
{
    DcMotor motor1;
    DcMotor motor2;
@Override
    public void init()
    {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
    }
    @Override
    public void init_loop()
    {
        telemetry.addData("Hello World", "Hello World");

    }
    @Override
    public void start()
    {
        telemetry.addData("Young", "Beautiful");
    }
    @Override
    public void loop()
    {
        motor1.setPower(1);
        motor2.setPower(1);
    }
    @Override
    public void stop()
    {
     telemetry.addData("shit", "fuck");
    }

}
