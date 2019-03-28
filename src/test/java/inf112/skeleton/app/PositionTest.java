package inf112.skeleton.app;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Helpers.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void cloneTest(){
        Position position = new Position(1,1);
        Position newPosition = position.clone();
        assertEquals(position.getX(), newPosition.getX());
        assertEquals(position.getY(), newPosition.getY());
    }

    @Test
    public void getNeighbourTest(){
        Position position = new Position(1, 1);
        Position neighbour = position.getNeighbour(Direction.UP, 1);
        assertEquals(position.getY() + 1, neighbour.getY());
    }



}
