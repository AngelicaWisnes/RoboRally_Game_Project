package inf112.skeleton.app.TileTypes;

/**
 *
 * @Author Magne
 *
 * There are two types of Repair fields. Single and Double.
 *
 */

public class Repair extends AbstractTile {

    public Repair() {
        this.image = "repair";
    }

    @Override
    public String getImage() {
        return image;
    }
}
