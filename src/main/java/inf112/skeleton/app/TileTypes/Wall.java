package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;

public class Wall extends AbstractTile {
    Direction dir;

    public Wall(Direction dir) {
        this.dir = dir;
        this.image = "wall";
    }

    public Direction getDir() {
        return dir;
    }

    @Override
    public String getImage() {
        return image;
    }
}
