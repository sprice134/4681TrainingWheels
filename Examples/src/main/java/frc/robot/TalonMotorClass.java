package frc.robot;//Mandatory for all files


import com.ctre.phoenix.motorcontrol.ControlMode;//Required for talons, also needs vendor download into vendorReps folder
import com.ctre.phoenix.motorcontrol.can.TalonSRX; 

public class TalonMotorClass{
    private TalonSRX m_motor;//always declare globally outside of init

    public void talonMotorClassInit(){
        //Use Pheonix Tuner to figure out and change which locations on canBus series each motor is plugged into 
        m_motor = new TalonSRX(10);//10 is referring to port on canBus, roborio is port 0, everything after that is incramentally 10 larger
        m_motor.setSelectedSensorPosition(0);//Sets encoder value to 0 wherever the motor starts when the robot turns on
        //The line above is not necceary in all instances but recommended
    }

    public int getEncoderPosition(){
        return m_motor.getSelectedSensorPosition();//Returns value of encoder. Use pheonix tuner to determin range of encoder
        //based on revolutions so if say a climber revolves 500 times its encoder rance will be significantly larger than something that turns 5 times
    }
    public void setSpeed(double speed) { // speed E[-1.0, 1.0]
        m_motor.set(ControlMode.PercentOutput, speed);//PercentOutput is just like how you would use a victor, you just have to say it like this
    }
    public void resetEncoder(){
        m_motor.setSelectedSensorPosition(0);//Sets encoder value to 0 wherever the motor starts whenever called
    }
    public void goToEncoderPoint(int target){
        //Would recommend a PID loop here but a simple way of doing it woudl be 
        if (Math.abs(m_motor.getSelectedSensorPosition() - target) < 2000)//If there are less than 2000 increaments between target and current, stop
            //2000 is entirely arbitrary, find out what works for you
            m_motor.set(ControlMode.PercentOutput, 0);//Stops the motor
        else if (m_motor.getSelectedSensorPosition() > target)//If outside of stopping range, and shorter than target, turn on
            m_motor.set(ControlMode.PercentOutput, .5);
        else if (m_motor.getSelectedSensorPosition() < target)///If outside of stopping range, and farther than target, turn on and go backwards
            m_motor.set(ControlMode.PercentOutput, -.5);
        else 
            m_motor.set(ControlMode.PercentOutput, 0);//If not reading encoder or target not inputted correctly, turns off, Just a safegaurd
    }
}