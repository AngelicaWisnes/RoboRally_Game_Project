package inf112.skeleton.app.ProgramSheet;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.*;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Gamer;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Robot.*;

import java.util.ArrayList;
import java.util.Collections;

public class ProgramSheet {
    private IRobot robot;
    private boolean powerDown;
    private Slot slot1 = new Slot();
    private Slot slot2 = new Slot();
    private Slot slot3 = new Slot();
    private Slot slot4 = new Slot();
    private Slot slot5 = new Slot();
    private Slot[] slots = {slot1, slot2, slot3, slot4, slot5};
    private int lives;
    private int damage;

    private int lastVisitedFlag;
    private final int MAX_DAMAGE = 10;

    public int getLastVisitedFlag() {
        return lastVisitedFlag;
    }

    public void setLastVisitedFlag(int lastVisitedFlag) {
        this.lastVisitedFlag = lastVisitedFlag;
    }

    public ProgramSheet(TiledMap map, int playerNumber) {
        if (playerNumber == 1){
            robot = new Robot(new Position(0, 0), Direction.RIGHT, map, this);
        } else { //TODO fix starting positions
            robot = new Robot(new Position(0, 64*5), Direction.UP, map, this);
        }
        powerDown = false;
        lives = 3;
        damage = lastVisitedFlag = 0;
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

    public void removeLastCard() {
        if (!slot5.isAvailable()) {
            slot5.removeCard();
        } else if (!slot4.isAvailable()) {
            slot4.removeCard();
        } else if (!slot3.isAvailable()) {
            slot3.removeCard();
        } else if (!slot2.isAvailable()) {
            slot2.removeCard();
        } else if (!slot1.isAvailable()) {
            slot1.removeCard();
        }
    }

    public ArrayList<AbstractCard> clearUnlockedSlots() {
        ArrayList<AbstractCard> usedCards = new ArrayList<>();
        usedCards.add(slot1.returnCard());
        usedCards.add(slot2.returnCard());
        usedCards.add(slot3.returnCard());
        usedCards.add(slot4.returnCard());
        usedCards.add(slot5.returnCard());
        usedCards.removeAll(Collections.singletonList(null));
        return usedCards;
    }

    public IRobot getRobot() {
        return robot;
    }

    public void setRobot(IRobot robot) {
        this.robot = robot;
    }

    public int getLives() {
        return lives;
    }

    public int removeLife() {
        return --lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getDamage() {
        return damage;
    }

    public int resetDamage() {
        return damage = 0;
    }

    public boolean fatallyInjured() {

        return damage >= MAX_DAMAGE;
    }

    public int damageRobot() {
        damage++;
        if (fatallyInjured()) {
            robot.killRobot();
        }
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }


    public void repair(int repairQty) {
        setDamage(damage - repairQty < 0 ? 0 : damage - repairQty);
    }


    public boolean isPowerDown() {
        return powerDown;
    }

    public boolean setPowerDown(boolean p) {
        return powerDown = p;
    }

    public boolean allSlotsAreFilled() {
        return !slot1.isAvailable() && !slot2.isAvailable() && !slot3.isAvailable()
                && !slot4.isAvailable() && !slot5.isAvailable();
    }

    public Slot getSlot(int n) {
        return slots[n];
    }

}
