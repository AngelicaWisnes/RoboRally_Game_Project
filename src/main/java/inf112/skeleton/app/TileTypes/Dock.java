package inf112.skeleton.app.TileTypes;

public class Dock implements ITile {

    int id;

    public Dock(int n) {
        this.id = n;
    }

    public int getId() {
        return id;
    }
}
