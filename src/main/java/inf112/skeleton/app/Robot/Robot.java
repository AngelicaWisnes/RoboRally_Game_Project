package inf112.skeleton.app.Robot;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Gamer.IGamer;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.ArrayList;

public class Robot extends AbstractRobot {
    public Robot(Position pos, Direction dir, TiledMap map, ProgramSheet ps, ArrayList<IGamer> gamers) {
        super(pos, dir, map, ps, gamers);
    }
}
