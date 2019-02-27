package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Robot.iRobot;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class Gamer {

    private TiledMap map;
    private ProgramSheet sheet;
    private String name;

    ArrayList<Card> cardsOnHand = new ArrayList<>();


    public Gamer(TiledMap map, String name) {
        this.map = map;
        this.name = name;
        //this.sheet = new ProgramSheet()
    }


}
