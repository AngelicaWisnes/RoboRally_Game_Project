package inf112.skeleton.app.Network;

import inf112.skeleton.app.Card.AbstractCard;

import java.util.List;

public class PacketFromClient implements IPacket {
    private List<AbstractCard> remainingCards;
    private List<AbstractCard> chosenClientCards;
    //boolean powerDown;

    public PacketFromClient(List<AbstractCard> chosenCards, List<AbstractCard> remainingCards){
        this.chosenClientCards = chosenCards;
        this.remainingCards = remainingCards;
    }

    public List<AbstractCard> getRemainingCards() {
        return remainingCards;
    }

    public void setRemainingCards(List<AbstractCard> remainingCards) {
        this.remainingCards = remainingCards;
    }

    public List<AbstractCard> getChosenClientCards() {
        return chosenClientCards;
    }

    public void setChosenClientCards(List<AbstractCard> chosenClientCards) {
        this.chosenClientCards = chosenClientCards;
    }

    @Override
    public boolean isEmpty() {
        return remainingCards == null && chosenClientCards == null;
    }

    @Override
    public boolean isFull() { return remainingCards != null && chosenClientCards != null; }
}
