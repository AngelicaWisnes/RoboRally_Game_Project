package inf112.skeleton.app.Network;

import inf112.skeleton.app.Card.AbstractCard;

import java.io.Serializable;
import java.util.List;

public class PacketFromClient implements Serializable {
    private List<AbstractCard> cardsToClient;
    private List<AbstractCard> remainingCards;
    private List<AbstractCard> chosenCards;
    //boolean powerDown;

    public PacketFromClient(boolean isHost, List<AbstractCard> list1, List<AbstractCard> list2) {
        if (isHost){
            PacketFromHost(list1, list2);
        } else {
            PacketFromClient(list1, list2);
        }
    }
    private void PacketFromHost(List<AbstractCard> cardsToClient, List<AbstractCard> chosenCards){
        this.chosenCards = chosenCards;
        this.cardsToClient = cardsToClient;
    }

    private void PacketFromClient(List<AbstractCard> chosenCards, List<AbstractCard> remainingCards){
        this.chosenCards = chosenCards;
        this.remainingCards = remainingCards;
    }

    public List<AbstractCard> getCardsToClient() {
        return cardsToClient;
    }

    public List<AbstractCard> getRemainingCards() {
        return remainingCards;
    }

    public List<AbstractCard> getChosenCards() {
        return chosenCards;
    }
}
