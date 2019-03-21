package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;

public class LaserWall extends AbstractTile {
    Direction dir;

    public LaserWall(Direction dir) {
        this.dir = dir;
        this.image = "laserwall";
    }

    public Direction getDir() {
        return dir;
    }

    @Override
    public String getImage() {
        return image;
    }
}
