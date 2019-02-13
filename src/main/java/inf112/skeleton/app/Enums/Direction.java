package inf112.skeleton.app.Enums;


  public enum Direction {
        UP, DOWN, LEFT, RIGHT;

      public Direction opposite() {
          switch (this) {
              case UP: return Direction.DOWN;
              case DOWN: return Direction.UP;
              case LEFT: return Direction.RIGHT;
              case RIGHT: return Direction.LEFT;
              default: throw new IllegalArgumentException(
                      "Direction " + this + " has no opposite.");
          }
      }

      public Direction clockwise() {
          switch (this) {
              case UP: return Direction.RIGHT;
              case RIGHT: return Direction.DOWN;
              case DOWN: return Direction.LEFT;
              case LEFT: return Direction.UP;
              default: throw new IllegalArgumentException(
                      "Direction " + this + " has no clockwise turn-direction.");
          }
      }

      public Direction counterClockwise() {
          switch (this) {
              case UP: return Direction.LEFT;
              case LEFT: return Direction.DOWN;
              case DOWN: return Direction.RIGHT;
              case RIGHT: return Direction.UP;
              default: throw new IllegalArgumentException(
                      "Direction " + this + " has no counterclockwise turn-direction.");
          }
      }
    }
