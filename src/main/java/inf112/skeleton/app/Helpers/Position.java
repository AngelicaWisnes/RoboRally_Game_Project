package inf112.skeleton.app.Helpers;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Screens.GameScreen;
import inf112.skeleton.app.TileTypes.ITile;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    /**
     * Sets both x and y
     * @param x value
     * @param y value
     */
    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Creates a new Position with same x- and y-value as this
     * @return new position
     */
    public Position clone() { return new Position(this.x, this.y); }

    public Position getNeighbour(Direction dir, int size) {
        switch (dir) {
            case UP: return new Position(this.x, this.y + size);
            case DOWN: return new Position(this.x, this.y - size);
            case LEFT: return new Position(this.x - size, this.y);
            case RIGHT: return new Position(this.x + size, this.y);
            default: throw new IllegalArgumentException("Must have valid direction-input to move robot");
        }
    }

    public static ITile getTileOnPos(Position p, TiledMap map) {
        int x = p.getX() / GameScreen.TILESIZE;
        int y = p.getY() / GameScreen.TILESIZE;
        try {
            TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(x, y);
            int tileID = cell.getTile().getId();
            return TileIDTranslator.translate_ID(tileID);
        } catch (Exception e) {
            return null;
        }
    }


}
