package inf112.skeleton.app.ProgramSheet;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.MoveForward;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramSheetTest {

    @Test
    public void receiveCards() {
    }

    @Test
    public void placeCard() {
        Slot slot = new Slot();
        if (slot.isAvailable()) {
            slot.setCard(new MoveForward(450,1));
        }

    }

    @Test
    public void clearUnlockedSlots() {

    }

    @Test
    public void isPowerDown() {

    }

}