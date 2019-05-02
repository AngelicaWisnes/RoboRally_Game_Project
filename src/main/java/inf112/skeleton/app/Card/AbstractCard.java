package inf112.skeleton.app.Card;

public abstract class AbstractCard {

    private int priority;

    public AbstractCard(int priority) {
        if (priority > 840 || priority < 10){throw new IllegalStateException();}
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * @return the value for the hash map lookup
     * of the texture to be used for the card
     */
    public abstract String getKey();

    /**
     * @return the simple text description
     * of the card
     */
    public abstract String getDescription();
}
