package inf112.skeleton.app.Robot;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Position;

public interface iRobot {

    /**
     * Get the position of the robot
     * @return the position
     */
    Position getPos();

    /**
     * This is a temporary method for moving the robot with the help of arrow-keys from keyboard.
     */
    void keyboardMoveRobot();
}
