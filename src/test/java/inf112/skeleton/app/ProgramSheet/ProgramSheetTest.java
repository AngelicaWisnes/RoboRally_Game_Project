package inf112.skeleton.app.ProgramSheet;

import inf112.skeleton.app.Card.MoveForward;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProgramSheetTest {
    private ProgramSheet sheet;
    private Slot slot;

    @Before
    public void initialize() {
        sheet = new ProgramSheet(null, 1, null);
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
    public void damageTestOne(){
        int damage = sheet.getDamage();
        sheet.setDamage(damage-1);
        assertEquals(damage - 1, sheet.getDamage());
    }

    @Test
    public void damageTestThee(){
        int damage = sheet.getDamage();
        sheet.setDamage(damage-3);
        assertEquals(damage - 3, sheet.getDamage());
    }

    @Test
    public void damageTestFive(){
        int damage = sheet.getDamage();
        sheet.setDamage(damage-5);
        assertEquals(damage - 5, sheet.getDamage());
    }

    @Test
    public void damageTestSeven(){
        int damage = sheet.getDamage();
        sheet.setDamage(damage-7);
        assertEquals(damage - 7, sheet.getDamage());
    }

    @Test
    public void damageTestNine(){
        int damage = sheet.getDamage();
        sheet.setDamage(damage-9);
        assertEquals(damage - 9, sheet.getDamage());
    }

    @Test
    public void lifeTestOne(){
        int lives = sheet.getLives();
        sheet.removeLife();
        assertEquals(lives-1, sheet.getLives());
    }

    @Test
    public void lifeTestTwo(){
        int lives = sheet.getLives();
        sheet.removeLife();
        sheet.removeLife();
        assertEquals(lives-2, sheet.getLives());
    }

    @Test
    public void lifeTestThree(){
        int lives = sheet.getLives();
        sheet.removeLife();
        sheet.removeLife();
        sheet.removeLife();
        assertEquals(lives-3, sheet.getLives());
    }
}