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
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;
import inf112.skeleton.app.Screens.GameScreen;
import inf112.skeleton.app.TileTypes.*;

import static inf112.skeleton.app.Helpers.Position.getTileOnPos;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobot implements IRobot {
    private TiledMap map;
    private final int TILESIZE = GameScreen.TILESIZE;
    private Position pos, checkpoint;
    private Direction dir;
    private ProgramSheet programSheet;

    AbstractRobot(Position pos, Direction dir, TiledMap map, ProgramSheet programSheet) {
        this.map = map;
        this.dir = dir;
        this.programSheet = programSheet;

        this.pos = pos;
        checkpoint = pos.clone();
    }

    /**
     * @return the current position
     */
    @Override
    public Position getPos() {
        return pos;
    }

    @Override
    public Direction getDir() {
        return dir;
    }


    protected void setFlagID(int flagID) {
        int lastVisitedFlag = programSheet.getLastVisitedFlag();
        if (flagID == lastVisitedFlag + 1) {
            programSheet.setLastVisitedFlag(flagID);
            setPositionCheckpointCorrespondance(checkpoint, pos);
            System.out.println("Just updated flagID to " + flagID);
        }
    }

    /**
     * Update the correspondance between current position and checkpoint.
     *
     * @param p1 position to be updated
     * @param p2 position to update from
     * @return position of last checkpoint
     */
    protected Position setPositionCheckpointCorrespondance(Position p1, Position p2) {
        p1.setXY(p2.getX(), p2.getY());
        return pos;
    }

    /**
     * The method that is called to see if a tile
     * should influence the robot.
     */
    @Override
    public void tileRobotImpact(RoundState roundState) {
        ITile tile = getTileOnPos(pos, map);
        switch (roundState) {
            case PART1:
                if (tile instanceof DblConveyor) {
                    move(((DblConveyor) tile).getDirection(), 1);
                }
                break;
            case PART2:
                if (tile instanceof AbstractConveyor) {
                    move(((AbstractConveyor) tile).getDirection(), 1);
                }
                break;
            case PART3:
                // Pushers
                break;
            case PART4:
                if (tile instanceof Rotator) {
                    rotate(((Rotator) tile).getRotation());
                }
                break;
            case PART5:
                // Lasers
                break;
            case PART6:
                if (tile instanceof Flag) {
                    setFlagID(((Flag) tile).getId());
                } else if (tile instanceof AbstractRepair) {
                    programSheet.repair(((AbstractRepair) tile).getRepairQty());
                }
                break;
            case NONE:
                break;
        }

    }

    /**
     * A method that allows user to move robot
     * with keyboard, useful for testing manually
     */
    @Override
    public void keyboardMovesRobot() {
        //move the robot one tile in a direction
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            move(dir, 1);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            move(dir.opposite(), 1);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            rotate(Rotation.TURN_COUNTER_CLOCKWISE);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            rotate(Rotation.TURN_CLOCKWISE);
        }
    }

    /**
     * @param card the card that is to influence the robot
     *             moves the robot as the card dictates
     */
    @Override
    public void cardMovesRobot(AbstractCard card) {
        if (card instanceof MoveBackwards) {
            move(dir.opposite(), 1);
        }
        if (card instanceof MoveForward) {
            move(dir, ((MoveForward) card).getSteps());
        }
        if (card instanceof RotationCard) {
            rotate(((RotationCard) card).getRotation());
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
            case TURN_CLOCKWISE:
                return dir = dir.clockwise();
            case TURN_COUNTER_CLOCKWISE:
                return dir = dir.counterClockwise();
            case TURN_AROUND:
                return dir = dir.opposite();
            default:
                throw new IllegalArgumentException("Must have valid rotation-input to rotate robot");
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
        if (spaces < 1 || spaces > 3) {
            throw new IllegalArgumentException("Invalid spaces-input to move");
        }

        while (spaces-- > 0) {
            if (hasWall(direction)) {
                continue;
            }


            pos = pos.getNeighbour(direction, TILESIZE);

            if (hasJustFallen()) {
                return killRobot();
            }
        }

        return pos;
    }

    public Position killRobot(){
        System.out.println("you have died");
        programSheet.removeLife();
        programSheet.resetDamage();
        return setPositionCheckpointCorrespondance(pos, checkpoint);

    }

    /**
     * Check if there is a wall in the given direction
     *
     * @param direction to check
     * @return
     */
    private boolean hasWall(Direction direction) {
        ITile cur = getTileOnPos(pos, map);
        ITile nbr = getTileOnPos(pos.getNeighbour(direction, TILESIZE), map);
        return (nbr instanceof AbstractWall && ((AbstractWall) nbr).hasWall(direction.opposite()))
                || (cur instanceof AbstractWall && ((AbstractWall) cur).hasWall(direction));
    }

    /**
     * Checks if robot has just fallen (pit or edge).
     *
     * @return true if dead, false otherwise
     */
    private boolean hasJustFallen() {
        ITile currentTile = getTileOnPos(pos, map);
        return currentTile == null || currentTile instanceof Pit;
    }


    /**
     * Helper-method for testing move-method
     */
    public Position testMove(Direction direction, int spaces) {
        return move(direction, spaces);
    }

    /**
     * Helper-method for testing rotate-method
     */
    public Direction testRotation(Rotation rotation) {
        return rotate(rotation);
    }
}
