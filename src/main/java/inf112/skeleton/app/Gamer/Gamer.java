package inf112.skeleton.app.Gamer;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;


import java.util.ArrayList;
import java.util.List;

public class Gamer extends AbstractGamer {

    public Gamer(TiledMap map, String name, int playerNumber, ArrayList<IGamer> gamers) {
        super(map, name, playerNumber, gamers);

    }
}
