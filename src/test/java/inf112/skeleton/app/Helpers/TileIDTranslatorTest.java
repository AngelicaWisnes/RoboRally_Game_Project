package inf112.skeleton.app.Helpers;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.TileTypes.DblConveyor;
import inf112.skeleton.app.TileTypes.SingleConveyor;
import inf112.skeleton.app.TileTypes.Rotator;
import inf112.skeleton.app.TileTypes.Dock;
import inf112.skeleton.app.TileTypes.Flag;
import inf112.skeleton.app.TileTypes.Laser;
import inf112.skeleton.app.TileTypes.LaserWall;

import inf112.skeleton.app.TileTypes.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileIDTranslatorTest {

    /*@Test
    public void translateIdToTileTestFloor() {
        DblConveyor tile = (DblConveyor) TileIDTranslator.translate_ID(145);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.LEFT).getDirection());
    }*/

    @Test
    public void translateIdToTileTestDocking1() {
        Dock tile = (Dock) TileIDTranslator.translate_ID(147);
        assertEquals(tile.getId(), new Dock(1).getId());
    }

    @Test
    public void translateIdToTileTestDocking2() {
        Dock tile = (Dock) TileIDTranslator.translate_ID(159);
        assertEquals(tile.getId(), new Dock(2).getId());
    }

    @Test
    public void translateIdToTileTestDocking3() {
        Dock tile = (Dock) TileIDTranslator.translate_ID(171);
        assertEquals(tile.getId(), new Dock(3).getId());
    }

    @Test
    public void translateIdToTileTestDocking4() {
        Dock tile = (Dock) TileIDTranslator.translate_ID(149);
        assertEquals(tile.getId(), new Dock(4).getId());
    }

    @Test
    public void translateIdToTileTestDocking5() {
        Dock tile = (Dock) TileIDTranslator.translate_ID(161);
        assertEquals(tile.getId(), new Dock(5).getId());
    }

    /*@Test
    public void translateIdToTileTestDockingArea() {
        DblConveyor tile = (DblConveyor) TileIDTranslator.translate_ID(277);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.LEFT).getDirection());
    }*/

    @Test
    public void translateIdToTileTestFlag1() {
        Flag tile = (Flag) TileIDTranslator.translate_ID(148);
        assertEquals(tile.getId(), new Flag(1).getId());
    }

    @Test
    public void translateIdToTileTestFlag2() {
        Flag tile = (Flag) TileIDTranslator.translate_ID(153);
        assertEquals(tile.getId(), new Flag(2).getId());
    }

    @Test
    public void translateIdToTileTestFlag3() {
        Flag tile = (Flag) TileIDTranslator.translate_ID(154);
        assertEquals(tile.getId(), new Flag(3).getId());
    }

    /*@Test
    public void translateIdToTileTestPit() {
        Pit tile = (Pit) TileIDTranslator.translate_ID(315);
        assertEquals(tile, new Pit(Direction.LEFT).getDirection());
    }

    @Test
    public void translateIdToTileTestSingleRepair() {
        SingleRepair tile = (SingleRepair) TileIDTranslator.translate_ID(158);
        assertEquals(tile.getDirection(), new SingleRepair(Direction.LEFT).getDirection());
    }

    @Test
    public void translateIdToTileTestDoubleRepair() {
        DoubleRepair tile = (DoubleRepair) TileIDTranslator.translate_ID(173);
        assertEquals(tile.getDirection(), new DoubleRepair(Direction.LEFT).getDirection());
    }*/

    @Test
    public void translateIdToTileTestRotatorCW() {
        Rotator tile = (Rotator) TileIDTranslator.translate_ID(1350);
        assertEquals(tile.getRotation(), new Rotator(Rotation.TURN_CLOCKWISE).getRotation());
    }


    @Test
    public void translateIdToTileTestRotatorCCW() {
        Rotator tile = (Rotator) TileIDTranslator.translate_ID(1317);
        assertEquals(tile.getRotation(), new Rotator(Rotation.TURN_COUNTER_CLOCKWISE).getRotation());
    }

    @Test
    public void translateIdToTileTestSingleConveyorUp() {
        SingleConveyor tile = (SingleConveyor) TileIDTranslator.translate_ID(151);
        assertEquals(tile.getDirection(), new SingleConveyor(Direction.UP).getDirection());
    }

    @Test
    public void translateIdToTileTestDoubleConveyorUp() {
        DblConveyor tile = (DblConveyor) TileIDTranslator.translate_ID(283);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.UP).getDirection());
    }

    @Test
    public void translateIdToTileTestSingleConveyorDown() {
        SingleConveyor tile = (SingleConveyor) TileIDTranslator.translate_ID(282);
        assertEquals(tile.getDirection(), new SingleConveyor(Direction.DOWN).getDirection());
    }

    @Test
    public void translateIdToTileTestDoubleConveyorDown() {
        DblConveyor tile = (DblConveyor) TileIDTranslator.translate_ID(150);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.DOWN).getDirection());
    }

    @Test
    public void translateIdToTileTestSingleConveyorLeft() {
        SingleConveyor tile = (SingleConveyor) TileIDTranslator.translate_ID(216);
        assertEquals(tile.getDirection(), new SingleConveyor(Direction.LEFT).getDirection());
    }

    @Test
    public void translateIdToTileTestDoubleConveyorLeft() {
        DblConveyor tile = (DblConveyor) TileIDTranslator.translate_ID(205);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.LEFT).getDirection());
    }

    @Test
    public void translateIdToTileTestSingleConveyorRight() {
        SingleConveyor tile = (SingleConveyor) TileIDTranslator.translate_ID(217);
        assertEquals(tile.getDirection(), new SingleConveyor(Direction.RIGHT).getDirection());
    }

    @Test
    public void translateIdToTileTestDoubleConveyorRight() {
        DblConveyor tile = (DblConveyor) TileIDTranslator.translate_ID(228);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.RIGHT).getDirection());
    }

    @Test
    public void translateIdToTileTestWallUp() {
        Wall tile = (Wall) TileIDTranslator.translate_ID(166);
        assertEquals(tile.hasWall(Direction.UP), new Wall(Direction.UP).hasWall(Direction.UP));
    }

    @Test
    public void translateIdToTileTestWallDown() {
        Wall tile = (Wall) TileIDTranslator.translate_ID(261);
        assertEquals(tile.hasWall(Direction.DOWN), new Wall(Direction.DOWN).hasWall(Direction.DOWN));
    }

    @Test
    public void translateIdToTileTestWallLeft() {
        Wall tile = (Wall) TileIDTranslator.translate_ID(230);
        assertEquals(tile.hasWall(Direction.LEFT), new Wall(Direction.LEFT).hasWall(Direction.LEFT));
    }

    @Test
    public void translateIdToTileTestWallRight() {
        Wall tile = (Wall) TileIDTranslator.translate_ID(284);
        assertEquals(tile.hasWall(Direction.RIGHT), new Wall(Direction.RIGHT).hasWall(Direction.RIGHT));
    }

    @Test
    public void translateIdToTileTestLaserWallLeft() {
        LaserWall tile = (LaserWall) TileIDTranslator.translate_ID(909);
        assertEquals(tile.hasWall(Direction.LEFT), new LaserWall(Direction.LEFT).hasWall(Direction.LEFT));
    }

    @Test
    public void translateIdToTileTestLaserWallRight() {
        LaserWall tile = (LaserWall) TileIDTranslator.translate_ID(929);
        assertEquals(tile.hasWall(Direction.RIGHT), new LaserWall(Direction.RIGHT).hasWall(Direction.RIGHT));
    }

    /*@Test
    public void translateIdToTileTestLaserHorisontal() {
        Laser tile = (Laser) TileIDTranslator.translate_ID(910);
        assertEquals(tile.getDirection(), new DblConveyor(Direction.LEFT).getDirection());
    }*/

    @Test
    public void translateIdToTileTestLaserWallUp() {
        LaserWall tile = (LaserWall) TileIDTranslator.translate_ID(646);
        assertEquals(tile.hasWall(Direction.UP), new LaserWall(Direction.UP).hasWall(Direction.UP));
    }

    @Test
    public void translateIdToTileTestLaserWallDown() {
        LaserWall tile = (LaserWall) TileIDTranslator.translate_ID(1206);
        assertEquals(tile.hasWall(Direction.DOWN), new LaserWall(Direction.DOWN).hasWall(Direction.DOWN));
    }

    /*@Test
    public void translateIdToTileTestLaserVertical() {
        Laser tile = (Laser) TileIDTranslator.translate_ID(674);
        assertEquals(tile.getDirection(), new Laser(Direction.LEFT).getDirection());
    }*/
}