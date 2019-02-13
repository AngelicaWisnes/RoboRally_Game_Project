package inf112.skeleton.app;

public interface iRobot {
    //Position pos;
    //Direction dir;
    Direction rotate(Direction direction);
    Position move(Direction direction, int spaces);
}
