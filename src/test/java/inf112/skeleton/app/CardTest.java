package inf112.skeleton.app;

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
    @Test(expected = IllegalStateException.class)
    public void cardStepAttributeTest() {
        new MoveForward(55, 5);
    }
    @Test(expected = IllegalStateException.class)
    public void cardPriorityAttributeTest() {
        new MoveBackwards(10000, 1);
    }
}