package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Helpers.Position;

public interface IRobot {

    /**
     * Get the position of the robot
     * @return the position
     */
    Position getPos();

    /**
     * This is a temporary method for moving the robot with the help of arrow-keys from keyboard.
     */
    void moveRobotByKeyboard();
    void cardMovesRobot(AbstractCard card);
}
