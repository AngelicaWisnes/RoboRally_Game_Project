package inf112.skeleton.app.TileTypes;

public class Dock extends AbstractTile {

    int id;

    public Dock(int n) {
        this.image = "dock" + n;
        this.id = n;
    }

    @Override
    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }
}
