package inf112.skeleton.app;

import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Card.MoveBackwards;
import inf112.skeleton.app.Card.MoveForward;
import inf112.skeleton.app.Card.RotationCard;
import inf112.skeleton.app.Enums.Rotation;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void cardHasRotation(){
        Card card = new RotationCard(50, Rotation.TURN_CLOCKWISE);
        assertEquals(Rotation.TURN_CLOCKWISE, ((RotationCard) card).getRotation());
    }
    @Test
    public void cardHasPriority(){
        Card card = new RotationCard(50, Rotation.TURN_CLOCKWISE);
        assertEquals(50, card.getPriority());
    }

    @Test
    public void forwardCardHasPriorityLow1Step() {
        Card card = new MoveForward(490, 1);
        assertEquals(490, card.getPriority());
    }

    @Test
    public void forwardCardHasPriorityHigh1Step() {
        Card card = new MoveForward(650, 1);
        assertEquals(650, card.getPriority());
    }

    @Test
    public void forwardCardHasPriorityLow2Steps() {
        Card card = new MoveForward(670, 2);
        assertEquals(670, card.getPriority());
    }

    @Test
    public void forwardCardHasPriorityHigh2Steps() {
        Card card = new MoveForward(780, 2);
        assertEquals(780, card.getPriority());
    }

    @Test
    public void forwardCardHasPriorityLow3Steps() {
        Card card = new MoveForward(790, 3);
        assertEquals(790, card.getPriority());
    }

    @Test
    public void forwardCardHasPriorityHigh3Steps() {
        Card card = new MoveForward(840, 3);
        assertEquals(840, card.getPriority());
    }

    @Test(expected = IllegalStateException.class)
    public void cardStepAttributeTest() {
        new MoveForward(55, 5);
    }
    @Test(expected = IllegalStateException.class)
    public void cardPriorityAttributeTest() {
        new MoveBackwards(10000, 1);
    }
}