package inf112.skeleton.app.Helpers;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.TileTypes.*;

import java.util.HashMap;

public class TileIDTranslator {
    static HashMap<Integer, ITile> translator = new HashMap<>();

    static {
        translator.put(1, new Floor());
        translator.put(315, new Pit());
        translator.put(14, new Repair()); // Single Repair
        translator.put(29, new Repair()); // Double Repair
        // translator.put(1, new Void());
        // translator.put(1, new Dock(1));
        translator.put(61, new DblConveyor(Direction.LEFT));
        translator.put(84, new DblConveyor(Direction.RIGHT));
        translator.put(6, new DblConveyor(Direction.DOWN));
        translator.put(139, new DblConveyor(Direction.UP));
        translator.put(72, new SingleConveyor(Direction.LEFT));
        translator.put(73, new SingleConveyor(Direction.RIGHT));
        translator.put(138, new SingleConveyor(Direction.DOWN));
        translator.put(7, new SingleConveyor(Direction.UP));
        translator.put(278, new Rotator(Rotation.TURN_CLOCKWISE));
        translator.put(245, new Rotator(Rotation.TURN_COUNTER_CLOCKWISE));
        translator.put(129, new Rotator(Rotation.TURN_COUNTER_CLOCKWISE));

        // translator.put(2, new Rotator(Rotation.TURN_AROUND));
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
