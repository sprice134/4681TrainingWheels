package frc.robot;//Mandatory for all

import edu.wpi.first.wpilibj.Solenoid;//Required library


public class PnuematicSolenoidClass{
    //Solonoids can be used for anything with compressed air
    //In years passed we have used them for extending arms, climbing mechanisms and vacuums
    //All of them essentially use the same principle, they are either on or off
    //The mechanism will handle its task whether it be suck, extend, etc
    //NOTE: Pnuematics do not get plugged into the roborio directly. They get plugged into the pneumatics control module
    private Solenoid m_arm;

    public void solenoidClassInit(){
        m_arm = new Solenoid(0);//0 refers to the position on the PCM
    }
    //Since the pnuematic system is either all the way on or all the way off,
    //Programming is relatively simple. all it takes is a boolean 
    public void extend(){
        m_arm.set(true);
    }
    public void retract(){
        m_arm.set(false);
    }

}