package org.firstinspires.ftc.teamcode;

/*
Modern Robotics Color Sensors Example with color number
Created 9/29/2016 by Colton Mehlhoff of Modern Robotics using FTC SDK 2.2
Reuse permitted with credit where credit is due

Configuration:
I2CDevice "ca" (MRI Color Sensor with I2C address 0x3a (0x1d 7-bit)
I2CDevice "cc" (MRI Color Sensor with default I2C address 0x3c (0x1e 7-bit)

ModernRoboticsI2cColorSensor class is not being used because it can not access color number.
ColorSensor class is not being used because it can not access color number.

To change color sensor I2C Addresses, go to http://modernroboticsedu.com/mod/lesson/view.php?id=96
Support is available by emailing support@modernroboticsinc.com.
*/

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcontroller.internal.testcode.TestColorSensors;


//@TeleOp(name = "Color Sensors", group = "MRI")
// @Autonomous(...) is the other common choice
//@Disabled
public class SensorMRColor extends OpMode {

  /* Declare OpMode members. */
  private ElapsedTime runtime = new ElapsedTime();

  byte[] colorAcache;
  byte[] colorCcache;

  I2cDevice colorA;
  I2cDevice colorC;
  I2cDeviceSynch colorAreader;
  I2cDeviceSynch colorCreader;

  TouchSensor touch;         //Instance of TouchSensor - for changing color sensor mode

  boolean touchState = false;  //Tracks the last known state of the touch sensor
  boolean LEDState = true;     //Tracks the mode of the color sensor; Active = true, Passive = false

  /*
   * Code to run ONCE when the driver hits INIT
   */
  @Override
  public void init() {
    telemetry.addData("Status", "Initialized");

    //the below lines set up the configuration file
    colorA = hardwareMap.i2cDevice.get("ca");
    colorC = hardwareMap.i2cDevice.get("cc");

    colorAreader = new I2cDeviceSynchImpl(colorA, new I2cAddr(0x1d), false);
    colorCreader = new I2cDeviceSynchImpl(colorC, new I2cAddr(0x1e), false);

    colorAreader.engage();
    colorCreader.engage();

    touch = hardwareMap.touchSensor.get("t");
  }

  /*
   * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
   */
  @Override
  public void init_loop() {
  }

  /*
   * Code to run ONCE when the driver hits PLAY
   */
  @Override
  public void start() {
    runtime.reset();

    if(LEDState){
      colorAreader.write8(3, 0);    //Set the mode of the color sensor using LEDState
      colorCreader.write8(3, 0);    //Set the mode of the color sensor using LEDState
    }
    else{
      colorAreader.write8(3, 1);    //Set the mode of the color sensor using LEDState
      colorCreader.write8(3, 1);    //Set the mode of the color sensor using LEDState
    }
    //Active - For measuring reflected light. Cancels out ambient light
    //Passive - For measuring ambient light, eg. the FTC Color Beacon
  }

  /*
   * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
   */
  @Override
  public void loop() {
    telemetry.addData("Status", "Running: " + runtime.toString());

    //The below two if() statements ensure that the mode of the color sensor is changed only once each time the touch sensor is pressed.
    //The mode of the color sensor is saved to the sensor's long term memory. Just like flash drives, the long term memory has a life time in the 10s or 100s of thousands of cycles.
    //This seems like a lot but if your program wrote to the long term memory every time though the main loop, it would shorten the life of your sensor.

    if (!touchState && touch.isPressed()) {  //If the touch sensor is just now being pressed (was not pressed last time through the loop but now is)
      touchState = true;                   //Change touch state to true because the touch sensor is now pressed
      LEDState = !LEDState;                //Change the LEDState to the opposite of what it was
      if(LEDState){
        colorAreader.write8(3, 0);    //Set the mode of the color sensor using LEDState
        colorCreader.write8(3, 0);    //Set the mode of the color sensor using LEDState
      }
      else{
        colorAreader.write8(3, 1);    //Set the mode of the color sensor using LEDState
        colorCreader.write8(3, 1);    //Set the mode of the color sensor using LEDState
      }

    }
    if (!touch.isPressed()) {                //If the touch sensor is now pressed
      touchState = false;                  //Set the touchState to false to indicate that the touch sensor was released
    }

    colorAcache = colorAreader.read(0x04, 1);
    colorCcache = colorCreader.read(0x04, 1);

    //display values
    telemetry.addData("1 #A", colorAcache[0] & 0xFF);
    telemetry.addData("2 #C", colorCcache[0] & 0xFF);
  }

  /*
   * Code to run ONCE after the driver hits STOP
   */
  @Override
  public void stop() {
  }

}