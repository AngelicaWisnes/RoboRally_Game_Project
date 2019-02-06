package inf112.skeleton.app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTests {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void checkBoardSize() {
        Board board = new Board(5);
        int counter = 0;
        for (int i = 0; i < board.getBOARDSIZE_X(); i++){
            for (int j = 0; j < board.getBOARDSIZE_Y(); j++){
                counter ++;
            }
        }
        assertEquals(5*5, counter);
    }
}
