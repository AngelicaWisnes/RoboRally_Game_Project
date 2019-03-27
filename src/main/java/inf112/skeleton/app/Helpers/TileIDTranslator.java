package inf112.skeleton.app.Helpers;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.TileTypes.*;

import java.util.HashMap;

public class TileIDTranslator {
    static HashMap<Integer, ITile> translator = new HashMap<>();

    static {
        translator.put(145, new Floor());
        translator.put(160, new DockArea());
        translator.put(147, new Dock(1));

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

        translator.put(929, new LaserWall(Direction.RIGHT));        //LaserWall m/vegg høyre
        translator.put(909, new LaserWall(Direction.LEFT));         //LaserWall m/vegg venstre
        translator.put(910, new Laser());                           //Laser u/vegg horisontal

        translator.put(646, new LaserWall(Direction.UP));           //LaserWall m/vegg oppe
        translator.put(1206, new LaserWall(Direction.DOWN));        //LaserWall m/vegg nede
        translator.put(674, new Laser());                           //Laser u/vegg vertikal

        translator.put(166, new Wall(Direction.UP));                //vegg oppe
        translator.put(261, new Wall(Direction.DOWN));              //vegg nede
        translator.put(230, new Wall(Direction.LEFT));              //vegg venstre
        translator.put(284, new Wall(Direction.RIGHT));             //vegg høyre
    }

    public static ITile translate_ID(int id) {
        return translator.get(id);
    }
}

    /**
     * Future tiles
     * LaserWall med vegg 		= 	id 109\
     * LaserWall uten vegg 		= 	id 94\
     */
