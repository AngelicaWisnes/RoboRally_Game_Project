package inf112.skeleton.app;

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
}
