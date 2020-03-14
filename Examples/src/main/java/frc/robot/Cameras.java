package frc.robot;//Mandatory for all files

import edu.wpi.first.cameraserver.CameraServer;//Required for cameras

public class Cameras{

    public void camerasInit(){
        CameraServer.getInstance().startAutomaticCapture("Front", 0);//0,1 refer to usb ports on usb. Camera is now accessible in driverstation
        CameraServer.getInstance().startAutomaticCapture("Back", 1);//String is whatever the name is, change to whatever you want
    }
}