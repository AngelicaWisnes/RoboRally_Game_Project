package inf112.skeleton.app;

import inf112.skeleton.app.Enums.Rotation;

import java.util.ArrayList;

public class CardGenerator {
    ArrayList<Card> cards;

    public static void main(String[] args) {
        CardGenerator cg = new CardGenerator();
    }

    public CardGenerator() {
        cards = new ArrayList<>();
        createCards();
        for (Card c : cards)
            System.out.println(c.getPriority());
    }

    private void createCards() {
        rotateClockwise();
/*
        rotateLeft();
        turnAround();
        forwardOne();
        forwardTwo();
        forwardThree();
        backwardOne();
*/
    }

    private void rotateClockwise() {
        int startingValue = 80;
        for (int i = 0; i < 18; i++){
            cards.add(new RotationCard(startingValue + (20*i), Rotation.TURN_CLOCKWISE));
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
