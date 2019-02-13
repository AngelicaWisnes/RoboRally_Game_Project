package inf112.skeleton.app.TileTypes;

/**
 * @author Roger Wisnes
 */

public class Dock extends AbstractTile {

    public Dock(int n) {
        this.image = "dock" + n;
    }

    @Override
    public String getImage() {
        return image;
    }
}
