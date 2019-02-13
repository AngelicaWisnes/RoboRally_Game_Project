package inf112.skeleton.app.TileTypes;

/**
 * @author Magne
 */
public abstract class AbstractTile implements iTile{
    protected String image;
    protected int size;

    protected AbstractTile() {
    }

    @Override
    public String getImage(){
        return image;
    }
}
