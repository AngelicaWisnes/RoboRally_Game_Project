package inf112.skeleton.app.Robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Card.*;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Helpers.TileIDTranslator;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;
import inf112.skeleton.app.Screens.GameScreen;
import inf112.skeleton.app.TileTypes.*;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobot implements IRobot {
    private TiledMap map;
    private Position pos, checkpoint;
    private Direction dir;
    private int width, height, lastVisitedFlag;

    AbstractRobot(Position pos, Direction dir, TiledMap map) {
        this.map = map;
        this.width = GameScreen.TILESIZE;
        this.height = GameScreen.TILESIZE;
        this.dir = dir;

        this.lastVisitedFlag = 0;
        this.pos = pos;
        this.checkpoint = pos.clone();
    }

    /**
     * @return the current position
     */
    public Position getPos() { return pos; }

    @Override
    public Direction getDir() { return dir; }

    /**
     * The method that is called to see if a tile
     * should influence the robot.
     */
    @Override
    public void tileMovesRobot(RoundState roundState) {
        ITile curTile = getTileOnCurrentPos();
        switch (roundState) {
            case PART1:
                if (curTile instanceof DblConveyor) move(((DblConveyor) curTile).getDirection(), 1);
                break;
            case PART2:
                if (curTile instanceof AbstractConveyor) move(((AbstractConveyor) curTile).getDirection(), 1);
                break;
            case PART3:
                break;
            case PART4:
                if (curTile instanceof Rotator) rotate(((Rotator) curTile).getRotation());
                break;
            case NONE: break;
        }

    }

    /**
     * A method that allows user to move robot
     * with keyboard, useful for testing manually
     */
    @Override
    public void keyboardMovesRobot() {
        //move the robot one tile in a direction
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) move(dir, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) move(dir.opposite(), 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) rotate(Rotation.TURN_COUNTER_CLOCKWISE);
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) rotate(Rotation.TURN_CLOCKWISE);
    }

    /**
     * @param card the card that is to influence the robot
     *             moves the robot as the card dictates
     */
    @Override
    public void cardMovesRobot(AbstractCard card) {
        if (card instanceof MoveBackwards) move(dir.opposite(), 1);
        if (card instanceof MoveForward) move(dir, ((MoveForward) card).getSteps());
        if (card instanceof RotationCard) rotate(((RotationCard) card).getRotation());
    }

    /**
     * @return the tile object at the position of the robot
     */
    private ITile getTileOnCurrentPos() {
        //move the robot one tile in a direction
        int x = pos.getX() / GameScreen.TILESIZE;
        int y = pos.getY() / GameScreen.TILESIZE;
        int tileID;
        try {
            TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(x, y);
            tileID = cell.getTile().getId();
            return TileIDTranslator.translate_ID(tileID);
        } catch (Exception e) {
            System.out.println("you have died");
            return null;
        }
    }

    /**
     * Repairs the robot
     */
    private void repairRobot(SingleRepair singleRepair, DoubleRepair doubleRepair) {
        if (getTileOnCurrentPos() == singleRepair) {
            //discard 1 damage token
        }

        if (getTileOnCurrentPos() == doubleRepair) {
            //discard 1 damage && draw 1 option card
        }
    }

    /**
     * Rotate the robot
     *
     * @param rotation the rotation-Enum describing how turning-direction
     * @return the new direction
     */
    private Direction rotate(Rotation rotation) {
        switch (rotation) {
            case TURN_CLOCKWISE: return dir = dir.clockwise();
            case TURN_COUNTER_CLOCKWISE: return dir = dir.counterClockwise();
            case TURN_AROUND: return dir = dir.opposite();
            default: throw new IllegalArgumentException("Must have valid rotation-input to rotate robot");
        }
    }

    /**
     * Move the robot in the given direction
     *
     * @param direction given from keyboardMoveRobot
     * @param spaces    number of spaces to move
     * @return the new position
     */
    private Position move(Direction direction, int spaces) {
        if (spaces < 1 || spaces > 3) throw new IllegalArgumentException("Invalid spaces-input to move");

        while (spaces-- > 0) {
            switch (direction) {
                case UP: pos.setY(pos.getY() + height); break;
                case DOWN: pos.setY(pos.getY() - height); break;
                case LEFT: pos.setX(pos.getX() - width); break;
                case RIGHT: pos.setX(pos.getX() + width); break;
                default: throw new IllegalArgumentException("Must have valid direction-input to move robot");
            }

            if (hasJustDied()) return killRobot();
        }

        return pos;
    }

    /**
     * Checks if robot has just died.
     *
     * @return true if dead, false otherwise
     */
    private boolean hasJustDied() {
        ITile currentTile = getTileOnCurrentPos();
        return currentTile == null || currentTile instanceof Pit;
    }

    /**
     * Reset robot after death.
     *
     * @return position of last checkpoint
     */
    private Position killRobot() {
        pos.setXY(checkpoint.getX(), checkpoint.getY());
        return pos;
    }

    /**
     * Helper-method for testing move-method
     */
    public Position testMove(Direction direction, int spaces) { return move(direction, spaces); }

    /**
     * Helper-method for testing rotate-method
     */
    public Direction testRotation(Rotation rotation) { return rotate(rotation); }
}
