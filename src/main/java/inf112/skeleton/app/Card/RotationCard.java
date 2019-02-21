package inf112.skeleton.app.Card;


import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Enums.Rotation;

public class RotationCard extends Card {
    private Rotation rotation;

    public RotationCard(int priority, Rotation rotation) {
        super(priority);
        this.rotation = rotation;
    }

    public Rotation getRotation() {
        return rotation;
    }
}
