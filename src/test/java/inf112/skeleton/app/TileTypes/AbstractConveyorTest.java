package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractConveyorTest {

    AbstractConveyor singleTile;
    AbstractConveyor doubleTile;

    @Before
    public void setup() {
        singleTile = new SingleConveyor(Direction.LEFT);
        doubleTile = new DblConveyor(Direction.UP);
    }

    @Test
    public void getDirectionSingle() {
        assertEquals(Direction.LEFT, singleTile.getDirection());
    }

    @Test
    public void getDirectionDouble() {
        assertEquals(Direction.UP, doubleTile.getDirection());
    }

}