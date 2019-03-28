package inf112.skeleton.app.ProgramSheet;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.MoveForward;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ProgramSheetTest {
    private ProgramSheet sheet;
    private Slot slot;

    @Before
    public void initialize() {
        sheet = new ProgramSheet(null);
        slot = new Slot();
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

    @Test
    public void updateFlag(){
        int currentFlag = sheet.getLastVisitedFlag();
        sheet.setLastVisitedFlag(currentFlag+1);
        int newFlag = sheet.getLastVisitedFlag();
        assertEquals(currentFlag,newFlag-1);
    }

    @Test
    public void damageTest(){
        int damage = sheet.getDamage();
        sheet.setDamage(damage-1);
        assertEquals(damage - 1, sheet.getDamage());
    }

    @Test
    public void lifeTest(){
        int lives = sheet.getLives();
        sheet.removeLife();
        assertEquals(lives-1, sheet.getLives());
    }
}