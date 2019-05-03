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
    public void getNeighbourOneStepUpTest(){
        Position position = new Position(1, 1);
        Position neighbour = position.getNeighbour(Direction.UP, 1);
        assertEquals(position.getY() + 1, neighbour.getY());
    }

    @Test
    public void getNeighbourTwoStepsUpTest(){
        Position position = new Position(1, 1);
        Position neighbour = position.getNeighbour(Direction.UP, 2);
        assertEquals(position.getY() + 2, neighbour.getY());
    }

    @Test
    public void getNeighbourThreeStepsUpTest(){
        Position position = new Position(1, 1);
        Position neighbour = position.getNeighbour(Direction.UP, 3);
        assertEquals(position.getY() + 3, neighbour.getY());
    }

    @Test
    public void getNeighbourOneStepRightTest(){
        Position position = new Position(1, 1);
        Position neighbour = position.getNeighbour(Direction.RIGHT, 1);
        assertEquals(position.getX() + 1, neighbour.getX());
    }

    @Test
    public void getNeighbourTwoStepsRightTest(){
        Position position = new Position(1, 1);
        Position neighbour = position.getNeighbour(Direction.RIGHT, 2);
        assertEquals(position.getX() + 2, neighbour.getX());
    }

    @Test
    public void getNeighbourThreeStepsRightTest(){
        Position position = new Position(1, 1);
        Position neighbour = position.getNeighbour(Direction.RIGHT, 3);
        assertEquals(position.getX() + 3, neighbour.getX());
    }

    @Test
    public void getNeighbourOneStepLeftTest(){
        Position position = new Position(5, 5);
        Position neighbour = position.getNeighbour(Direction.LEFT, 1);
        assertEquals(position.getX() -1, neighbour.getX());
    }

    @Test
    public void getNeighbourTwoStepsLeftTest(){
        Position position = new Position(5, 5);
        Position neighbour = position.getNeighbour(Direction.LEFT, 2);
        assertEquals(position.getX() -2, neighbour.getX());
    }

    @Test
    public void getNeighbourThreeStepsLeftTest(){
        Position position = new Position(5, 5);
        Position neighbour = position.getNeighbour(Direction.LEFT, 3);
        assertEquals(position.getX() -3, neighbour.getX());
    }

    @Test
    public void getNeighbourOneStepDownTest(){
        Position position = new Position(5, 5);
        Position neighbour = position.getNeighbour(Direction.DOWN, 1);
        assertEquals(position.getY() -1, neighbour.getY());
    }

    @Test
    public void getNeighbourTwoStepsDownTest(){
        Position position = new Position(5, 5);
        Position neighbour = position.getNeighbour(Direction.DOWN, 2);
        assertEquals(position.getY() -2, neighbour.getY());
    }

    @Test
    public void getNeighbourThreeStepsDownTest(){
        Position position = new Position(5, 5);
        Position neighbour = position.getNeighbour(Direction.DOWN, 3);
        assertEquals(position.getY() -3, neighbour.getY());
    }
}
