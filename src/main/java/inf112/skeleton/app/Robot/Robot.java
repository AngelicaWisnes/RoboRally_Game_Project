package inf112.skeleton.app.Robot;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Position;

/**
 * @author Roger Wisnes
 */
public class Robot extends AbstractRobot{
    public Robot(Position pos, Direction dir, TiledMap map) { super(pos, dir, map); }
}
