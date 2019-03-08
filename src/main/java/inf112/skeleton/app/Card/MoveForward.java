package inf112.skeleton.app.Card;

public class MoveForward extends MovementCard {

    public MoveForward(int priority, int steps) {

        super(priority, steps);
    }

    public String getKey() {
        return this.getClass().getSimpleName();
    }

    public String getDescription() {
        String description = "Forward " + super.steps;
        return description;
    }
}
