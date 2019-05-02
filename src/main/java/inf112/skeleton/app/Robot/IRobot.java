package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Helpers.Position;

public interface IRobot {

    /**
     * Get the current position of the robot
     *
     * @return the position
     */
    Position getPos();

    /**
     * Get current facing direction og the robot
     *
     * @return the direction
     */
    Direction getDir();

    /**
     * Check if a tile should have impact on the robot If so, executes those actions.
     */
    void tileRobotImpact(RoundState roundState);

    /**
     * A method that allows user to move robot with keyboard, useful for testing manually
     */
    void keyboardMovesRobot();

    /**
     * Move the robot by using game cards
     * @param card the card to use
     */
    void cardMovesRobot(AbstractCard card);

    /**
     * Helper-method for testing rotate-method
     *
     * @param rotation the direction to turn
     */
    Direction testRotation(Rotation rotation);

    /**
     * A method to execute all actions when i robot dies
     *
     * @return new position of the robot. This is the last registered checkpoint
     */
    Position killRobot();

    /**
     * If this robot should be pushed, this method can call the private move-method
     * @param dir    the direction you get pushed
     * @param spaces how many spaces you get pushed
     * @return the new position
     */
    Position push(Direction dir, int spaces);
}
