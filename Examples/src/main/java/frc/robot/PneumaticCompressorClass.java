package frc.robot;//Mandatory for all

import edu.wpi.first.wpilibj.Compressor;//required if there are pneumatics on the robot

//QUICK NOTE: As this is really really simple, I would keep it in just the robot class
//This is only getting its on class for the sake of consistency and organization
public class PneumaticCompressorClass{
    private Compressor m_compressor;

    public void compressorClassInit(){
        m_compressor.start();//Technically, this is a toggle 
        //However, if the compressor is full, it will automatically turn itself off
        //So, what I recommend is start the compressor at the beginning of the match and it will oscilate between on and off as needed
        //If you only need pnuematics for the main part of the match, but not climbing for exmaple you could turn it off then
    }
    public void compressorOn(){//If for some reason you wanted to specifically toggle it
        m_compressor.start();
    }
    public void compressorOff(){
        m_compressor.stop();//turns the compressor off
    }
}
