package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;


import java.util.ArrayList;
import java.util.List;

public class Gamer {

    private TiledMap map;
    private ProgramSheet sheet;
    private String name;

    List<Card> cardsOnHand;


    public Gamer(TiledMap map, String name) {
        this.map = map;
        this.name = name;
        sheet = new ProgramSheet(1, map);
    }

    public void setCards(List<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public ProgramSheet getSheet() {
        return sheet;
    }
}
