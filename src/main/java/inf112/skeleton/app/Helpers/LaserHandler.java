package inf112.skeleton.app.Helpers;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Gamer;
import inf112.skeleton.app.IGamer;
import inf112.skeleton.app.Robot.IRobot;
import inf112.skeleton.app.Robot.Robot;

import java.util.ArrayList;

import static inf112.skeleton.app.Helpers.Constants.TILESIZE;

public class LaserHandler {

    private static Rectangle laserRect;

    public static void fireBoardLaser(ArrayList<Position> lasers, IGamer gamer, ShapeRenderer shape, Sound pew, int TILESIZE) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);
        Rectangle robotRectangle = new Rectangle(gamer.getSheet().getRobot().getPos().getX(), gamer.getSheet().getRobot().getPos().getY(), TILESIZE, TILESIZE);
        //pew.play();
        for (Position laser : lasers) {
            TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) gamer.getMap().getLayers().get(0)).getCell(laser.getX() / 64, laser.getY() / 64);
            int id = cell.getTile().getId();
            if (id == 929) { //
                shape.rect(laser.getX() + (TILESIZE / 2), laser.getY() + (TILESIZE / 2) - 5, -(TILESIZE * 3), 10);
                Rectangle laserRect = new Rectangle(laser.getX() - 3 * TILESIZE, laser.getY() + (TILESIZE / 2), (TILESIZE * 4) - 1, 1);
                if (laserRect.overlaps(robotRectangle)) {
                    gamer.getSheet().damageRobot();
                }

            }
            if (id == 646) {
                shape.rect(laser.getX() + TILESIZE / 2, laser.getY() + TILESIZE / 2, 10, -(TILESIZE * 3));
                laserRect = new Rectangle(laser.getX() + TILESIZE / 2, laser.getY() - TILESIZE * 3, 1, (TILESIZE * 4) - 1);

                if (laserRect.overlaps(robotRectangle)) {
                    gamer.getSheet().damageRobot();
                }

            }
        }
        shape.end();


    }

    public static void fireRobotLaser(Gamer shooter, ArrayList<IGamer> opponents, ShapeRenderer shape) {
        int x = shooter.getSheet().getRobot().getPos().getX();
        int y = shooter.getSheet().getRobot().getPos().getY();
        Direction dir = shooter.getSheet().getRobot().getDir();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.RED);

        Rectangle laser;
        for (int i = 0; i < 16; i++) {
            if (dir.equals(Direction.UP)) {
                laser = new Rectangle(x + TILESIZE / 2, (y + TILESIZE / 2) + (i * TILESIZE), 10, 64);
                shape.rect(x + TILESIZE / 2, (y + TILESIZE / 2) + (i * TILESIZE), 10, 64);
            } else if (dir.equals(Direction.DOWN)) {
                laser = new Rectangle(x + TILESIZE / 2, (y + TILESIZE / 2) - (i * TILESIZE), 10, 64);
                shape.rect(x + TILESIZE / 2, (y + TILESIZE / 2) - (i * TILESIZE), 10, 64);
            } else if (dir.equals(Direction.LEFT)) {
                laser = new Rectangle(x + TILESIZE / 2 - (i * TILESIZE), (y + TILESIZE / 2), 10, 64);
                shape.rect(x + TILESIZE / 2 - (i * TILESIZE), (y + TILESIZE / 2), 10, 64);
            } else {
                laser = new Rectangle(x + (TILESIZE / 2) + (i * TILESIZE), (y + TILESIZE / 2), 64, 10);
                shape.rect(x + (TILESIZE / 2) + (i * TILESIZE), (y + TILESIZE / 2), 64, 10);
            }

            for (IGamer gamer : opponents) {
                IRobot opponentRobot = gamer.getSheet().getRobot();
                Rectangle rectangle = (new Rectangle(opponentRobot.getPos().getX(), opponentRobot.getPos().getY(), TILESIZE, TILESIZE));
                if (laser.overlaps(rectangle)) {
                    gamer.getSheet().damageRobot();
                    break;
                }
            }

        }

        shape.end();

    }
}
