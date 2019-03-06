package inf112.skeleton.app;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.MoveForward;
import inf112.skeleton.app.ProgramSheet.Slot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SlotTest {

    @Test
    public void slotIsAvailable() {
        Slot slot = new Slot();
        assert(slot.isAvailable());
    }

    @Test
    public void cardIsSet() {
        Slot slot = new Slot();
        slot.setCard(new MoveForward(50, 2));
        assertFalse(slot.isAvailable());
    }

    @Test
    public void slotLocks() {
        Slot slot = new Slot();
        slot.setCard(new MoveForward(50, 2));
        slot.lockSlot();
        assert(slot.isLocked());
    }

    @Test
    public void unlockedSlotReleasesCard() {
        Slot slot = new Slot();
        slot.setCard(new MoveForward(50, 2));
        slot.returnCard();
        assert(slot.isAvailable());
    }

    @Test
    public void unlockedSlotReleasesCorrectCard() {
        Slot slot = new Slot();
        AbstractCard card = new MoveForward(50, 2);
        slot.setCard(card);
        assertEquals(card, slot.returnCard());
    }
}
