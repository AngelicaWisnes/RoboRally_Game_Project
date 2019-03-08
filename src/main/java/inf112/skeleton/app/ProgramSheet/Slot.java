package inf112.skeleton.app.ProgramSheet;

import inf112.skeleton.app.Card.AbstractCard;

public class Slot {
    private AbstractCard card;
    private boolean locked;

    public Slot() {
        this.locked = false;
    }

    public void lockSlot() {
        this.locked = true;
    }

    public void unlockSlot() {
        this.locked = false;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public boolean isAvailable() {
        return this.card == null;
    }

    public AbstractCard getCard() {
        return card;
    }

    public void setCard(AbstractCard card) {
        this.card = card;
    }

    /**
     * Removes card from slot, returns card to calling method.
     */
    public AbstractCard returnCard() {
        AbstractCard temp = this.card;
        if (!this.locked) {
            this.card = null;
        }
        return temp;
    }
}
