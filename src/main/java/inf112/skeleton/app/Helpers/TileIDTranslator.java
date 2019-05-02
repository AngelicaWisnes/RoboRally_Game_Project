package inf112.skeleton.app.Helpers;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.TileTypes.*;

import java.util.HashMap;

public class TileIDTranslator {
    static HashMap<Integer, ITile> translator = new HashMap<>();

    static {
        translator.put(145, new Floor());
        translator.put(277, new DockArea());
        translator.put(147, new Dock(1));
        translator.put(159, new Dock(2));
        translator.put(171, new Dock(3));
        translator.put(149, new Dock(4));
        translator.put(161, new Dock(5));
        translator.put(184, new Dock(6));
        translator.put(195, new Dock(7));
        translator.put(194, new Dock(8));

        translator.put(148, new Flag(1));
        translator.put(153, new Flag(2));
        translator.put(154, new Flag(3));

        translator.put(315, new Pit());

        translator.put(158, new SingleRepair()); // Single AbstractRepair
        translator.put(173, new DoubleRepair()); // Double AbstractRepair

        translator.put(1350, new Rotator(Rotation.TURN_CLOCKWISE));
        translator.put(1317, new Rotator(Rotation.TURN_COUNTER_CLOCKWISE));

        translator.put(151, new SingleConveyor(Direction.UP));
        translator.put(282, new SingleConveyor(Direction.DOWN));
        translator.put(216, new SingleConveyor(Direction.LEFT));
        translator.put(217, new SingleConveyor(Direction.RIGHT));

        translator.put(283, new DblConveyor(Direction.UP));
        translator.put(150, new DblConveyor(Direction.DOWN));
        translator.put(205, new DblConveyor(Direction.LEFT));
        translator.put(228, new DblConveyor(Direction.RIGHT));

        translator.put(929, new LaserWall(Direction.RIGHT));        //LaserWall m/wall right
        translator.put(909, new LaserWall(Direction.LEFT));         //LaserWall m/wall left
        translator.put(910, new Laser());                           //Laser u/wall horizontal

        translator.put(646, new LaserWall(Direction.UP));           //LaserWall m/wall up
        translator.put(1206, new LaserWall(Direction.DOWN));        //LaserWall m/wall down
        translator.put(674, new Laser());                           //Laser u/wall vertical

        translator.put(166, new Wall(Direction.UP));                //wall up
        translator.put(261, new Wall(Direction.DOWN));              //wall down
        translator.put(230, new Wall(Direction.LEFT));              //wall left
        translator.put(284, new Wall(Direction.RIGHT));             //wall right
    }

    public static ITile translate_ID(int id) {
        return translator.get(id);
    }
}

