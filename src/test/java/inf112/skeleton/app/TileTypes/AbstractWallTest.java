package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractWallTest {

    AbstractWall wallN;
    AbstractWall wallS;
    AbstractWall wallE;
    AbstractWall wallW;

    @Before
    public void setup() {
        wallN = new Wall(Direction.UP);
        wallS = new Wall(Direction.DOWN);
        wallE = new Wall(Direction.RIGHT);
        wallW = new Wall(Direction.LEFT);

    }

    @Test
    public void getDirectionWallNorthTest() {
        assertEquals(Direction.UP, wallN.getDirection());
    }

    @Test
    public void getDirectionWallSouththTest() {
        assertEquals(Direction.DOWN, wallS.getDirection());
    }

    @Test
    public void getDirectionWallEastTest() {
        assertEquals(Direction.RIGHT, wallE.getDirection());
    }

    @Test
    public void getDirectionWallWestTest() {
        assertEquals(Direction.LEFT, wallW.getDirection());
    }

}
