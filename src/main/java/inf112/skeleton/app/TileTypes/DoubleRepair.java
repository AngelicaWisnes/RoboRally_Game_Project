package inf112.skeleton.app.TileTypes;

public class DoubleRepair extends AbstractRepair {

    public DoubleRepair() {
        super(1);
        this.image = "singleRepair";
    }

    @Override
    public String getImage() {
        return image;
    }
}
