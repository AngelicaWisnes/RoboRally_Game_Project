
package inf112.skeleton.app;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Assets.Dummy;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Robot.Robot;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * jUnit test for simple App.
 */

public class AbstractRobotTest {

    private static Position pos;
    private static Dummy dummy;

    @BeforeClass
    public static void setupDummy(){
        dummy = new Dummy();
    }

    @Before
    public void setupPosition(){
        pos = new Position(5,5);
    }


    @Test
    public void rotatingClockwiseFromRightShouldReturnDown() {
        dummy.setRobot(new Robot(pos, Direction.RIGHT, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_CLOCKWISE), Direction.DOWN);
    }

    @Test
    public void rotatingClockwiseFromDownShouldReturnLeft() {
        dummy.setRobot(new Robot(pos, Direction.DOWN, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_CLOCKWISE), Direction.LEFT);
    }

    @Test
    public void rotatingClockwiseFromLeftShouldReturnUp() {
        dummy.setRobot(new Robot(pos, Direction.LEFT, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_CLOCKWISE), Direction.UP);
    }

    @Test
    public void rotatingClockwiseFromUpShouldReturnRight() {
        dummy.setRobot(new Robot(pos, Direction.UP, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_CLOCKWISE), Direction.RIGHT);
    }

    @Test
    public void rotatingCounterclockwiseFromRightShouldReturnUp() {
        dummy.setRobot(new Robot(pos, Direction.RIGHT, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.UP);
    }

    @Test
    public void rotatingCounterclockwiseFromDownShouldReturnRight() {
        dummy.setRobot(new Robot(pos, Direction.DOWN, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.RIGHT);
    }

    @Test
    public void rotatingCounterclockwiseFromLeftShouldReturnDown() {
        dummy.setRobot(new Robot(pos, Direction.LEFT, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.DOWN);
    }

    @Test
    public void rotatingCounterclockwiseFromUpShouldReturnLeft() {
        dummy.setRobot(new Robot(pos, Direction.UP, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.LEFT);
    }

    @Test
    public void rotatingAroundFromUpShouldReturnDown() {
        dummy.setRobot(new Robot(pos, Direction.UP, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_AROUND), Direction.DOWN);
    }

    @Test
    public void rotatingAroundFromRightShouldReturnLeft() {
        dummy.setRobot(new Robot(pos, Direction.RIGHT, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_AROUND), Direction.LEFT);
    }

    @Test
    public void rotatingAroundFromDownShouldReturnUp() {
        dummy.setRobot(new Robot(pos, Direction.DOWN, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_AROUND), Direction.UP);
    }

    @Test
    public void rotatingAroundFromLeftShouldReturnRight() {
        dummy.setRobot(new Robot(pos, Direction.LEFT, dummy.getMap(), dummy.getSheet(), null));
        assertEquals(dummy.getRobot().testRotation(Rotation.TURN_AROUND), Direction.RIGHT);
    }
}

