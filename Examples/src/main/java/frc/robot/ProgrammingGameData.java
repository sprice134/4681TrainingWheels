/** This will vary from year to year.
 * In 2018, the game data sent was a length three String, e.g. "RBR"
 * In 2020, the game data sent was a String of a color, e.g. "Yellow"
 * When game data is available to be utilized, read up here!
 */

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class ProgrammingGameData {
    String gameData = "";

    public void teleopPeriodic() {
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        // If no data is available, an empty string "" is returned.
        // Otherwise, something like this is possible:
        switch (gameData) {
            case "Data 1":
                /* code */
                break; // ALWAYS REMEMBER TO BREAK A SWITCH STATEMENT
            case "Data 2":
                /* code */
                break;
            default: // Not always necessary to have a default, but e.g. if the data is corrupted/empty
                /* code */
                break;
        }
        // You can see our 2018 code for how Andrew manipulated the 2018 game data
        //  for autonomous. It's very tricky to get through so give yourself time.
    }
}