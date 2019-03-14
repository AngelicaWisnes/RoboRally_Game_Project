package inf112.skeleton.app.TileTypes;

/**
 * @author Roger Wisnes
 */
public class Flag extends AbstractTile {

    public Flag(int id) {
        this.image = "flag" + id;
    }

    @Override
    public String getImage() {
        return image;
    }
}
