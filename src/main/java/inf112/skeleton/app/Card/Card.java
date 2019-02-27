package inf112.skeleton.app.Card;

import com.sun.prism.TextureMap;

import java.util.HashMap;

public abstract class Card {

    private int priority;

    public Card(int priority) {
        if (priority > 840 || priority < 10){throw new IllegalStateException();}
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public abstract String getKey();
    public abstract String getDescription();



}
