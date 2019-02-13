package inf112.skeleton.app;

import java.util.Random;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.TileTypes.AbstractTile;
import inf112.skeleton.app.TileTypes.*;


public class Board {
    private int BOARDSIZE_X, BOARDSIZE_Y;
    private iTile[][] boardList;


    public Board(int boardSize) {
        this.BOARDSIZE_X = boardSize;
        this.BOARDSIZE_Y = boardSize;
        boardList = new AbstractTile[BOARDSIZE_X][BOARDSIZE_Y];
        populateTileBoard();
    }

    public iTile getTile(int x, int y) {
        return boardList[x][y];
    }

    public int getBOARDSIZE_X() {
        return BOARDSIZE_X;
    }

    public int getBOARDSIZE_Y() {
        return BOARDSIZE_Y;
    }

    private void populateTileBoard() {
        Random r = new Random();
        for (int i = 0; i < BOARDSIZE_X; i++) {
            for (int j = 0; j < BOARDSIZE_Y; j++) {
                int random = r.nextInt(30);
                if (random == 0) {
                    boardList[i][j] = new SingleConveyor(Direction.UP);
                } else if (random == 1) {
                    boardList[i][j] = new SingleConveyor(Direction.DOWN);
                } else if (random == 2) {
                    boardList[i][j] = new SingleConveyor(Direction.LEFT);
                } else if (random == 3) {
                    boardList[i][j] = new SingleConveyor(Direction.RIGHT);
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
                    boardList[i][j] = new Rotator(Rotation.TURN_CLOCKWISE);
                } else if (random == 10) {
                    boardList[i][j] = new Rotator(Rotation.TURN_COUNTER_CLOCKWISE);
                } else if (random == 11) {
                    boardList[i][j] = new Flag();
                } else if (random > 11){
                    boardList[i][j] = new Floor();
                }
            }
        }
    }


    //TODO: board based on input
    private void populateBoard(String input) {

    }


}
