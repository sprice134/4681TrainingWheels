package frc.robot;//Mandatory for all files

import edu.wpi.first.cameraserver.CameraServer;//Required for cameras

public class SensorCameraClass{
    //There are more methods you can do with cameras but at the level this team is at, I do not recommend it
    //Run the startAutomaticCapture method and that is all you will need for the entire match
    //once that method is called, live camera feed will be accessible by both the driver station and smart dashboard
    public void camerasClassInit(){
        CameraServer.getInstance().startAutomaticCapture("Front", 0);//0,1 refer to usb ports on usb. Camera is now accessible in driverstation
        CameraServer.getInstance().startAutomaticCapture("Back", 1);//String is whatever the name is, change to whatever you want
    }
}