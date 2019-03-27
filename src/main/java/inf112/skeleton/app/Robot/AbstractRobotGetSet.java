package inf112.skeleton.app.Robot;

import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

/**
 * @author Roger Wisnes
 */
public abstract class AbstractRobotGetSet implements IRobot {
    protected Position pos, checkpoint;
    protected Direction dir;
    protected int lastVisitedFlag;
    protected ProgramSheet programSheet;

    /**
     * @return the current position
     */
    public Position getPos() { return pos; }

    @Override
    public Direction getDir() { return dir; }


    protected void setFlagID(int flagID) {
        if (flagID == lastVisitedFlag + 1) {
            lastVisitedFlag = flagID;
            setPositionCheckpointCorrespondance(checkpoint, pos);
            System.out.println("Just updated flagID to " + lastVisitedFlag);
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
}
