package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Helpers.Position;

public interface IRobot {

    /**
     * Get the position of the robot
     *
     * @return the position
     */
    Position getPos();

    Direction getDir();

    /**
     * This is a temporary method for moving the robot with the help of arrow-keys from keyboard.
     */
    void tileRobotImpact(RoundState roundState);

    void keyboardMovesRobot();

    void cardMovesRobot(AbstractCard card);
}
