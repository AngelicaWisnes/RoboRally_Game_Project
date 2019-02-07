package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Direction;

<<<<<<< HEAD
/**
 * @Author Katarina
 */
=======
public abstract class Conveyor extends Tile {
>>>>>>> 2f55081a586cbcf898190bff20a0e09ea9339afe

    Direction direction;
    String image;

<<<<<<< HEAD
    public Conveyor(Direction direction) {
        image = "conveyor";
=======
    public Conveyor(Direction direction, String type) {
>>>>>>> 2f55081a586cbcf898190bff20a0e09ea9339afe
        this.direction = direction;
        setImage(type);

    }

<<<<<<< HEAD
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
=======
    public void setImage(String type) {
        if (direction == Direction.UP) {
            image = type + "_up";
        } else if (direction == Direction.DOWN) {
            image = type + "_down";
        } else if (direction == Direction.RIGHT) {
            image = type + "_left";
        } else if (direction == Direction.LEFT) {
            image = type + "_right";
>>>>>>> 2f55081a586cbcf898190bff20a0e09ea9339afe
        } else {
            image = "";
        }
    }


    @Override
    public String getImage() {
        return this.image;
    }
}