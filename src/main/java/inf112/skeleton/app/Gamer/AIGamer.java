package inf112.skeleton.app.Gamer;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.ArrayList;
import java.util.List;

public class AIGamer extends AbstractGamer {

    public AIGamer(TiledMap map, String name, int playerNumber) {
        super(map, name, playerNumber);

    }
}
