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

    public String getKey() {
        return this.getClass().getSimpleName() + this.rotation;
    }

    public String getDescription() {
        if (this.rotation == Rotation.TURN_CLOCKWISE) {
            return "Rotate Clockwise";
        }
        else if (this.rotation == Rotation.TURN_COUNTER_CLOCKWISE) {
             return "Rotate Counter Clockwise";
        }
        else if (this.rotation == Rotation.TURN_AROUND) {
            return"Turn Around";
        }
        else {
            throw new IllegalStateException("rotation incorrect");
        }

    }

}
