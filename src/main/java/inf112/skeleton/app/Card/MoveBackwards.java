package inf112.skeleton.app.Card;

public class MoveBackwards extends MovementCard {

    public MoveBackwards(int priority, int steps) {
        super(priority, steps);
    }

    public String getKey() {
        return this.getClass().getSimpleName();
    }

    public String getDescription() {
        String description = "Backwards";
        return description;
    }
}
