package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Robot.iRobot;


import java.util.ArrayList;

public class Gamer {

    private TiledMap map;
    private ProgramSheet sheet;
    private String name;

    ArrayList<Card> cardsOnHand = new ArrayList<>();


    public Gamer(TiledMap map, String name) {
        this.map = map;
        this.name = name;
        sheet = new ProgramSheet(1, new Board(0), map);
    }

    public void setCards(ArrayList<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }


}
