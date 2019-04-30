package inf112.skeleton.app.TileTypes;

public class Laser extends AbstractTile {

    public Laser() {
        this.image = "laserwall";
    }

    @Override
    public String getImage() {
        return image;
    }
}