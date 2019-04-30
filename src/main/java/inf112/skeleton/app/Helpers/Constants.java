package inf112.skeleton.app.Helpers;

import java.util.HashMap;

public class Constants {
    public final static int TILESIZE = 64;
    public final static int MAPWIDTH = 16;
    public final static int MAPHEIGHT = 12;
    public final static HashMap<Integer, Position> START_POSITION = new HashMap<>();

    static {
        START_POSITION.put(1, new Position(2 * TILESIZE, 10 * TILESIZE));
        START_POSITION.put(2, new Position(1 * TILESIZE, 8 * TILESIZE));
        START_POSITION.put(3, new Position(0 * TILESIZE, 5 * TILESIZE));
        START_POSITION.put(4, new Position(1 * TILESIZE, 2 * TILESIZE));
        START_POSITION.put(5, new Position(2 * TILESIZE,0 * TILESIZE));
        START_POSITION.put(6, new Position(2 * TILESIZE,6 * TILESIZE));
        START_POSITION.put(7, new Position(2 * TILESIZE, 4 * TILESIZE));
        START_POSITION.put(8, new Position(3 * TILESIZE, 5 * TILESIZE));
    }
}
