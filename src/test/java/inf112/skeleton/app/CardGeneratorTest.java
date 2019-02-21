package inf112.skeleton.app;

import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Card.CardGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CardGeneratorTest {

    @Test
    public void generateCards() {
        ArrayList<Card> newCardStack = CardGenerator.getNewCardStack();
        assertFalse(newCardStack.isEmpty());
    }

    @Test
    public void allCardsAreUnique() {
        Set<Integer> ints = new HashSet<Integer>();
        ArrayList<Card> newCardStack = CardGenerator.getNewCardStack();

        for (Card c : newCardStack) {
            ints.add(c.getPriority());
        }
        assertEquals(newCardStack.size(), ints.size());
    }
}