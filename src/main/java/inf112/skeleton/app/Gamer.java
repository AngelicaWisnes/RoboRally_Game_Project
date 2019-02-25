package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Robot.iRobot;

public class Gamer {

    private TiledMap map;
    private final Board board;
    private final iRobot robot;

    public Gamer(TiledMap map, Board board, iRobot robot) {
        this.map = map;
        this.board = board;
        this.robot = robot;
    }
}
