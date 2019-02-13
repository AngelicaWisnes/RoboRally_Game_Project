package inf112.skeleton.app;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CardGeneratorTest {

    @Test
    public void generateCards() {
        ArrayList<Card> newCardStack = CardGenerator.getNewCardStack();
        assertFalse(newCardStack.isEmpty());
    }

}