package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Position;

public interface iRobot {

    /**
     * Rotate the robot
     * @param rotation the rotation-Enum describing how turning-direction
     * @return the new direction
     */
    Direction rotate(Rotation rotation);

    /**
     * Move the robot in the given direction
     * @param direction given from Program-card or Game-board
     * @param spaces number of spaces to move
     * @return the new position
     */
    Position move(Direction direction, int spaces);
}
