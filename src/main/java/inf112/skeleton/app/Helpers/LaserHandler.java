package inf112.skeleton.app.Helpers;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import inf112.skeleton.app.Gamer;

import java.util.ArrayList;

public class LaserHandler {

    public static void fireLasers(ArrayList<Position> lasers, Gamer gamer, ShapeRenderer shape, Sound pew, int TILESIZE) {
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
                Rectangle laserRect = new Rectangle(laser.getX() + TILESIZE / 2, laser.getY() - TILESIZE * 3, 1, (TILESIZE * 4) - 1);

                if (laserRect.overlaps(robotRectangle)) {
                    gamer.getSheet().damageRobot();
                }

            }
        }
        shape.end();


    }
}
