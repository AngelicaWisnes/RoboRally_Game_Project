package inf112.skeleton.app.Network;

import inf112.skeleton.app.Card.AbstractCard;

import java.util.List;

public class PacketFromHost implements IPacket {
    private List<AbstractCard> cardsToClient;
    private List<AbstractCard> chosenHostCards;
    //boolean powerDown;

    public PacketFromHost(List<AbstractCard> cardsToClient, List<AbstractCard> chosenCards) {

    }

    @Override
    public boolean isEmpty(){
        return cardsToClient == null && chosenHostCards == null;
    }

    public List<AbstractCard> getCardsToClient() {
        return cardsToClient;
    }

    public void setCardsToClient(List<AbstractCard> cardsToClient) {
        this.cardsToClient = cardsToClient;
    }

    public List<AbstractCard> getChosenHostCards() {
        return chosenHostCards;
    }

    public void setChosenHostCards(List<AbstractCard> chosenHostCards) {
        this.chosenHostCards = chosenHostCards;
    }
}
