package inf112.skeleton.app;

public abstract class Card {

    private int priority;


    public Card(int priority) {
        if (priority > 840 || priority < 10){throw new IllegalStateException();}
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
