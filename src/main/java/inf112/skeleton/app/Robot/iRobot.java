package inf112.skeleton.app.Robot;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Position;

public interface iRobot {

    Position getPos();

    void keyboardMoveRobot(TiledMap map);
}
