package inf112.skeleton.app.Card;

public abstract class MovementCard extends AbstractCard {
    protected int steps;

    /**
     *
     * @param priority the cards priority
     * @param steps number of steps you can take with a card
     */
    public MovementCard(int priority, int steps) {
        super(priority);
        if (steps > 3 || steps < 1){throw new IllegalStateException();}
        this.steps = steps;
    }

    /**
     *
     * @return steps 
     */
    public int getSteps() {
        return this.steps;
    }
}
