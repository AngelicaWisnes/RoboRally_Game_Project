package inf112.skeleton.app.TileTypes;

public abstract class AbstractRepair extends AbstractTile {

    int repairQty;

    /**
     * The constructor
     * @param n, the repair quantity
     */
    public AbstractRepair(int n) {
        this.repairQty = n;
        this.image = "repair";
    }

    /**
     * Quantity number of damagetokens that need to be repaired
     * @return the repair quantity
     */
    public int getRepairQty() { return repairQty; }

    @Override
    public String getImage() {
        return image;
    }
}
