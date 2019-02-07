package inf112.skeleton.app.TileTypes;

/**
 * @author Magne
 */
public abstract class Tile implements iTile{
    protected String image;
    protected int size;

    protected Tile() {
    }

    @Override
    public String getImage(){
        return image;
    }
}
