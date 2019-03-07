package inf112.skeleton.app;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardGenerator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CardGeneratorTest {

    @Test
    public void generateCards() {
        ArrayList<AbstractCard> newCardStack = CardGenerator.getNewCardStack();
        assertFalse(newCardStack.isEmpty());
    }

    @Test
    public void allCardsAreUnique() {
        Set<Integer> ints = new HashSet<Integer>();
        ArrayList<AbstractCard> newCardStack = CardGenerator.getNewCardStack();

        for (AbstractCard c : newCardStack) {
            ints.add(c.getPriority());
            System.out.println(c);
        }
        assertEquals(newCardStack.size(), ints.size());
    }
}