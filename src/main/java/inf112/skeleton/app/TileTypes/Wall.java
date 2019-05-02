package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;

public class Wall extends AbstractWall {
    Direction dir;

    public Wall(Direction dir) {
        super(dir);
    }
}
