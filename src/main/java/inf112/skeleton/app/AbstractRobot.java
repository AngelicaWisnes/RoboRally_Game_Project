package inf112.skeleton.app;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;

public abstract class AbstractRobot implements iRobot {
    protected Position pos;
    private Direction dir;

    protected AbstractRobot() {

    }

    @Override
    public Direction rotate(Rotation rotation) {
        if (rotation.equals(Rotation.TURN_AROUND)) return dir = dir.opposite();
        if (rotation.equals(Rotation.TURN_CLOCKWISE)) return dir = dir.clockwise();
        if (rotation.equals(Rotation.TURN_COUNTER_CLOCKWISE)) return dir = dir.counterClockwise();
        throw new IllegalArgumentException("Must have valid rotation-input to rotate robot");
    }

    @Override
    public Position move(Direction direction, int spaces) {
        return null;
    }
}
