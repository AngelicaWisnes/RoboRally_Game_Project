package inf112.skeleton.app.TileTypes;

/**
 * @author Magne
 */
public abstract class Tile implements iTile{
    private String image;
    private final int size;

    @Override
    public abstract String getImage();
}
