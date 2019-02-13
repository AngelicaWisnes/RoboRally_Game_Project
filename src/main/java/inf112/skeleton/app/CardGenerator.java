package inf112.skeleton.app;

import java.util.ArrayList;

public class CardGenerator {
    ArrayList<Card> cards;

    public CardGenerator() {
        cards = new ArrayList<>();
        createCards();
    }

    private void createCards() {
        rotateRight();
/*
        rotateLeft();
        turnAround();
        forwardOne();
        forwardTwo();
        forwardThree();
        backwardOne();
*/
    }

    private void rotateRight() {
        int startingValue = 490;
        for (int i = 0; i < 18; i++){
            //cards.add(new Card(startingValue + (10*i)));

        }
    }

    //18 rotasjon høyre

    //18 rotasjon venstre

    //6 rotasjon turn around

    //18 1 frem

    //12 2 frem

    //6 3 frem

    //6 1 bakover

}
