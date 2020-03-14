package frc.robot;//Mandatory line of code

import edu.wpi.first.wpilibj.Counter;// Required for a Lidar Sensor

//IMPORTANT NOTE: Lidar is accurate within an inch or two on average from wherever it is pointing at,
//HOWEVER, You will experience much better results if you were to take the distance every half second and average
//This average distance would be better at eliminating the standard deviation of periods
//In addition, remember the laser beam is a straight line, so if the lidar isn't level, neither will the laser, and then your distance will be asked
//Also, do not put a method of drive until getDistance() < 50, etc because if a robot drives in front, then your distance and massively skewed



public class LidarClass{
    private Counter lidar;//Counter is what the lidar system is called in the WPI Library

    public void lidarClassInit(){
        lidar = new Counter();
        lidar.setMaxPeriod(1.0);//Dont fully understant these three lines,  
        lidar.setSemiPeriodMode(true);//They are neccesary however
        lidar.reset();//If you would like to spend time researching it, go ahead
    }

    public double getDistance() {//Returns distance from front of the robot to wall
        return (lidar.getPeriod() * 100000 / 2.54);//Period of laser with conversions to be in inches
        // getPeriod returns cm / µs, then --> sec --> in
    }
}