package inf112.skeleton.app.ProgramSheet;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.*;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Gamer.IGamer;
import inf112.skeleton.app.Robot.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static inf112.skeleton.app.Helpers.Constants.START_POSITION;

public class ProgramSheet {
    private IRobot robot;
    private boolean powerDown;
    private Slot[] slots;
    private int lives;
    private int damage;

    private int lastVisitedFlag;
    private final int MAX_DAMAGE = 10;


    public ProgramSheet(TiledMap map, int playerNumber, ArrayList<IGamer> gamers) {
        slots = new Slot[]{new Slot(), new Slot(), new Slot(), new Slot(), new Slot()};

        robot = new Robot(START_POSITION.get(playerNumber), Direction.RIGHT, map, this, gamers);

        powerDown = false;
        lives = 3;
        damage = lastVisitedFlag = 0;
    }

    public boolean placeCardInSlot(AbstractCard card) {
        for (Slot s : slots) {
            if (s.isAvailable()) {
                s.setCard(card);
                return true;
            }
        }
        return false;
    }

    public void returnLastCardToHandFromSlot() {
        for (int i = 4; i >= 0; i--) {
            if (!slots[i].isAvailable()) {
                slots[i].removeCard();
                break;
            }
        }
    }

    public ArrayList<AbstractCard> clearUnlockedSlots() {
        ArrayList<AbstractCard> usedCards = new ArrayList<>();
        for (Slot s : slots) {
            usedCards.add(s.returnCard());
        }
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

    public void removeLife() {
        --lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getDamage() {
        return damage;
    }

    public void resetDamage() {
        damage = 0;
        updateSlots();
    }

    public boolean fatallyInjured() {
        return damage >= MAX_DAMAGE;
    }

    public void damageRobot() {
        damage++;
        updateSlots();
        if (fatallyInjured()) {
            robot.killRobot();
        }
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void repair(int repairQty) {
        setDamage(damage - repairQty < 0 ? 0 : damage - repairQty);
        updateSlots();
    }

    public boolean isPowerDown() {
        return powerDown;
    }

    public void setPowerDown(boolean p) {
        powerDown = p;
    }

    public boolean allSlotsAreFilled() {
        for (Slot s : slots) {
            if (s.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    public Slot getSlot(int n) {
        return slots[n];
    }

    public List<AbstractCard> getChosenCardsFromSlots(){
        List<AbstractCard> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            cards.add(getSlot(0).getCard());
        }
        return cards;
    }

    public int getLastVisitedFlag() {
        return lastVisitedFlag;
    }

    public void setLastVisitedFlag(int lastVisitedFlag) {
        this.lastVisitedFlag = lastVisitedFlag;
    }

    private void updateSlots() {
        if (damage > 4 && damage < 10) {
            setLocks(damage - 4);
        } else {
            setLocks(0);
        }
    }

    private void setLocks(int n) {
        for (int i = 4; i > (4 - n); i--) {
            getSlot(i).lockSlot();
        }
        for (int j = (4 - n); j >= 0; j--) {
            getSlot(j).unlockSlot();
        }

    }
}
