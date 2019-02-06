package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Direction;

/**
 * @Author Magne
 */

public class DblConveyor extends Tile {

    Direction direction;

    public DblConveyor(Direction direction) {
        this.image = "dbl_conveyor";
        this.direction = direction;
    }

    @Override
    public String getImage() {
        if (direction == Direction.UP) {
            return image + "_up";
        } else if (direction == Direction.DOWN) {
            return image + "_down";
        } else if (direction == Direction.RIGHT) {
            return image + "_left";
        } else if (direction == Direction.LEFT) {
            return image + "_right";
        } else {
            return "";
        }
    }
}
