package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;


import java.util.ArrayList;
import java.util.List;

public class Gamer {

    private TiledMap map;
    private ProgramSheet sheet;
    private String name;

    List<AbstractCard> cardsOnHand;


    public Gamer(TiledMap map, String name) {
        this.map = map;
        this.name = name;
        sheet = new ProgramSheet(map);
    }

    public void setCards(List<AbstractCard> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    public void resetCards(){cardsOnHand = new ArrayList<>();}

    public List<AbstractCard> getCards() {
        return this.cardsOnHand;
    }

    public ProgramSheet getSheet() {
        return sheet;
    }
}
