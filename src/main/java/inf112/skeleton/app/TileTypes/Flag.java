package inf112.skeleton.app.TileTypes;

public class Flag implements ITile {

    int id;

    public Flag(int n) {
        this.id = n;
    }

    public int getId() {
        return id;
    }
}
