package inf112.skeleton.app.ProgramSheet;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.BlankCard;

public class Slot {
    private AbstractCard card;
    private boolean locked;

    Slot() { this.locked = false; }

    void lockSlot() { this.locked = true; }

    void unlockSlot() { this.locked = false; }

    boolean isLocked() { return this.locked; }

    boolean isAvailable() { return this.card == null; }

    public AbstractCard getCard() { return card; }

    void removeCard() { if (!this.locked) this.card = null; }

    public void setCard(AbstractCard card) { this.card = card; }

    /**
     * Removes card from slot, returns card to calling method.
     */
    AbstractCard returnCard() {
        if (!this.locked && !(this.card instanceof BlankCard)) {
            AbstractCard temp = this.card;
            this.card = null;
            return temp;
        }
        return null;
    }
}
