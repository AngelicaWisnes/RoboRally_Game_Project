package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractConveyorTest {

    AbstractConveyor singleTileN;
    AbstractConveyor singleTileS;
    AbstractConveyor singleTileE;
    AbstractConveyor singleTileW;

    AbstractConveyor doubleTileN;
    AbstractConveyor doubleTileS;
    AbstractConveyor doubleTileE;
    AbstractConveyor doubleTileW;

    @Before
    public void setup() {
        singleTileN = new SingleConveyor(Direction.UP);
        singleTileS = new SingleConveyor(Direction.DOWN);
        singleTileE = new SingleConveyor(Direction.RIGHT);
        singleTileW = new SingleConveyor(Direction.LEFT);

        doubleTileN = new DblConveyor(Direction.UP);
        doubleTileS = new DblConveyor(Direction.DOWN);
        doubleTileE = new DblConveyor(Direction.RIGHT);
        doubleTileW = new DblConveyor(Direction.LEFT);
    }

    @Test
    public void singleUpTest() {
        assertEquals(Direction.UP, singleTileN.getDirection());
    }

    @Test
    public void singleDownTest() {
        assertEquals(Direction.DOWN, singleTileS.getDirection());
    }

    @Test
    public void singleRightTest() {
        assertEquals(Direction.RIGHT, singleTileE.getDirection());
    }

    @Test
    public void singleLeftTest() {
        assertEquals(Direction.LEFT, singleTileW.getDirection());
    }

    @Test
    public void doubleUpTest() {
        assertEquals(Direction.UP, doubleTileN.getDirection());
    }

    @Test
    public void doubleDownTest() {
        assertEquals(Direction.DOWN, doubleTileS.getDirection());
    }

    @Test
    public void doubleRightTest() {
        assertEquals(Direction.RIGHT, doubleTileE.getDirection());
    }

    @Test
    public void doubleLeftTest() {
        assertEquals(Direction.LEFT, doubleTileW.getDirection());
    }

}