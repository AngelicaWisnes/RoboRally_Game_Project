package inf112.skeleton.app.Card;

import inf112.skeleton.app.Enums.Rotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class CardDealer {
    private static Stack<AbstractCard> cardStack, usedCards;

    private static CardDealer ourInstance = new CardDealer();

    public static CardDealer getInstance() {
        return ourInstance;
    }

    private CardDealer() {
        usedCards = new Stack<>();
        cardStack = new Stack<>();
        cardStack.addAll(CardGenerator.getNewCardStack());
        Collections.shuffle(cardStack);
    }

    public static ArrayList<AbstractCard> getNewCardStack() {
        return new ArrayList<>(cardStack);
    }

    public void returnCardList(ArrayList<AbstractCard> used) { for (AbstractCard c : used) returnCard(c); }

    public void returnCard(AbstractCard used) { if (used != null && !(used instanceof BlankCard)) usedCards.add(used); }

    public AbstractCard dealBlankCard() { return new BlankCard(11); }

    public ArrayList<AbstractCard> dealCards(int qty) {
        ArrayList<AbstractCard> cardsToDeal = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            if (cardStack.isEmpty()) reshuffleCards();
            cardsToDeal.add(cardStack.pop());
        }

        return cardsToDeal;
    }


    private void reshuffleCards() {
        cardStack.addAll(usedCards);
        Collections.shuffle(cardStack);
        usedCards.clear();
    }


    private static class CardGenerator {
        private static ArrayList<AbstractCard> cards;

        static ArrayList<AbstractCard> getNewCardStack() {
            cards = new ArrayList<>();
            createCards();
            Collections.shuffle(cards);
            return cards;
        }

        private static void createCards() {
            rotate(Rotation.TURN_COUNTER_CLOCKWISE, 70, 18, 20);
            rotate(Rotation.TURN_CLOCKWISE, 80, 18, 20);
            rotate(Rotation.TURN_AROUND, 10, 6, 10);
            movement(1, 490, 18, false);
            movement(2, 670, 12, false);
            movement(3, 790, 6, false);
            movement(1, 430, 6, true);
        }


        private static void movement(int steps, int startingValue, int n, boolean backwards) {
            for (int i = 0; i < n; i++) {
                if (backwards) cards.add(new MoveBackwards(startingValue + (10 * i), steps));
                else cards.add(new MoveForward(startingValue + (10 * i), steps));
            }
        }

        private static void rotate(Rotation rotation, int startingValue, int n, int increment) {
            for (int i = 0; i < n; i++) cards.add(new RotationCard(startingValue + (increment * i), rotation));
        }
    }
}
