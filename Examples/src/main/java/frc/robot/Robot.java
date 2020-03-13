/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;//Required always

import edu.wpi.first.wpilibj.TimedRobot;//Required always
import edu.wpi.first.wpilibj.Joystick;//Used for remotes
import edu.wpi.first.wpilibj.PWMVictorSPX;//Used for regular motors
import edu.wpi.first.wpilibj.drive.DifferentialDrive; //Style of driving, not required to use this one
import edu.wpi.first.wpilibj.Counter;// Required for a Lidar Sensor
import edu.wpi.first.cameraserver.CameraServer;//Required for cameras
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;//Creates smartdashboard, Smartdashboard is not required however
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;//Used to have different auto strategies and picking at driver station
import edu.wpi.first.wpilibj.Servo;//Used for servo motors
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
  @Override
  public void robotInit() {
  //Declare each here with port number on roborio
  m_stick = new Joystick(0);//port #, can be seen in driver station
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
  }
}
