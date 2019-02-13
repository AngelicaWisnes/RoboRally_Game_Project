package inf112.skeleton.app;

import inf112.skeleton.app.Enums.Direction;

public interface iRobot {

    /**
     *
     * @param direction
     * @return
     */
    Direction rotate(Direction direction);
    Position move(Direction direction, int spaces);
}
