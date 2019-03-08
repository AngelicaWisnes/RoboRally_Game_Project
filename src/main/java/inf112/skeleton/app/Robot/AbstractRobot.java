package inf112.skeleton.app.Robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Card.*;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Helpers.TileIDTranslator;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Screens.GameScreen;
import inf112.skeleton.app.TileTypes.*;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobot implements IRobot {
    private TiledMap map;
    private Position pos;
    private Direction dir;
    private int width, height;


    AbstractRobot(Position pos, Direction dir, TiledMap map) {
        this.map = map;
        this.pos = pos;
        this.width = GameScreen.TILESIZE;
        this.height = GameScreen.TILESIZE;

        this.dir = dir;
    }

    /**
     * @return the current position
     */
    public Position getPos() { return pos; }


    /**
     * The method that is called to see if a tile
     * should influence the robot.
     */
    public void moveRobot(){
        ITile currentTile = getTileOnCurrentPos();

        if (currentTile instanceof Rotator){ rotate(((Rotator) currentTile).getRotation()); }
        if (currentTile instanceof SingleConveyor) { move(((SingleConveyor) currentTile).getDirection(), 1);}
        if (currentTile instanceof DblConveyor) { move(((DblConveyor) currentTile).getDirection(), 2);}
    }

    /**
     * A method that allows user to move robot
     * with keyboard, useful for testing manually
     */
    public void moveRobotByKeyboard() {
        //move the robot one tile in a direction
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) move(Direction.LEFT, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) move(Direction.RIGHT, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) move(Direction.UP, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) move(Direction.DOWN, 1);
    }

    /**
     * @param card the card that is to influence the robot
     * moves the robot as the card dictates
     */
    public void cardMovesRobot(AbstractCard card) {
       if (card instanceof MoveBackwards) {
           this.pos = move(Direction.DOWN, 1);
       }

       if (card instanceof MoveForward) {
           this.pos = move(Direction.UP, ((MoveForward) card).getSteps());
        }

       if (card instanceof RotationCard) {
        }
    }

    /**
     * @return the tile object at the position of the robot
     */
    private ITile getTileOnCurrentPos() {
        //move the robot one tile in a direction
        int x = pos.getX() / GameScreen.TILESIZE;
        int y = pos.getY() / GameScreen.TILESIZE;
        int tileID = -1;
        try {
            TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(x, y);
            tileID = cell.getTile().getId();
        } catch (Exception e) {
            System.out.println("du har dødd");
        }

        return TileIDTranslator.translate_ID(tileID);
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
     * Helper-method for testing rotate-method
     */
    public Direction testRotation(Rotation rotation) {
        return rotate(rotation);
    }


    /**
     * Move the robot in the given direction
     * @param direction given from keyboardMoveRobot
     * @param spaces number of spaces to move
     * @return the new position
     */
    private Position move(Direction direction, int spaces) {
        if (spaces < 1 || spaces > 3) {
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

    /**
     * Helper-method for testing move-method
     */
    private Position testMove(Direction direction, int spaces) {
        return move(direction, spaces);
    }
}
