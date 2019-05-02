package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
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

    /**
     * Moving the robot by using keyboard
     */
    void keyboardMovesRobot();

    /**
     *
     * @param card moving the robot by using game cards
     */
    void cardMovesRobot(AbstractCard card);

    /**
     * Helper-method for testing rotate-method
     * @param rotation the direction to turn
     */
    Direction testRotation(Rotation rotation);

    /**
     * makes the gamer die
     * @return die state of the robot
     */
    Position killRobot();

    /**
     *
     * @param dir the direction you get pushed
     * @param spaces how many spaces you get pushed
     * @return
     */
    Position push(Direction dir, int spaces);
}
