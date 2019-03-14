package inf112.skeleton.app.ProgramSheet;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.MoveForward;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ProgramSheetTest {

    private Slot slot;

    @Before
    public void initialize() {
        slot = new Slot();
    }

    @Test
    public void receiveCards() {

    }

    @Test
    public void placeCard() {
        if (slot.isAvailable()) {
            slot.setCard(new MoveForward(450,1));
        }
    }

    @Test
    public void clearUnlockedSlots() {
        slot.returnCard();
        
    }
}