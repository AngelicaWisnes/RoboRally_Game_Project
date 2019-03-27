package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;

public abstract class AbstractWall extends AbstractTile {

    Direction direction;

    public AbstractWall(Direction direction) {
        this.direction = direction;

    }

    /**
     * @return the direction of the conveyor
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return the image string of the conveyor
     */
    @Override
    public String getImage() {
        return image;
    }
}