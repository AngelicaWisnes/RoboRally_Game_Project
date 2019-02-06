package inf112.skeleton.app.TileTypes;

enum TileType {
    GEAR,
    REPAIR,
    PIT,
    EDGE,
    STARTINGPOINT,
    LASER,
    WALL,
}

public class Tile {

    private final Tile tileType;
    private final Direction rotation;
    private final int x;
    private final int y;

    public Tile(Tile tileType, int x, int y, Direction rotation) {
        this.tileType = tileType;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public Tile getTileType() {
        return tileType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getRotation() {
        return rotation;
    }

    //public getImage() {

    //}

    public static enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;

    }

}
