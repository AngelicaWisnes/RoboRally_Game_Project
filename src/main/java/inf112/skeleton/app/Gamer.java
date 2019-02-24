package inf112.skeleton.app;

import inf112.skeleton.app.Robot.iRobot;

public class Gamer {

    private final iRobot robot;
    private final Board board;

    public Gamer(Board board, iRobot robot) {
        this.board = board;
        this.robot = robot;
    }
}
