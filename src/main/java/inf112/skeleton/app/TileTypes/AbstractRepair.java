package inf112.skeleton.app.TileTypes;

public abstract class AbstractRepair implements ITile {

    int repairQty;

    public AbstractRepair(int n) {
        this.repairQty = n;
    }

    public int getRepairQty() { return repairQty; }

}
