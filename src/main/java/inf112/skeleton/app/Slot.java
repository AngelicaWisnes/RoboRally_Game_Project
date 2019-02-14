package inf112.skeleton.app;

public class Slot {
    private Card card;
    private boolean locked;

    public Slot(){
        this.locked = false;
    }

    public void lockSlot(){
        this.locked = true;
    }
    public void unlockSlot(){
        this.locked = false;
    }

    public boolean isAvailable(){
        return this.card.equals(null);
    }

    public void setCard(Card card){
        this.card = card;
    }
    /**
     * Removes card from slot, returns card to calling method.
     */
    public Card returnCard(){
        Card temp = this.card;
        if (!this.locked){
            this.card = null;
        }
        return temp;
    }
}
