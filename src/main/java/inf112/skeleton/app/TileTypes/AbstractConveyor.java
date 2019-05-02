package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;

public abstract class AbstractConveyor implements ITile {

    Direction direction;

    public AbstractConveyor(Direction direction) {
        this.direction = direction;
    }

    /**
     * @return the direction of the conveyor
     */
    public Direction getDirection() {
        return direction;
    }

}