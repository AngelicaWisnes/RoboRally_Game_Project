package inf112.skeleton.app.TileTypes;

/**
 *
 * @Author Magne
 *
 * There are two types of Repairfields. Single and Double.
 *
 */

public class Repair extends Tile{

    public Repair() {
        this.image = "repair";
    }

    @Override
    public String getImage() {

        return image;
    }
}
