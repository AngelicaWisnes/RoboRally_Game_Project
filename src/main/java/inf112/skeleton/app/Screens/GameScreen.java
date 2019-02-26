package inf112.skeleton.app.Screens;
import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import inf112.skeleton.app.Board;
import inf112.skeleton.app.ProgramSheet;
import inf112.skeleton.app.ProgramSheetView;

public class GameScreen implements Screen {
    final RoboRally game;

    private HashMap<String, Texture> textureMap;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;


    private Texture robotImage;
    private Texture cardImage;

    private ProgramSheet sheet;


    private Board board;
    private Music factoryMusic;
    private SpriteBatch batch;
    private SpriteBatch HUDbatch;
    private Rectangle robot;

    private final int TILESIZE = 64;
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

        sheet = new ProgramSheet(1, board, map);

        robotImage = new Texture(Gdx.files.internal("assets/img/robot.png"));
        cardImage = new Texture(Gdx.files.internal("assets/img/card.png"));

        textureMap = new HashMap<>();
        textureMap.put("card", cardImage);

        factoryMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/factory.mp3"));

        // create the camera and the SpriteBatch
        batch = new SpriteBatch();
        HUDbatch = new SpriteBatch();
        // create a Rectangle to logically represent the robot
        robot = new Rectangle();
        robot.x = 0; // center the robot horizontally
        robot.y = 0; // bottom left corner of the robot is 20 pixels above the bottom screen edge
        robot.width = TILESIZE;
        robot.height = TILESIZE;

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // tell the camera to update its matrices.
        renderer.setView(camera);
        renderer.render();

        //camera.update();
        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);
        // begin a new batch and draw tiles
        batch.begin();
        //drawBoard();
        batch.draw(robotImage, robot.x, robot.y);
        batch.end();
        HUDbatch.begin();
        ProgramSheetView.drawSheet(HUDbatch, textureMap, sheet);
        HUDbatch.end();
        moveRobot();

    }

    private void moveRobot() {
        //move the robot one tile in a direction
        if (Gdx.input.isKeyJustPressed(Keys.LEFT)) robot.x -= TILESIZE;
        if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) robot.x += TILESIZE;
        if (Gdx.input.isKeyJustPressed(Keys.UP)) robot.y += TILESIZE;
        if (Gdx.input.isKeyJustPressed(Keys.DOWN)) robot.y -= TILESIZE;


/*
        if(robot.x > 0) robot.x = 0;
        if(robot.x > SCREENSIZE - TILESIZE) robot.x = SCREENSIZE - TILESIZE;
        if(robot.y < 0) robot.y = 0;
        if(robot.y > SCREENSIZE - TILESIZE) robot.y = SCREENSIZE - TILESIZE;
*/

        if (Gdx.input.isKeyJustPressed(Keys.RIGHT) || Gdx.input.isKeyJustPressed(Keys.LEFT) || Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.DOWN)) {
            int x = (int) robot.x / 64;
            int y = (int) robot.y / 64;
            try {
                TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(x, y);
                System.out.println(cell.getTile().getId());

            } catch (Exception e) {
                System.out.println("du har dødd");

            }

        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        factoryMusic.setLooping(true);
        factoryMusic.play();
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
    }

}

