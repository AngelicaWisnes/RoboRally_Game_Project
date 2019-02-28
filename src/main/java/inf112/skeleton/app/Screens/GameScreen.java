package inf112.skeleton.app.Screens;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.skeleton.app.Enums.Direction;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;
import inf112.skeleton.app.Views.ProgramSheetView;
import inf112.skeleton.app.Robot.Robot;

public class GameScreen implements Screen {
    final RoboRally game;

    private HashMap<String, Texture> textureMap;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private ShapeRenderer shape;

    private Texture robotImage;

    private ProgramSheet sheet;


    private Music factoryMusic;
    private SpriteBatch batch;
    private SpriteBatch HUDbatch;
    private Robot robot;

    public static final int TILESIZE = 64;
    private final int NTILES = 10;
    private final int SCREENSIZE = TILESIZE * NTILES;
    //private final int OFFSET = (SCREENSIZE/2);
    private final int OFFSET = 0;



    public GameScreen(final RoboRally game) {
        this.game = game;
        map = new TmxMapLoader().load("assets/maps/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREENSIZE * 2, SCREENSIZE * 2);
        //camera.zoom += 0.002f;
        camera.translate(-280, -550);

        //camera.position.set(camera.viewportHeight / 2f, camera.viewportWidth / 2f, 0);
        sheet = new ProgramSheet(1, map);

        robotImage = new Texture(Gdx.files.internal("assets/img/robot.png"));

        textureMap = new HashMap<>();
        textureMap.put("card", new Texture(Gdx.files.internal("assets/img/card.png")));
        textureMap.put("powerdownon", new Texture(Gdx.files.internal("assets/img/powerdownon.png")));
        textureMap.put("powerdownoff", new Texture(Gdx.files.internal("assets/img/powerdownoff.png")));

        textureMap.put("MoveForward", new Texture(Gdx.files.internal("assets/img/CardIcons/Forward.png")));
        textureMap.put("MoveBackwards", new Texture(Gdx.files.internal("assets/img/CardIcons/Backwards.png")));
        textureMap.put("RotationCardTURN_CLOCKWISE", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_ClockWise.png")));
        textureMap.put("RotationCardTURN_COUNTER_CLOCKWISE", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_Counter_Clockwise.png")));
        textureMap.put("RotationCardTURN_AROUND", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_Around.png")));

        factoryMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/factory.mp3"));

        // create the camera and the SpriteBatch
        batch = new SpriteBatch();
        HUDbatch = new SpriteBatch();
        shape = new ShapeRenderer();
        // create a Rectangle to logically represent the robot
        robot = new Robot(new Position(0, 0), Direction.LEFT, map);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // tell the camera to update its matrices.
        camera.update();
        renderer.setView(camera);
        renderer.render();

        //camera.update();
        // tell the SpriteBatch to render in the coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);
        // begin a new batch and draw tiles
        batch.begin();
        robot.keyboardMoveRobot();
        //robot.moveRobot();
        batch.draw(robotImage, robot.getPos().getX(), robot.getPos().getY());
        batch.end();
        ProgramSheetView.drawSheet(HUDbatch, shape, textureMap, sheet);
    }


    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        /*factoryMusic.setLooping(true);
        factoryMusic.play();*/
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        robotImage.dispose();
        factoryMusic.dispose();
        batch.dispose();
        shape.dispose();
    }

}

