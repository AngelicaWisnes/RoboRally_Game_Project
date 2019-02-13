package inf112.skeleton.app;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Robot.AbstractRobot;
import inf112.skeleton.app.Robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AbstractRobotTest {

    @Test
    public void rotatingClockwiseFromRightShouldReturnDown() {
        Position pos = new Position(5,5);
        Direction dir = Direction.RIGHT;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_CLOCKWISE), Direction.DOWN);
    }

    @Test
    public void rotatingClockwiseFromDownShouldReturnLeft() {
        Position pos = new Position(5,5);
        Direction dir = Direction.DOWN;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_CLOCKWISE), Direction.LEFT);
    }

    @Test
    public void rotatingClockwiseFromLeftShouldReturnUp() {
        Position pos = new Position(5,5);
        Direction dir = Direction.LEFT;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_CLOCKWISE), Direction.UP);
    }

    @Test
    public void rotatingClockwiseFromUpShouldReturnRight() {
        Position pos = new Position(5,5);
        Direction dir = Direction.UP;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_CLOCKWISE), Direction.RIGHT);
    }

    @Test
    public void rotatingCounterclockwiseFromRightShouldReturnUp() {
        Position pos = new Position(5,5);
        Direction dir = Direction.RIGHT;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_COUNTER_CLOCKWISE), Direction.UP);
    }

    @Test
    public void rotatingCounterclockwiseFromDownShouldReturnRight() {
        Position pos = new Position(5,5);
        Direction dir = Direction.DOWN;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_COUNTER_CLOCKWISE), Direction.RIGHT);
    }

    @Test
    public void rotatingCounterclockwiseFromLeftShouldReturnDown() {
        Position pos = new Position(5,5);
        Direction dir = Direction.LEFT;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_COUNTER_CLOCKWISE), Direction.DOWN);
    }

    @Test
    public void rotatingCounterclockwiseFromUpShouldReturnLeft() {
        Position pos = new Position(5,5);
        Direction dir = Direction.UP;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_COUNTER_CLOCKWISE), Direction.LEFT);
    }

    @Test
    public void rotatingAroundFromUpShouldReturnDown() {
        Position pos = new Position(5,5);
        Direction dir = Direction.UP;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_AROUND), Direction.DOWN);
    }

    @Test
    public void rotatingAroundFromRightShouldReturnLeft() {
        Position pos = new Position(5,5);
        Direction dir = Direction.RIGHT;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_AROUND), Direction.LEFT);
    }

    @Test
    public void rotatingAroundFromDownShouldReturnUp() {
        Position pos = new Position(5,5);
        Direction dir = Direction.DOWN;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_AROUND), Direction.UP);
    }

    @Test
    public void rotatingAroundFromLeftShouldReturnRight() {
        Position pos = new Position(5,5);
        Direction dir = Direction.LEFT;
        AbstractRobot robot = new Robot(pos, dir);

        assertEquals(robot.rotate(Rotation.TURN_AROUND), Direction.RIGHT);
    }

}
