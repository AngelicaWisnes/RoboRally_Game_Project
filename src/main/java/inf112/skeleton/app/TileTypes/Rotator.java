package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Rotation;

public class Rotator extends AbstractTile {
    Rotation rotation;

    public Rotator(Rotation rotation) {
        this.image = "rotate";
        this.rotation = rotation;
    }

    public Rotation getRotation() {
        return rotation;
    }

    @Override
    public String getImage() {
        if (rotation == Rotation.TURN_CLOCKWISE){
            return image + "_cw";
        } else if (rotation == Rotation.TURN_COUNTER_CLOCKWISE){
            return image + "_ccw";
        } else throw new IllegalArgumentException("Incorrect rotation argument!");
    }
}
