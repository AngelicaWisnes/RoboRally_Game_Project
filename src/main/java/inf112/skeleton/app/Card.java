package inf112.skeleton.app;

public abstract class Card {

    private int priority;


    public Card(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
