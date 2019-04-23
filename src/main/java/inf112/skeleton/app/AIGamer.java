package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.List;

public class AIGamer implements IGamer{
    private TiledMap map;
    private ProgramSheet sheet;
    private String name;
    private int playerNumber;

    private List<AbstractCard> cardsOnHand;

    public AIGamer(TiledMap map, String name, int playerNumber) {
        this.map = map;
        this.name = name;
        this.playerNumber = playerNumber;
        sheet = new ProgramSheet(map, playerNumber);
    }
    public ProgramSheet getSheet() {
        return sheet;
    }



}
