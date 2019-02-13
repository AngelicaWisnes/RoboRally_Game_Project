package inf112.skeleton.app.TileTypes;

/**
 *
 * @Author Stefan
 *
 *
 */

public class Floor extends AbstractTile {
    public Floor() {
        image = "factoryTile";
    }

    @Override
    public String getImage() {
        return image;
    }
}
