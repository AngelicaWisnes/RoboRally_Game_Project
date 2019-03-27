package inf112.skeleton.app.Robot;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

/**
 * @author Roger Wisnes
 */
public class Robot extends AbstractRobot {
    public Robot(Position pos, Direction dir, TiledMap map, ProgramSheet ps) { super(pos, dir, map, ps); }
}
