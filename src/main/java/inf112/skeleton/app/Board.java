package inf112.skeleton.app;

import java.util.Random;

public class Board {
    private final int BOARDSIZE_X, BOARDSIZE_Y;
    private final int[][] boardList;
    //private final Tile[][] boardList = new Tile[BOARDSIZE_X][BOARDSIZE_Y];


    public Board(int boardSize){
        this.BOARDSIZE_X = boardSize;
        this.BOARDSIZE_Y = boardSize;
         boardList= new int[BOARDSIZE_X][BOARDSIZE_Y];
         populateBoard(BOARDSIZE_X, BOARDSIZE_Y);
    }

    public int getTile(int x, int y){
        return boardList[x][y];
    }

    public int getBOARDSIZE_X() {
        return BOARDSIZE_X;
    }

    public int getBOARDSIZE_Y() {
        return BOARDSIZE_Y;
    }
    //TODO create standard Tile board
    private void populateTileBoard(int boardsizex, int boardsizey){
        Random r = new Random();
        for (int i = 0; i < boardsizex; i++){
            for (int j = 0; j < boardsizey; j++){
                if (r.nextInt() == 0){
                    boardList[i][j] = new Repair();
                } else if (r.nextInt() == 1){
                    boardList[i][j] = new Conveyor();
                }
        }
    }

    //standard int board
    private void populateBoard(int boardsizex, int boardsizey) {
        Random r = new Random();
        for (int i = 0; i < boardsizex; i++){
            for (int j = 0; j < boardsizey; j++){
                boardList[i][j] = r.nextInt(5);
            }
        }
    }

    //board based on input
    private void populateBoard(String input){

    }


}
