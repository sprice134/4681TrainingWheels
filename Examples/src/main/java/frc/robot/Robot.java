/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;//Required always

import edu.wpi.first.wpilibj.TimedRobot;//Required always
import edu.wpi.first.wpilibj.Joystick;//Used for remotes
import edu.wpi.first.wpilibj.Victor;//Used for regular motors
import edu.wpi.first.wpilibj.drive.DifferentialDrive; //Style of driving, not required to use this one
import edu.wpi.first.wpilibj.Counter;// Required for a Lidar Sensor
import edu.wpi.first.cameraserver.CameraServer;//Required for cameras
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;//Creates smartdashboard, Smartdashboard is not required however
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;//Used to have different auto strategies and picking at driver station
//Uncomment the two underneath, they require CTRE Pheonix which does not run on a mac
//import com.ctre.phoenix.motorcontrol.ControlMode;//Required for talons, also needs vendor download
//import com.ctre.phoenix.motorcontrol.can.TalonSRX; 
import edu.wpi.first.wpilibj.DigitalInput;//Used for switches and other sensors
import edu.wpi.first.networktables.*;//How the limelight interacts with the roborio
import edu.wpi.first.wpilibj.SpeedControllerGroup;//Controls multiple motors in tandem
import edu.wpi.first.wpilibj.Compressor;//required if there are pneumatics on the robot



public class Robot extends TimedRobot {
  //Always create variables here, that way they are globally accessible in both Auto and tele
  private Joystick m_stick;//Remote
  private VictorMotorClass m_shooter;//Refers to the class i made, not the motor. Usually would be named shooters, wheels, etc
  private Victor m_leftWheel;//Refers to motors now, not class
  private Victor m_rightWheel;
  private DifferentialDrive m_drive;//Will be used for all driving methods
  private ServoMotorClass m_servo;

  
  
  
  @Override
  public void robotInit() {
    //Declare each here with port number on roborio
    m_stick = new Joystick(0);//port #, can be seen in driver station
    CameraServer.getInstance().startAutomaticCapture("Front", 0);//0,1 refer to usb ports on usb. Camera is now accessible in driverstation
    CameraServer.getInstance().startAutomaticCapture("Back", 1);
    m_leftWheel = new Victor(2);//Declare each motor seperately similar to speed controller
    m_rightWheel = new Victor(3);
    m_drive = new DifferentialDrive(m_leftWheel, m_rightWheel);//Combines wheels into one object
    m_shooter = new VictorMotorClass();//Declare it here
    m_shooter.victorsInit();//Always run the init for EVERY object you create
    m_servo = new ServoMotorClass();
    m_servo.servoMotorInit();//Always run the init for EVERY object you create
  }


  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }


  @Override
  public void teleopInit() {
  //Called once, when teleop starts, in the lab when you first turn on with new code, in the comp, when it switches from auto
  //This is specifically used for anything you want to reset or make sure after teleop
  //For example, if you are using timers, it could be helpful to reset the timer here
  }

  @Override
  public void teleopPeriodic() {
    //All code for teleop will be run through this method, including calling other classes and mehtods
    //This code is called every .02 seconds. So 50 cycles every second
    
    
    //Method 1 of driving
    //if only 2 doubles with no boolean, both values will be squared so .5 is actually .25   gives an acceleration curve
    //The first in arcade drive is translational power, the second is rotational power
    m_drive.arcadeDrive(m_stick.getRawAxis(0), m_stick.getRawAxis(1));//getRawAxis is the joysticks on a remote
    
    
    
    //Method 2 of driving
    //if false after values, the values will not be squared neither is better than other, just depends on circumstance
    //The first in arcade drive is translational power, the second is rotational power
    m_drive.arcadeDrive(m_stick.getRawAxis(0), m_stick.getRawAxis(1), false);//getRawAxis is the joysticks on a remote
    
    
    if (m_stick.getRawButtonPressed(1)){//getRawButtonPressed is true only once, when the button is first pressed
      m_shooter.setFullPower();
    }


    if (m_stick.getRawButton(2)){//getRawButton is true whenever the button is pressed, regardless of how long it has been pressed
      m_shooter.killMotor();
    }


    if (m_stick.getRawButton(1) && m_stick.getRawButtonReleased(2)){//buttonReleased is only true when the button is pressed and then released, no other time
      System.out.println(m_shooter.getSpeed());
    }



    if (m_stick.getRawButton(3)){
      m_servo.halfTurn();
    }
    else{
      m_servo.reset();
      System.out.println(m_servo.getTurn());
    }



  }
}
