package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Robot.iRobot;

public class Gamer {

    private TiledMap map;
    private final iRobot robot;

    public Gamer(TiledMap map, iRobot robot) {
        this.map = map;
        this.robot = robot;
    }
}
