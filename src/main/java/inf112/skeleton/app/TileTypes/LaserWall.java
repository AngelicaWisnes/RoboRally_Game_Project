package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;

public class LaserWall extends AbstractWall {
    Direction dir;

    public LaserWall(Direction dir) {
        super(dir);
        this.image = "laserwall";
    }

    public Direction getDir() {
        return dir;
    }
}
