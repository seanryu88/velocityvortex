/*
Modern Robotics Color Sensor Calibration
Created 10/3/2016 by Colton Mehlhoff of Modern Robotics using FTC SDK 2.2
Reuse permitted with credit where credit is due

Configuration:
I2CDevice "cc" (MRI Color Sensor with default I2C address 0x3c (0x1e 7-bit))
Logitech Gamepad

Follow directions on Driver Station

ModernRoboticsI2cColorSensor class is not being used because it can not access color number.
ColorSensor class is not being used because it can not access color number.

For more information, see http://modernroboticsedu.com/course/view.php?id=8
or http://modernroboticsinc.com/Content/Images/uploaded/Sensors/Sensor%20Documentation.pdf
Support is available by emailing support@modernroboticsinc.com.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Color Calibration", group="MRI")
//@Disabled
public class colorsensorcalibration extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    byte[] colorCcache;

    I2cDevice colorC;
    I2cDeviceSynch colorCreader;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        colorC = hardwareMap.i2cDevice.get("cc");
        colorCreader = new I2cDeviceSynchImpl(colorC, I2cAddr.create8bit(0x3c), false);
        colorCreader.engage();

        colorCreader.write8(3, 0);    //Set the mode of the color sensor to Active


        telemetry.addData("HELLO", "Point the color sensor into open space. Then press A");
        telemetry.update();
        while (!gamepad1.a) {

        }

        colorCreader.write8(3, 66); //Black Level Calibration
        telemetry.addData("HELLO", "Wait while Black Level Calibration");
        telemetry.update();
        colorCcache = colorCreader.read(0x04, 1);
        while (colorCcache[0] == 66) {
            colorCcache = colorCreader.read(0x04, 1);
        }

        while (gamepad1.a) {
            telemetry.addData("HELLO", "Release the A button");
            telemetry.update();
        }


        telemetry.addData("HELLO", "Point the color sensor 5cm or 2in away at a white target. Then press A");
        telemetry.update();
        while (!gamepad1.a) {

        }
        colorCreader.write8(3, 67); //Black Level Calibration
        telemetry.addData("HELLO", "Wait while White Balance Calibration");
        telemetry.update();
        colorCcache = colorCreader.read(0x04, 1);
        while (colorCcache[0] == 67) {
            colorCcache = colorCreader.read(0x04, 1);
        }

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if (gamepad1.x) {
                colorCreader.write8(3, 0);    //Set the mode of the color sensor to Active
                while (gamepad1.x) {
                }
            } else if (gamepad1.y) {
                colorCreader.write8(3, 1);    //Set the mode of the color sensor to Passive
                while (gamepad1.y) {
                }
            }

            colorCcache = colorCreader.read(0x04, 1);

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("1 C#", colorCcache[0] & 0xFF);
            telemetry.addData("2", "Press X for Active");
            telemetry.addData("3", "Press Y for Passive");
            telemetry.update();

            idle(); // Always call idle() at the bottom of your while(opModeIsActive()) loop
        }
    }
}