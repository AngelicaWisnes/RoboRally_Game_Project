package inf112.skeleton.app.TileTypes;

import inf112.skeleton.app.Enums.Rotation;

public class Rotator extends AbstractTile {
    Rotation rotation;

    public Rotator(Rotation rotation) {
        this.image = "rotate";
        this.rotation = rotation;

    }

    @Override
    public String getImage() {
        if (rotation == Rotation.CW){
            return image + "_cw";
        } else if (rotation == Rotation.CCW){
            return image + "_ccw";
        } else throw new IllegalArgumentException("Incorrect rotation argument!");
    }
}
