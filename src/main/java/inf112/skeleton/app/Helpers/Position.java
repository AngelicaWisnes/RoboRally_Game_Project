package inf112.skeleton.app.Helpers;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    /**
     * Creates a new Position with same x- and y-value as this
     * @return new position
     */
    public Position clone() { return new Position(this.x, this.y); }

}
