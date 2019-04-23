package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;


import java.util.ArrayList;
import java.util.List;

public class Gamer implements IGamer{

    private TiledMap map;
    private ProgramSheet sheet;
    private String name;
    private int playerNumber;
    private List<AbstractCard> cardsOnHand;


    public Gamer(TiledMap map, String name, int playerNumber) {
        this.map = map;
        this.name = name;
        this.playerNumber = playerNumber;
        sheet = new ProgramSheet(map, playerNumber);
    }

    public void setCards(List<AbstractCard> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }{}

    public AbstractCard getCard(int i){return this.cardsOnHand.get(i);}

    public void resetCards(){cardsOnHand = new ArrayList<>();}

    public List<AbstractCard> getCards() {
        return this.cardsOnHand;
    }

    public ProgramSheet getSheet() {
        return sheet;
    }
    public TiledMap getMap(){
        return map;
    }
}
