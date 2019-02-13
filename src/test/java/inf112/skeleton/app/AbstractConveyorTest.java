package inf112.skeleton.app;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.TileTypes.AbstractConveyor;
import inf112.skeleton.app.TileTypes.DblConveyor;
import inf112.skeleton.app.TileTypes.SingleConveyor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AbstractConveyorTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void singleConveyorSetsCorrectImage() {
        AbstractConveyor conveyor = new SingleConveyor(Direction.DOWN);
        assertEquals(conveyor.getImage(), "conveyor_down");
    }
    @Test
    public void doubleConveyorSetsCorrectImage() {
        AbstractConveyor conveyor = new DblConveyor(Direction.DOWN);
        assertEquals(conveyor.getImage(), "dbl_conveyor_down");
    }
}
