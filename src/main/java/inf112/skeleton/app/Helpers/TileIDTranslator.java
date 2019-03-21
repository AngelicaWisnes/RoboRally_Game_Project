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
        translator.put(154, new Flag(2));
        translator.put(929, new Flag(3));

        translator.put(315, new Pit());

        translator.put(158, new SingleRepair()); // Single Repair
        translator.put(173, new DoubleRepair()); // Double Repair

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

        /*
        translator.put(909, new Laser());
        translator.put(929, new Laser());
        translator.put(928, new Laser());

        translator.put(646, new Laser());
        translator.put(1206, new Laser());
        translator.put(674, new Laser());
        */
    }

    public static ITile translate_ID(int id) {
        return translator.get(id);
    }
}

    /**
     * Future tiles
     * Laser med vegg 		= 	id 109\
     * Laser uten vegg 		= 	id 94\
     */
