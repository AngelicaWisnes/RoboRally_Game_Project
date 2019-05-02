package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Rotation;

public class Rotator implements ITile {
    Rotation rotation;

    public Rotator(Rotation rotation) {
        this.rotation = rotation;
    }

    public Rotation getRotation() {
        return rotation;
    }
    
}
