package frc.robot;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Joystick;

public class DriveMecanumClass {
    Victor fl = new Victor(0); // front left
    Victor fr = new Victor(1); // front right
    Victor bl = new Victor(2); // back left
    Victor br = new Victor(3); // back right
    MecanumDrive m_drive = new MecanumDrive(fl, fr, bl, br);
    Joystick m_stick = new Joystick(0);

    /** Fair bit of warning here,
     * Some motor controllers may need Victor.setInverted(true);
     * And some axes may need negative signs (e.g. -m_stick.getY());
     */

    public void teleopPeriodic() {
        m_drive.driveCartesian(m_stick.getX(), m_stick.getY(), m_stick.getZ());
        // Equivalent to:
        // m_drive.driveCartesian(m_stick.getRawAxis(0), m_stick.getRawAxis(1), m_stick.getRawAxis(2));
    }
}