package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "welcome", group = "teamcode")
public class welcome extends OpMode
{
    DcMotor motor1;
    DcMotor motor2;

    @Override
    public void init()
    {
        motor1=hardwareMap.dcMotor.get("motor1");
        motor2=hardwareMap.dcMotor.get("motor2");
    }

    @Override
    public void loop()
    {
        motor1.setPower(1.0);
        motor2.setPower(-1.0);
    }
}
