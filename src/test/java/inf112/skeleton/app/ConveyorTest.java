package inf112.skeleton.app;

import inf112.skeleton.app.TileTypes.Conveyor;
import inf112.skeleton.app.TileTypes.DblConveyor;
import inf112.skeleton.app.TileTypes.SingleConveyor;
import inf112.skeleton.app.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class ConveyorTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void singleConveyorSetsCorrectImage() {
        Conveyor conveyor = new SingleConveyor(Direction.DOWN);
        assertEquals(conveyor.getImage(), "conveyor_down");
    }
    @Test
    public void doubleConveyorSetsCorrectImage() {
        Conveyor conveyor = new DblConveyor(Direction.DOWN);
        assertEquals(conveyor.getImage(), "dbl_conveyor_down");
    }
}
