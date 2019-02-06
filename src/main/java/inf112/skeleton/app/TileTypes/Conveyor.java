package inf112.skeleton.app.TileTypes;

/**
 *
 * @Author Katarina
 *
 */
enum Direction{
    UP, DOWN, LEFT, RIGHT
}

public class Conveyor extends Tile {
    Direction direction;

    public Conveyor(Direction direction) {
        this.image = "conveyor";
        this.direction = direction;

    }

    @Override
    public String getImage() {
        if (direction == Direction.UP){
            return image + "_up";
        } else if (direction == Direction.DOWN){
            return image + "_down";
        } else if (direction == Direction.RIGHT){
            return image + "_left";
        } else if (direction == Direction.LEFT){
            return image + "_right";
        }

    }
}
