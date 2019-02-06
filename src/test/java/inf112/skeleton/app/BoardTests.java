package inf112.skeleton.app;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BoardTests {

    @Test
    public void checkBoardSize() {
        Board board = new Board(5);
        int counter = 0;
        for (int i = 0; i < board.getBOARDSIZE_X(); i++){
            for (int j = 0; j < board.getBOARDSIZE_Y(); j++){
                counter++;
            }
        }
        assertEquals(25, counter);
    }

    
}
