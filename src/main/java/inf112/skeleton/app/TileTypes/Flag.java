package inf112.skeleton.app.TileTypes;

public class Flag extends AbstractTile {

    int id;

    public Flag(int n) {
        this.image = "flag" + n;
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
