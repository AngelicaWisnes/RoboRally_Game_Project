package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Helpers.Position;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobotGetSet implements IRobot {
    protected Position pos, checkpoint;
    protected Direction dir;
    protected int lastVisitedFlag, damage, lives;

    /**
     * @return the current position
     */
    public Position getPos() { return pos; }

    @Override
    public Direction getDir() { return dir; }

    public int getDamage() { return damage; }

    public int getLives() { return lives; }

    public void setDamage(int damage) { this.damage += damage; }

    public void setLives(int lives) { this.lives = lives; }

    protected void setFlagID(int flagID) {
        if (flagID == lastVisitedFlag + 1) {
            lastVisitedFlag = flagID;
            setPositionCheckpointCorrespondance(checkpoint, pos);
            System.out.println("Just updated flagID to " + lastVisitedFlag);
        }
    }

    /**
     * Repairs the robot
     */
    protected void repair(int repairQty) {
        setDamage(-repairQty);
        if (damage < 0) damage = 0;
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
}
