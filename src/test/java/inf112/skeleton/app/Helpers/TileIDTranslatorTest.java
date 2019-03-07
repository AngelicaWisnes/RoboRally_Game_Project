package inf112.skeleton.app.Helpers;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.TileTypes.DblConveyor;
import inf112.skeleton.app.TileTypes.ITile;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileIDTranslatorTest {

    @Test
    public void translateIdToTileTest() {
        DblConveyor tile = (DblConveyor) TileIDTranslator.translate_ID(60);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.LEFT).getDirection());
    }
}