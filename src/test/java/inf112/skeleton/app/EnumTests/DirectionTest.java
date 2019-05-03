package inf112.skeleton.app.EnumTests;
import inf112.skeleton.app.Enums.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void oppositeOfLeftReturnsRight() {
        Direction direction = Direction.LEFT;
        Direction newDirection = direction.opposite();
        assertEquals(Direction.RIGHT, newDirection);
    }

    @Test
    public void oppositeOfUpReturnsDown() {
        Direction direction = Direction.UP;
        Direction newDirection = direction.opposite();
        assertEquals(Direction.DOWN, newDirection);
    }

    @Test
    public void clockwiseOfLeftReturnsUp() {
        Direction direction = Direction.LEFT;
        Direction newDirection = direction.clockwise();
        assertEquals(Direction.UP, newDirection);
    }

    @Test
    public void clockwiseOfUpReturnsRight() {
        Direction direction = Direction.UP;
        Direction newDirection = direction.clockwise();
        assertEquals(Direction.RIGHT, newDirection);
    }

    @Test
    public void clockwiseOfRightReturnsDown() {
        Direction direction = Direction.RIGHT;
        Direction newDirection = direction.clockwise();
        assertEquals(Direction.DOWN, newDirection);
    }

    @Test
    public void clockwiseOfDownReturnsLeft() {
        Direction direction = Direction.DOWN;
        Direction newDirection = direction.clockwise();
        assertEquals(Direction.LEFT, newDirection);
    }

    @Test
    public void counterClockwiseOfDownReturnsRight() {
        Direction direction = Direction.DOWN;
        Direction newDirection = direction.counterClockwise();
        assertEquals(Direction.RIGHT, newDirection);
    }

    @Test
    public void counterClockwiseOfRightReturnsUp() {
        Direction direction = Direction.RIGHT;
        Direction newDirection = direction.counterClockwise();
        assertEquals(Direction.UP, newDirection);
    }

    @Test
    public void counterClockwiseOfUpReturnsLeft() {
        Direction direction = Direction.UP;
        Direction newDirection = direction.counterClockwise();
        assertEquals(Direction.LEFT, newDirection);
    }

    @Test
    public void counterClockwiseOfLeftReturnsDown() {
        Direction direction = Direction.LEFT;
        Direction newDirection = direction.counterClockwise();
        assertEquals(Direction.DOWN, newDirection);
    }
}
