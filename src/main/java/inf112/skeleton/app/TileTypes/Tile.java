package inf112.skeleton.app.TileTypes;

/**
 * @author Magne
 */
public abstract class Tile implements iTile{
    protected String image;
    protected int size;

    @Override
    public String getImage(){
        return image;
    }
}
