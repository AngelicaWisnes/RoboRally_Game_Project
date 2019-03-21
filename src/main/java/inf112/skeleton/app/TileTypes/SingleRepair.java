package inf112.skeleton.app.TileTypes;

public class SingleRepair extends AbstractRepair {

    public SingleRepair() {
        super(1);
        this.image = "singleRepair";
    }

    @Override
    public String getImage() {
        return image;
    }

}
