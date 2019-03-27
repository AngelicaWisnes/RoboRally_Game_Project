package inf112.skeleton.app.Robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.MoveBackwards;
import inf112.skeleton.app.Card.MoveForward;
import inf112.skeleton.app.Card.RotationCard;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Helpers.TileIDTranslator;
import inf112.skeleton.app.Screens.GameScreen;
import inf112.skeleton.app.TileTypes.*;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobotTileImpact extends AbstractRobotGetSet {
    private TiledMap map;
    private final int TILESIZE = GameScreen.TILESIZE;

    AbstractRobotTileImpact(Position pos, Direction dir, TiledMap map) {
        this.map = map;
        this.dir = dir;

        this.lastVisitedFlag = damage = 0;
        this.lives = 3;
        this.pos = pos;
        this.checkpoint = pos.clone();
    }

    /**
     * The method that is called to see if a tile
     * should influence the robot.
     */
    @Override
    public void tileRobotImpact(RoundState roundState) {
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
            case PART5:
                if (curTile instanceof Flag) setFlagID(((Flag) curTile).getId());
                else if (curTile instanceof AbstractRepair) repair(((AbstractRepair) curTile).getRepairQty());
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
            //if (hasWall(direction)) continue;

            pos = pos.getNeighbour(direction, TILESIZE);

            if (hasJustDied()) return setPositionCheckpointCorrespondance(pos, checkpoint);
        }

        return pos;
    }

    private boolean hasWall(Direction direction) {
        ITile currentTile = getTileOnCurrentPos();


        return true;
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
     * Helper-method for testing move-method
     */
    public Position testMove(Direction direction, int spaces) { return move(direction, spaces); }

    /**
     * Helper-method for testing rotate-method
     */
    public Direction testRotation(Rotation rotation) { return rotate(rotation); }
}
