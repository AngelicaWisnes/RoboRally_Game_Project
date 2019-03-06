package inf112.skeleton.app.Card;

public abstract class MovementCard extends AbstractCard {
    protected int steps;

    public MovementCard(int priority, int steps) {
        super(priority);
        if (steps > 3 || steps < 1){throw new IllegalStateException();}
        this.steps = steps;
    }

    public int getSteps() {
        return this.steps;
    }
}
