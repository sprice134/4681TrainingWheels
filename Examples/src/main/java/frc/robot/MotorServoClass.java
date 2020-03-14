package frc.robot;//Mandatory for all files

import edu.wpi.first.wpilibj.Servo;//only import needed

public class MotorServoClass{
    private Servo m_servo;
    

    public void servoMotorInit(){
        //Don't plug into roborio, not enough power
        //Use a Servo Power Module (only legal way)
        m_servo = new Servo(0); //0 refers to port on servo power module
        m_servo.setAngle(0); //Makes sure whatever angle the servo starts at is 0

    }
    public void halfTurn(){
        m_servo.setAngle(90);//Most servos have a range of 180 degrees, 90 will give you half turn
    }
    public void reset(){
        m_servo.setAngle(0);//Brings back to base
    }
    public double getTurn(){

        return m_servo.get();//Returns servo from 0 to 1. Essentially % moved
        //useful if you dont want to do something until servo is turned
        //IMPORTANT: m_servo.getAngle() gives you what angle it is set to, not actually what angle it is 
    }

}