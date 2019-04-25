package inf112.skeleton.app.Helpers.DummyClassesForTesting;

import static org.mockito.Mockito.mock;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.skeleton.app.Gamer.Gamer;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;
import inf112.skeleton.app.Robot.IRobot;

public class Dummy {

    class EmptyApplication implements ApplicationListener {
        public void create() {}

        public void resize(int width, int height) {}

        public void render() {}

        public void pause() {}

        public void resume() {}

        public void dispose() {}
    }

    private TiledMap map;
    private IRobot robot;
    private Gamer gamer;
    private ProgramSheet sheet;

    public Dummy() {
        //Create Gdx.gl
        Gdx.gl = mock(GL20.class);

        //Launch the program and initialise all Gdx stuff (invisible and no program is really launched)
        new HeadlessApplication(new EmptyApplication());

        //Now we load our map...

        map = new TmxMapLoader().load("assets/maps/Originalmap.tmx");
        gamer = new Gamer(map, "Player1", 1);
        sheet = gamer.getSheet();
        robot = sheet.getRobot();
    }

    public void setRobot(IRobot robot) {
        gamer.getSheet().setRobot(robot);
        this.robot = robot;
    }

    public IRobot getRobot() { return robot; }

    public TiledMap getMap() { return map; }

    public ProgramSheet getSheet() { return sheet; }

    public Gamer getGamer() { return gamer; }






}

