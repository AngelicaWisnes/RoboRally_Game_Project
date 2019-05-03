package inf112.skeleton.app.Gamer;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Network.NetworkHandler;

import java.util.ArrayList;
import java.util.List;

public class ExternalClientGamer extends AbstractGamer {
    private NetworkHandler networkHandler;
    public ExternalClientGamer(TiledMap map, String name, int playerNumber, ArrayList<IGamer> gamers, NetworkHandler networkHandler) {
        super(map, name, playerNumber, gamers);
        this.networkHandler = networkHandler;
    }

    @Override
    public void setCards(List<AbstractCard> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
        networkHandler.sendPacket(this.cardsOnHand);
    }

    public NetworkHandler getNetworkHandler() {
        return networkHandler;
    }
}
