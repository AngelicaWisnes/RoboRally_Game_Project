/*
package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Robot.AbstractRobotGetSet;
import inf112.skeleton.app.Robot.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

*/
/**
 * jUnit test for simple App.
 *//*

public class AbstractRobotTest {

    private Position pos;
    private TiledMap map;

    @Before
    public void createMap(){
        pos = new Position(5,5);
        map = new TmxMapLoader().load("assets/maps/map.tmx");
    }


    @Test
    public void rotatingClockwiseFromRightShouldReturnDown() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.RIGHT, map);
        assertEquals(robot.testRotation(Rotation.TURN_CLOCKWISE), Direction.DOWN);
    }

    @Test
    public void rotatingClockwiseFromDownShouldReturnLeft() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.DOWN, map);
        assertEquals(robot.testRotation(Rotation.TURN_CLOCKWISE), Direction.LEFT);
    }

    @Test
    public void rotatingClockwiseFromLeftShouldReturnUp() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.LEFT, map);
        assertEquals(robot.testRotation(Rotation.TURN_CLOCKWISE), Direction.UP);
    }

    @Test
    public void rotatingClockwiseFromUpShouldReturnRight() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.UP, map);
        assertEquals(robot.testRotation(Rotation.TURN_CLOCKWISE), Direction.RIGHT);
    }

    @Test
    public void rotatingCounterclockwiseFromRightShouldReturnUp() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.RIGHT, map);
        assertEquals(robot.testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.UP);
    }

    @Test
    public void rotatingCounterclockwiseFromDownShouldReturnRight() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.DOWN, map);
        assertEquals(robot.testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.RIGHT);
    }

    @Test
    public void rotatingCounterclockwiseFromLeftShouldReturnDown() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.LEFT, map);
        assertEquals(robot.testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.DOWN);
    }

    @Test
    public void rotatingCounterclockwiseFromUpShouldReturnLeft() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.UP, map);
        assertEquals(robot.testRotation(Rotation.TURN_COUNTER_CLOCKWISE), Direction.LEFT);
    }

    @Test
    public void rotatingAroundFromUpShouldReturnDown() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.UP, map);
        assertEquals(robot.testRotation(Rotation.TURN_AROUND), Direction.DOWN);
    }

    @Test
    public void rotatingAroundFromRightShouldReturnLeft() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.RIGHT, map);
        assertEquals(robot.testRotation(Rotation.TURN_AROUND), Direction.LEFT);
    }

    @Test
    public void rotatingAroundFromDownShouldReturnUp() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.DOWN, map);
        assertEquals(robot.testRotation(Rotation.TURN_AROUND), Direction.UP);
    }

    @Test
    public void rotatingAroundFromLeftShouldReturnRight() {
        AbstractRobotGetSet robot = new Robot(pos, Direction.LEFT, map);
        assertEquals(robot.testRotation(Rotation.TURN_AROUND), Direction.RIGHT);
    }

}
*/
