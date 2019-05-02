package inf112.skeleton.app.Robot;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.MoveBackwards;
import inf112.skeleton.app.Card.MoveForward;
import inf112.skeleton.app.Card.RotationCard;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Enums.Rotation;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Gamer.IGamer;
import inf112.skeleton.app.Helpers.Constants;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;
import inf112.skeleton.app.TileTypes.*;

import java.util.ArrayList;

import static inf112.skeleton.app.Helpers.Position.getTileOnPos;

public abstract class AbstractRobot implements IRobot {
    private TiledMap map;
    private final int TILESIZE = Constants.TILESIZE;
    private Position pos, checkpoint;
    private Direction dir;
    private ProgramSheet programSheet;
    private ArrayList<IGamer> gamers;

    AbstractRobot(Position pos, Direction dir, TiledMap map, ProgramSheet programSheet, ArrayList<IGamer> gamers) {
        this.gamers = gamers;
        this.map = map;
        this.dir = dir;
        this.programSheet = programSheet;

        this.pos = pos;
        checkpoint = pos.clone();
    }

    @Override
    public Position getPos() { return pos; }

    @Override
    public Direction getDir() { return dir; }

    /**
     * If robot is currently on a flag, check if this flag is the next non-visitet flag. If so, update checkpoint
     * @param flagID ID of tha new flag
     */
    private void setFlagID(int flagID) {
        if (flagID == programSheet.getLastVisitedFlag() + 1) {
            programSheet.setLastVisitedFlag(flagID);
            setPositionCheckpointCorrespondence(checkpoint, pos);
            System.out.println("Just updated flagID to " + flagID);
        }
    }

    /**
     * Update the correspondence between current position and checkpoint.
     *
     * @param p1 position to be updated
     * @param p2 position to update from
     * @return position of last checkpoint
     */
    private Position setPositionCheckpointCorrespondence(Position p1, Position p2) {
        p1.setXY(p2.getX(), p2.getY());
        return pos;
    }

    @Override
    public void tileRobotImpact(RoundState roundState) {
        ITile tile = getTileOnPos(pos, map);
        switch (roundState) {
            case PART1:
                if (tile instanceof DblConveyor) move(((DblConveyor) tile).getDirection(), 1);
                break;
            case PART2:
                if (tile instanceof AbstractConveyor) move(((AbstractConveyor) tile).getDirection(), 1);
                break;
            case PART3:
                // Pushers
                break;
            case PART4:
                if (tile instanceof Rotator) rotate(((Rotator) tile).getRotation());
                break;
            case PART5:
                // Lasers
                break;
            case PART6:
                if (tile instanceof Flag) setFlagID(((Flag) tile).getId());
                else if (tile instanceof AbstractRepair) programSheet.repair(((AbstractRepair) tile).getRepairQty());
                break;
            case NONE:
                break;
        }
    }

    @Override
    public void keyboardMovesRobot() {
        //move the robot one tile in a direction
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) move(dir, 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) move(dir.opposite(), 1);
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) rotate(Rotation.TURN_COUNTER_CLOCKWISE);
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) rotate(Rotation.TURN_CLOCKWISE);
    }

    @Override
    public void cardMovesRobot(AbstractCard card) {
        if (card instanceof MoveBackwards) move(dir.opposite(), 1);
        if (card instanceof MoveForward) move(dir, ((MoveForward) card).getSteps());
        if (card instanceof RotationCard) rotate(((RotationCard) card).getRotation());
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
            Position targetPos = pos.getNeighbour(direction, TILESIZE);
            if (hasWall(direction, pos)) continue;

            Position temp = pos.clone();
            pos = targetPos.clone();
            if (!isOpponentPushable(targetPos, direction)) pos = temp;

            if (hasJustFallen()) return killRobot();
        }

        return pos;
    }

    /**
     * Get opponent's robot on target position
     * @param targetPos target position
     * @return opponents robot, if it exists on position, null otherwise
     */
    private IRobot getOpponentRobotOnPos(Position targetPos){
        for (IGamer g : gamers) {
            if (g.getSheet().getRobot() == this) continue;
            if (g.getSheet().getRobot().getPos().equal(targetPos)) return g.getSheet().getRobot();
        }
        return null;
    }

    /**
     * If a robot dies, it should return to last checkpoint. If said checkpoint is occupied by opponent, this
     * opponent must be pushed
     */
    private void pushOpponentFromCheckpoint(){
        if (isOpponentPushable(checkpoint, dir)) return;
        if (isOpponentPushable(checkpoint, dir.opposite())) return;
        if (isOpponentPushable(checkpoint, dir.clockwise())) return;
        if (isOpponentPushable(checkpoint, dir.counterClockwise())) return;
        throw new IllegalStateException("Unable to push opponent from checkpoint, after dying");
    }

    /**
     * Find out if there is an opponent at target position and if so, if this opponent is pushable
     * @param targetPos target position
     * @param direction direction to push
     * @return false if there is an opponent in target position, and this opponent is not pushable, true if pushable,
     *         and true if there is no opponent in target position.
     */
    private boolean isOpponentPushable(Position targetPos, Direction direction) {
        IRobot opponent = getOpponentRobotOnPos(targetPos);
        if (opponent == null) return true;

        if (hasWall(direction, opponent.getPos())) return false;
        opponent.push(direction, 1);
        return true;
    }

    @Override
    public Position push(Direction direction, int spaces) { return move(direction, spaces); }

    /**
     * Check if there is a wall in the given direction
     * @param direction to check
     * @return true if wall, false otherwise
     */
    private boolean hasWall(Direction direction, Position position) {
        ITile cur = getTileOnPos(position, map);
        ITile nbr = getTileOnPos(position.getNeighbour(direction, TILESIZE), map);
        return (nbr instanceof AbstractWall && ((AbstractWall) nbr).hasWall(direction.opposite()))
                || (cur instanceof AbstractWall && ((AbstractWall) cur).hasWall(direction));
    }

    /**
     * Checks if robot has just fallen (pit or edge).
     * @return true if dead, false otherwise
     */
    private boolean hasJustFallen() {
        ITile currentTile = getTileOnPos(pos, map);
        return currentTile == null || currentTile instanceof Pit;
    }

    @Override
    public Position killRobot() {
        programSheet.removeLife();
        programSheet.resetDamage();
        pushOpponentFromCheckpoint();
        return setPositionCheckpointCorrespondence(pos, checkpoint);
    }

    @Override
    public Direction testRotation(Rotation rotation) {
        return rotate(rotation);
    }
}
