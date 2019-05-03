package inf112.skeleton.app.Gamer;

import com.badlogic.gdx.maps.tiled.TiledMap;

import java.util.ArrayList;

public class NetworkHostGamer extends AbstractGamer{
    public NetworkHostGamer(TiledMap map, String name, int playerNumber, ArrayList<IGamer> gamers) {
        super(map, name, playerNumber, gamers);
    }

}
