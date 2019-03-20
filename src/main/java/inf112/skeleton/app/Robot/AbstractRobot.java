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
        this.pos = this.checkpoint = pos;
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
        ITile currentTile = getTileOnCurrentPos();
        if (roundState.equals(RoundState.PART1)) {
            if (currentTile instanceof DblConveyor) move(((DblConveyor) currentTile).getDirection(), 1);
        } else if (roundState.equals(RoundState.PART2)) {
            if (currentTile instanceof DblConveyor) move(((DblConveyor) currentTile).getDirection(), 1);
            else if (currentTile instanceof SingleConveyor) move(((SingleConveyor) currentTile).getDirection(), 1);
        } else if (roundState.equals(RoundState.PART3)) {
            // pushers push if active
        } else if (roundState.equals(RoundState.PART4)) {
            if (currentTile instanceof Rotator) rotate(((Rotator) currentTile).getRotation());
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
        if (card instanceof MoveBackwards) this.pos = move(dir.opposite(), 1);
        if (card instanceof MoveForward) this.pos = move(dir, ((MoveForward) card).getSteps());

        if (card instanceof RotationCard) {
            if (((RotationCard) card).getRotation().equals(Rotation.TURN_CLOCKWISE)) {
                this.dir = this.dir.clockwise();
            } else if (((RotationCard) card).getRotation().equals(Rotation.TURN_COUNTER_CLOCKWISE)) {
                this.dir = this.dir.counterClockwise();
            } else if (((RotationCard) card).getRotation().equals(Rotation.TURN_AROUND)) {
                this.dir = this.dir.opposite();
            }
        }
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
     *
     */
    private void repairRobot() {
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
                case UP: pos.setY(height); break;
                case DOWN: pos.setY(-height); break;
                case LEFT: pos.setX(-width); break;
                case RIGHT: pos.setX(width); break;
                default: throw new IllegalArgumentException("Must have valid direction-input to move robot");
            }

            if (hasJustDied()) return killRobot();
        }

        return pos;
    }

    /**
     * Checks if robot has just died.
     * @return true if dead, false otherwise
     */
    private boolean hasJustDied() {
        ITile currentTile = getTileOnCurrentPos();
        return currentTile == null || currentTile instanceof Pit;
    }

    /**
     * Reset robot after death.
     * @return position of last checkpoint
     */
    private Position killRobot(){
        pos = checkpoint;
        return pos;
    }

    /**
     * Helper-method for testing move-method
     */
    private Position testMove(Direction direction, int spaces) { return move(direction, spaces); }

    /**
     * Helper-method for testing rotate-method
     */
    public Direction testRotation(Rotation rotation) { return rotate(rotation); }
}
