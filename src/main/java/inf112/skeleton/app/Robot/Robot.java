package inf112.skeleton.app.Robot;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Board;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Position;

/**
 * @author Roger Wisnes
 */
public class Robot extends AbstractRobot{
    public Robot(Position pos, Direction dir) {
        super(pos, dir);
    }

    public Robot(int playerN, Board board, TiledMap map){
        super(getPositionFromBoard(playerN, board), getDirectionFromBoard(playerN, board));
    }
    //TODO: return initial direction from board
    private static Direction getDirectionFromBoard(int playerN, Board board) {
        return null;
    }
    //TODO: return initial position from board
    private static Position getPositionFromBoard(int playerN, Board board) {
        return null;
    }
}
