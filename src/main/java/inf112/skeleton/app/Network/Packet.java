package inf112.skeleton.app.Network;

import inf112.skeleton.app.Card.AbstractCard;

import java.io.Serializable;
import java.util.List;

public class Packet implements Serializable {
    public List<AbstractCard> getCardsToClient() {
        return cardsToClient;
    }

    List<AbstractCard> cardsToClient;
    //ArrayList<AbstractCard> hostCards;
    //boolean powerDown;

    Packet(List<AbstractCard> cardsOnHand) {
        cardsToClient = cardsOnHand;
        //hostCards = new ArrayList<>();
        //powerDown = false;
    }

}
