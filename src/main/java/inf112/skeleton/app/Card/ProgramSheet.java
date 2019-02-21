package inf112.skeleton.app.Card;

import inf112.skeleton.app.Board;
import inf112.skeleton.app.Robot.*;

import java.util.ArrayList;

public class ProgramSheet {
    private iRobot robot;
    private int damage;
    //Checkpoint checkpoint;
    private int lives;
    private ArrayList<Card> cards;
    private Slot slot1;
    private Slot slot2;
    private Slot slot3;
    private Slot slot4;
    private Slot slot5;

    public ProgramSheet(int playerN, Board board){
        robot = new Robot(playerN, board);
        this.damage = 0;
        this.lives = 3;
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
}
