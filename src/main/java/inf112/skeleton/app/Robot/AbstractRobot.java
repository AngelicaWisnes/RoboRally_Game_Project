package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Position;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobot implements iRobot {
    private Position pos;
    private Direction dir;

    protected AbstractRobot(Position pos, Direction dir) {
        this.pos = pos;
        this.dir = dir;
    }

    @Override
    public Direction rotate(Rotation rotation) {
        switch (rotation) {
            case TURN_CLOCKWISE: return dir = dir.clockwise();
            case TURN_COUNTER_CLOCKWISE: return dir = dir.counterClockwise();
            case TURN_AROUND: return dir = dir.opposite();
            default:
                throw new IllegalArgumentException("Must have valid rotation-input to rotate robot");
        }
    }

    @Override
    public Position move(Direction direction, int spaces) {
        if (spaces < 1 || spaces > 3){
            throw new IllegalArgumentException("Must have valid spaces-input to move robot");
        }

        switch (direction) {
            case UP:
                pos.y -= spaces;
                return pos;
            case DOWN:
                pos.y += spaces;
                return pos;
            case LEFT:
                pos.x -= spaces;
                return pos;
            case RIGHT:
                pos.x += spaces;
                return pos;
            default:
                throw new IllegalArgumentException("Must have valid direction-input to move robot");
        }
    }
}
