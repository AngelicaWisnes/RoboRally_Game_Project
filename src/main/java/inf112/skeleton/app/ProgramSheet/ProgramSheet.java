package inf112.skeleton.app.ProgramSheet;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.*;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Robot.*;

public class ProgramSheet {
    private IRobot robot;
    private boolean powerDown;
    private Slot slot1 = new Slot();
    private Slot slot2 = new Slot();
    private Slot slot3 = new Slot();
    private Slot slot4 = new Slot();
    private Slot slot5 = new Slot();
    private Slot[] slots = {slot1, slot2, slot3, slot4, slot5};

    public ProgramSheet(TiledMap map) {
        robot = new Robot(new Position(0, 0), Direction.UP, map);
        powerDown = false;

    }

    public IRobot getRobot() {
        return this.robot;
    }

    public int getDamage() {
        return this.robot.getDamage();
    }


    public Slot placeCard(AbstractCard card) {
        if (slot1.isAvailable()) {
            slot1.setCard(card);
        } else if (slot2.isAvailable()) {
            slot2.setCard(card);
        } else if (slot3.isAvailable()) {
            slot3.setCard(card);
        } else if (slot4.isAvailable()) {
            slot4.setCard(card);
        } else if (slot5.isAvailable()) {
            slot5.setCard(card);
        }
        return null;
    }
    public void removeLastCard(){
        if (!slot5.isAvailable()){
            slot5.removeCard();
        } else if (!slot4.isAvailable()){
            slot4.removeCard();
        } else if (!slot3.isAvailable()){
            slot3.removeCard();
        } else if (!slot2.isAvailable()){
            slot2.removeCard();
        } else if (!slot1.isAvailable()){
            slot1.removeCard();
        }
    }

    public void clearUnlockedSlots() {
        slot1.returnCard();
        slot2.returnCard();
        slot3.returnCard();
        slot4.returnCard();
        slot5.returnCard();
    }


    public int getLives() {
        return this.robot.getLives();
    }

    public boolean isPowerDown() {
        return powerDown;
    }

    public boolean allSlotsAreFilled() {
        return !slot1.isAvailable() && !slot2.isAvailable() && !slot3.isAvailable() && !slot4.isAvailable() && !slot5.isAvailable();
    }

    public Slot getSlot(int n) {
        return slots[n];
    }

}
