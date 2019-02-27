package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;

import java.util.HashMap;

public class ID_Translator {
    static HashMap<Integer, iTile> translator;

    static {
        translator.put(1, new Floor());
        translator.put(315, new Pit());
        translator.put(14, new Repair()); // Single Repair
        translator.put(29, new Repair()); // Double Repair
        // translator.put(1, new Void());
        // translator.put(1, new Dock(1));
        translator.put(60, new DblConveyor(Direction.LEFT));
        translator.put(83, new DblConveyor(Direction.RIGHT));
        translator.put(5, new DblConveyor(Direction.DOWN));
        translator.put(138, new DblConveyor(Direction.UP));
        translator.put(71, new SingleConveyor(Direction.LEFT));
        translator.put(72, new SingleConveyor(Direction.RIGHT));
        translator.put(137, new SingleConveyor(Direction.DOWN));
        translator.put(6, new SingleConveyor(Direction.UP));
        translator.put(278, new Rotator(Rotation.TURN_CLOCKWISE));
        translator.put(245, new Rotator(Rotation.TURN_COUNTER_CLOCKWISE));
        // translator.put(2, new Rotator(Rotation.TURN_AROUND));
    }

    public static iTile translate_ID(int id) {
        return translator.get(id);
    }
}

        // Laser med vegg 		= 	id 109\
        // Laser uten vegg 		= 	id 94\
