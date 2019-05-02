package inf112.skeleton.app.TileTypes;

public abstract class AbstractRepair implements ITile {

    int repairQty;

    /**
     * The constructor
     * @param n, the repair quantity
     */
    public AbstractRepair(int n) {
        this.repairQty = n;
    }

    /**
     * Quantity number of damagetokens that need to be repaired
     * @return the repair quantity
     */
    public int getRepairQty() { return repairQty; }

}
