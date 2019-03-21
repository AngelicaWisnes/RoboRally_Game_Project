package inf112.skeleton.app.TileTypes;

/**
 *
 * @Author Magne
 *
 * There are two types of AbstractRepair fields. Single and Double.
 *
 */

public abstract class AbstractRepair extends AbstractTile {

    public AbstractRepair() {
        this.image = "repair";
    }

    @Override
    public String getImage() {
        return image;
    }
}
