package inf112.skeleton.app;

import inf112.skeleton.app.Robot.*;

public class ProgramSheet {
    private iRobot robot;
    private int damage;
    //Checkpoint checkpoint;
    private int lives;

    public ProgramSheet(int playerN, Board board){
        robot = new Robot(playerN, board);
    }
}
