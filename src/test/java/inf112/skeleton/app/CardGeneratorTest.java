package inf112.skeleton.app;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardDealer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CardGeneratorTest {

    @Test
    public void generateCards() {
        ArrayList<AbstractCard> newCardStack = CardDealer.getNewCardStack();
        assertFalse(newCardStack.isEmpty());
    }

    @Test
    public void allCardsAreUnique() {
        Set<Integer> ints = new HashSet<>();
        ArrayList<AbstractCard> newCardStack = CardDealer.getNewCardStack();

        for (AbstractCard c : newCardStack) {
            ints.add(c.getPriority());
        }
        assertEquals(newCardStack.size(), ints.size());
    }
}