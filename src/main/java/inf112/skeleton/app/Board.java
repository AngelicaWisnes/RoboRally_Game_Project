package inf112.skeleton.app;

import java.util.Random;

import inf112.skeleton.app.TileTypes.Tile;
import inf112.skeleton.app.TileTypes.*;


public class Board {
    private int BOARDSIZE_X, BOARDSIZE_Y;
    private Tile[][] boardList;


    public Board(int boardSize) {
        this.BOARDSIZE_X = boardSize;
        this.BOARDSIZE_Y = boardSize;
        boardList = new Tile[BOARDSIZE_X][BOARDSIZE_Y];
        populateTileBoard();
    }

    public Tile getTile(int x, int y) {
        return boardList[x][y];
    }

    public int getBOARDSIZE_X() {
        return BOARDSIZE_X;
    }

    public int getBOARDSIZE_Y() {
        return BOARDSIZE_Y;
    }

    //TODO create standard Tile board
    private void populateTileBoard() {
        Random r = new Random();
        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {
                int random = r.nextInt(30);
                if (random == 0) {
                    boardList[i][j] = new Conveyor(Direction.UP);
                } else if (random == 1) {
                    boardList[i][j] = new Conveyor(Direction.DOWN);
                } else if (random == 2) {
                    boardList[i][j] = new Conveyor(Direction.LEFT);
                } else if (random == 3) {
                    boardList[i][j] = new Conveyor(Direction.RIGHT);
                } else if (random == 4) {
                    boardList[i][j] = new DblConveyor(Direction.UP);
                } else if (random == 5) {
                    boardList[i][j] = new DblConveyor(Direction.DOWN);
                } else if (random == 6) {
                    boardList[i][j] = new DblConveyor(Direction.LEFT);
                } else if (random == 7) {
                    boardList[i][j] = new DblConveyor(Direction.RIGHT);
                } else if (random == 8) {
                    boardList[i][j] = new Pit();
                } else if (random == 9) {
                    boardList[i][j] = new Rotator(Rotation.CW);
                } else if (random == 10) {
                    boardList[i][j] = new Rotator(Rotation.CCW);
                } else if (random > 10){
                    boardList[i][j] = new Floor();
                }
            }
        }
    }


    //board based on input
    private void populateBoard(String input) {

    }


}
