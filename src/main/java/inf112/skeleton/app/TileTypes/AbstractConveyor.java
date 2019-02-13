package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Direction;

public abstract class AbstractConveyor extends AbstractTile {

    Direction direction;
    String image;

    public AbstractConveyor(Direction direction, String type) {
        this.direction = direction;
        setImage(type);

    }

    public void setImage(String type) {
        if (direction == Direction.UP) {
            image = type + "_up";
        } else if (direction == Direction.DOWN) {
            image = type + "_down";
        } else if (direction == Direction.RIGHT) {
            image = type + "_left";
        } else if (direction == Direction.LEFT) {
            image = type + "_right";
        } else throw new IllegalArgumentException("Illegal direction argument!");
    }


    @Override
    public String getImage() {
        return this.image;
    }
}