package inf112.skeleton.app.Network;

import inf112.skeleton.app.Card.AbstractCard;

import java.io.Serializable;
import java.util.List;

public class PacketFromHost extends AbstractPacket {
    private List<AbstractCard> cardsToClient;
    private List<AbstractCard> chosenHostCards;
    //boolean powerDown;

    public PacketFromHost(List<AbstractCard> cardsToClient, List<AbstractCard> chosenCards) {

    }

    public List<AbstractCard> getCardsToClient() {
        return cardsToClient;
    }

    public List<AbstractCard> getChosenHostCards() {
        return chosenHostCards;
    }
}
