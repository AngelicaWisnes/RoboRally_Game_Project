package inf112.skeleton.app.Network;

import inf112.skeleton.app.Card.AbstractCard;

import java.io.Serializable;
import java.util.List;

public class PacketFromClient extends AbstractPacket {
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

    public List<AbstractCard> getChosenClientCards() {
        return chosenClientCards;
    }
}
