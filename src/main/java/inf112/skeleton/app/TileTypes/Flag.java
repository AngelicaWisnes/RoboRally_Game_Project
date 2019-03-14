package inf112.skeleton.app.TileTypes;

/**
 * @author Roger Wisnes
 */
public class Flag extends AbstractTile {

    private static int id;

    public Flag(int id) {
        this.id = id;
        this.image = "flag" + id;
    }

    @Override
    public String getImage() {
        return image;
    }

    public int getID(int id) {
        return this.id;
    }
}
