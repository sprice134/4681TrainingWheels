/** Very similar to programming game data...
 */

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; // to display variables
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser; // to display autonomous options

// SmartDashboard is a static class, which allows you to call methods
//  by the class name, without creating a variable. You'll eventually learn.

public class ProgrammingSmartDashboard {
    SendableChooser<String> m_chooser = new SendableChooser<>();
    int speed = 0;
    String autoChoice;

    public void robotInit() {
        m_chooser.setDefaultOption("text to display","what the code uses");
        m_chooser.addOption("Move Forward", "fd");
        m_chooser.addOption("Move Sideways", "side");
        SmartDashboard.putData(m_chooser);
    }

    public void autonomousInit() {
        autoChoice = m_chooser.getSelected();
    }

    public void autonomousPeriodic() {
        switch (autoChoice) {
            case "fd":
                /* code to move forward */
                break; // ALWAYS REMEMBER TO BREAK A SWITCH STATEMENT CASE
            case "side":
                /* code to move sideways */
                break;
            case "what the code uses": // You can stack cases in switch statements. That's why break; is important.
            default: // Have a default autonomous, just in case.
                /* default autonomous code */
        }
    }

    public void teleopPeriodic() {
        
    }
}