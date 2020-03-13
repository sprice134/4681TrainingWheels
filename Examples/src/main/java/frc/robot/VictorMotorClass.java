package frc.robot;//Required for all

import edu.wpi.first.wpilibj.SpeedControllerGroup;//required for combining 2 motors, *Motors do not have to combined*
import edu.wpi.first.wpilibj.Victor;//Required for all victor motors

public class VictorMotorClass{
    private Victor m_shooterLeft;//Declare each motor individually
    private Victor m_shooterRight;
    private SpeedControllerGroup m_shooter;//Then declare an object for both

    public void victorsInit(){//Call this method after initializing the object
        m_shooterLeft = new Victor(0);//0 = PWM port number on robot
        m_shooterRight = new Victor(1);
        m_shooter = new SpeedControllerGroup(m_shooterLeft, m_shooterRight);//All methods will now be used with this object
        m_shooter.setInverted(true);//call if the motor is on backwards, sometimes happens
    }
    public void setFullPower(){
        m_shooter.set(1);//Range from -1 to 1, which eqauls 100% power backwards to 100% power forwards
    }
    public void killMotor(){
        m_shooter.set(0);//0 power = no energy = stopped motor
    }
    public double getSpeed(){
        return m_shooter.get();//Returns current set speed, not usually useful
    }



}