package inf112.skeleton.app.TileTypes;

/**
 * @author Roger Wisnes
 */
public class Pit extends Tile {

    public Pit() {
        this.image = "pit";
        this.size = 1;
    }

    @Override
    public String getImage() {
        return image;
    }
}
