package inf112.skeleton.app.ProgramSheet;

import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Card.MoveForward;
import inf112.skeleton.app.ProgramSheet.Slot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class SlotTest {

    private Slot slot;

    @Before
    public void initialize() {
        slot = new Slot();
    }

    @Test
    public void slotIsAvailable() {
        assert(slot.isAvailable());
    }

    @Test
    public void cardIsSet() {
        slot.setCard(new MoveForward(50, 2));
        assertFalse(slot.isAvailable());
    }

    @Test
    public void slotLocks() {
        slot.setCard(new MoveForward(50, 2));
        slot.lockSlot();
        assert(slot.isLocked());
    }

    @Test
    public void unlockedSlotReleasesCard() {
        slot.setCard(new MoveForward(50, 2));
        slot.returnCard();
        assert(slot.isAvailable());
    }

    @Test
    public void unlockedSlotReleasesCorrectCard() {
        Card card = new MoveForward(50, 2);
        slot.setCard(card);
        assertEquals(card, slot.returnCard());
    }
}
