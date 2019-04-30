package inf112.skeleton.app.TileTypes;

public abstract class AbstractRepair extends AbstractTile {

    int repairQty;

    public AbstractRepair(int n) {
        this.repairQty = n;
        this.image = "repair";
    }

    public int getRepairQty() { return repairQty; }

    @Override
    public String getImage() {
        return image;
    }
}
