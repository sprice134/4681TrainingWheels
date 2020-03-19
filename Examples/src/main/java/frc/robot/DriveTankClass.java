package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Joystick;

public class DriveTankClass {
    Victor l = new Victor(0);
    Victor r = new Victor(1);
    DifferentialDrive m_drive = new DifferentialDrive(l, r);
    Joystick m_stick = new Joystick(0);

    /** Fair bit of warning here,
     * Some motor controllers may need Victor.setInverted(true);
     * And some axes may need negative signs (e.g. -m_stick.getY());
     */

    public void teleopPeriodic() {
        m_drive.tankDrive(m_stick.getRawAxis(1), m_stick.getRawAxis(3));
        // The dual stick controller has the y-axis inverted, so be prepared.
        // One axis controls one side of the robot, as opposed to arcadeDrive
        //  where one axis controls both fd/back and turning.
    }
}