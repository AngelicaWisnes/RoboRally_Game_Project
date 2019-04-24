package inf112.skeleton.app.ProgramSheet;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.*;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Robot.*;

import java.util.ArrayList;
import java.util.Collections;

public class ProgramSheet {
    private IRobot robot;
    private boolean powerDown;
    private Slot[] slots;
    private int lives;
    private int damage;

    private int lastVisitedFlag;
    private final int MAX_DAMAGE = 10;


    public ProgramSheet(TiledMap map, int playerNumber) {
        slots = new Slot[]{new Slot(), new Slot(), new Slot(), new Slot(), new Slot()};

        if (playerNumber == 1) {
            robot = new Robot(new Position(0, 0), Direction.RIGHT, map, this);
        } else { //TODO fix starting positions
            robot = new Robot(new Position(0, 64 * 5), Direction.UP, map, this);
        }
        powerDown = false;
        lives = 3;
        damage = lastVisitedFlag = 0;
    }

    public void placeCardInSlot(AbstractCard card) {
        for (Slot s : slots) {
            if (s.isAvailable()) {
                s.setCard(card);
                break;
            }
        }
    }

    public void returnCardToHandFromSlot() {
        for (int i = 4; i >= 0; i--) {
            if (!slots[i].isAvailable()) {
                slots[i].removeCard();
                break;
            }
        }
    }

    public ArrayList<AbstractCard> clearUnlockedSlots() {
        ArrayList<AbstractCard> usedCards = new ArrayList<>();
        for (Slot s : slots) usedCards.add(s.returnCard());
        usedCards.removeAll(Collections.singletonList(null));
        return usedCards;
    }

    public IRobot getRobot() { return robot; }

    public void setRobot(IRobot robot) { this.robot = robot; }

    public int getLives() { return lives; }

    public void removeLife() { --lives; }

    public void setLives(int lives) { this.lives = lives; }

    public int getDamage() { return damage; }

    public void resetDamage() { damage = 0; }

    public boolean fatallyInjured() { return damage >= MAX_DAMAGE; }

    public void damageRobot() {
        damage++;
        if (fatallyInjured()) robot.killRobot();
    }

    public void setDamage(int damage) { this.damage = damage; }

    public void repair(int repairQty) { setDamage(damage - repairQty < 0 ? 0 : damage - repairQty); }

    public boolean isPowerDown() { return powerDown; }

    public void setPowerDown(boolean p) { powerDown = p; }

    public boolean allSlotsAreFilled() {
        for (Slot s : slots) if (s.isAvailable()) return false;
        return true;
    }

    public Slot getSlot(int n) { return slots[n]; }

    public int getLastVisitedFlag() { return lastVisitedFlag; }

    public void setLastVisitedFlag(int lastVisitedFlag) { this.lastVisitedFlag = lastVisitedFlag; }

}
