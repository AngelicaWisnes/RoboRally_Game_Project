package inf112.skeleton.app.Gamer;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Network.NetworkHandler;

import java.util.ArrayList;
import java.util.List;

public class NetworkGamer extends AbstractGamer {
    public NetworkGamer(TiledMap map, String name, int playerNumber, ArrayList<IGamer> gamers) {
        super(map, name, playerNumber, gamers);
    }

    @Override
    public void setCards(List<AbstractCard> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
        NetworkHandler networkHandler = new NetworkHandler();
        networkHandler.sendToClient(this.cardsOnHand);
    }




}
