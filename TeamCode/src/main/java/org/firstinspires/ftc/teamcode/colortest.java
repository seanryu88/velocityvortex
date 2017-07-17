package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by seanryu on 22/12/2016.
 */
public class colortest extends LinearOpMode {
    ColorSensor color1;

    public void runOpMode() throws InterruptedException {
        color1 = hardwareMap.colorSensor.get("color1");

        waitForStart();

        while (opModeIsActive()) {
            while (true)
            {
                telemetry.addData("red", color1.red());
                telemetry.addData("blue", color1.blue());
                telemetry.addData("alpha", color1.alpha());
            }
        }
    }
}

