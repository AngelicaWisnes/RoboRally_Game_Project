package inf112.skeleton.app.TileTypes;

/**
 *
 * @Author Magne
 *
 * There are two types of Repairfields. Single and Double.
 *
 */

public class Repair extends Tile{

    String image = "factory";


    public Repair() {

    }

    @Override
    public String getImage() {

        return image;
    }
}
