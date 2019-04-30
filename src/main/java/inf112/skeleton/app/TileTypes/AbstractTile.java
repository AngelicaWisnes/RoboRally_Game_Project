package inf112.skeleton.app.TileTypes;

public abstract class AbstractTile implements ITile {
    protected String image;

    @Override
    public String getImage(){
        return image;
    }
}
