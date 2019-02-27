package inf112.skeleton.app.Robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Position;
import inf112.skeleton.app.Screens.GameScreen;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobot implements iRobot {
    private Position pos;
    private Direction dir;
    private int playerID, width, height;


    protected AbstractRobot(Position pos, Direction dir) {
        this.pos = pos;
        this.width = GameScreen.TILESIZE;
        this.height = GameScreen.TILESIZE;

        this.dir = dir;
    }

    public Position getPos() { return pos; }

    public void keyboardMoveRobot(TiledMap map) {
        //move the robot one tile in a direction
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) move(Direction.LEFT, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) move(Direction.RIGHT, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) move(Direction.UP, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) move(Direction.DOWN, 1);

        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)
                || Gdx.input.isKeyJustPressed(Input.Keys.LEFT)
                || Gdx.input.isKeyJustPressed(Input.Keys.UP)
                || Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            int x = pos.getX() / GameScreen.TILESIZE;
            int y = pos.getY() / GameScreen.TILESIZE;
            try {
                TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(x, y);
                System.out.println(cell.getTile().getId());

            } catch (Exception e) {
                System.out.println("du har dødd");
            }

        }
    }

    /**
     * Rotate the robot
     * @param rotation the rotation-Enum describing how turning-direction
     * @return the new direction
     */
    private Direction rotate(Rotation rotation) {
        switch (rotation) {
            case TURN_CLOCKWISE: return dir = dir.clockwise();
            case TURN_COUNTER_CLOCKWISE: return dir = dir.counterClockwise();
            case TURN_AROUND: return dir = dir.opposite();
            default:
                throw new IllegalArgumentException("Must have valid rotation-input to rotate robot");
        }
    }

    /**
     * Move the robot in the given direction
     * @param direction given from keyboardMoveRobot
     * @param spaces number of spaces to move
     * @return the new position
     */
    private Position move(Direction direction, int spaces) {
        if (spaces < 1 || spaces > 3){
            throw new IllegalArgumentException("Must have valid spaces-input to move robot");
        }

        switch (direction) {
            case UP: pos.setY(spaces * GameScreen.TILESIZE); return pos;
            case DOWN: pos.setY(-spaces * GameScreen.TILESIZE); return pos;
            case LEFT: pos.setX(-spaces * GameScreen.TILESIZE); return pos;
            case RIGHT: pos.setX(spaces * GameScreen.TILESIZE); return pos;
            default:
                throw new IllegalArgumentException("Must have valid direction-input to move robot");
        }
    }
}
