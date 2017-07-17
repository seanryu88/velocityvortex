package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by seanryu on 17/03/2017.
 */

public class servoclass extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {
        DcMotor motor1;
        DcMotor motor2;

        motor1=hardwareMap.dcMotor.get("motor1");
        motor2=hardwareMap.dcMotor.get("motor1");

        motor1.setPower(0.5);
        motor2.setPower(-.5);

        telemetry.addData("heehee", "ecsdee");
    }
}
