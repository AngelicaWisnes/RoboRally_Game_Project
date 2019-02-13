package inf112.skeleton.app;

public abstract class MovementCard extends Card {
    private int steps;

    public MovementCard(int priority, int steps) {
        super(priority);
        this.steps = steps;
    }
}
