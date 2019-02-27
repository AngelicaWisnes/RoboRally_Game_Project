package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Board;
import inf112.skeleton.app.Card.*;
import inf112.skeleton.app.Robot.*;

import java.util.ArrayList;

public class ProgramSheet {
    private iRobot robot;
    private int damage;
    //Checkpoint checkpoint;
    private int lives;
    private boolean powerDown;
    private ArrayList<Card> cards;
    private Slot slot1 = new Slot();
    private Slot slot2 = new Slot();
    private Slot slot3 = new Slot();
    private Slot slot4 = new Slot();
    private Slot slot5 = new Slot();
    private Slot[] slots =  {slot1, slot2, slot3, slot4, slot5};

    public ProgramSheet(int playerN, Board board, TiledMap map){
        robot = new Robot(playerN, board, map);
        this.damage = 0;
        this.lives = 3;
        this.powerDown = false;

        ArrayList<Card> tempCards = CardGenerator.getNewCardStack();
        this.slot1.setCard(tempCards.get(0));
        this.slot2.setCard(tempCards.get(1));
        this.slot3.setCard(tempCards.get(2));
        this.slot4.setCard(tempCards.get(3));
        this.slot5.setCard(tempCards.get(4));
    }

    public void receiveCards(ArrayList<Card> cards){
        this.cards = cards;
    }

    public Slot placeCard(Card card){
        if (slot1.isAvailable()){
            slot1.setCard(card);
        }else if (slot2.isAvailable()){
            slot2.setCard(card);
        }else if (slot3.isAvailable()){
            slot3.setCard(card);
        }else if (slot4.isAvailable()){
            slot4.setCard(card);
        }else if (slot5.isAvailable()){
            slot5.setCard(card);
        }
        return null;
    }

    public void clearUnlockedSlots(){
        slot1.returnCard();
        slot2.returnCard();
        slot3.returnCard();
        slot4.returnCard();
        slot5.returnCard();
    }

    public int getDamage() {
        return damage;
    }

    public int getLives() {
        return lives;
    }

    public boolean isPowerDown() {
        return powerDown;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Slot getSlot1() {
        return slot1;
    }

    public Slot getSlot2() {
        return slot2;
    }

    public Slot getSlot3() {
        return slot3;
    }

    public Slot getSlot4() {
        return slot4;
    }

    public Slot getSlot5() {
        return slot5;
    }

    public Slot getSlot(int n) { return slots[n]; }

}
