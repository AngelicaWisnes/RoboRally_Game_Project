package inf112.skeleton.app.TileTypes;

/**
 * @author Roger Wisnes
 */

public class Dock extends AbstractTile {

    public Dock(int id) {
        this.image = "dock" + id;
    }

    @Override
    public String getImage() {
        return image;
    }
}
