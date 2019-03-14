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
import inf112.skeleton.app.Controller;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Gamer;
import inf112.skeleton.app.Robot.IRobot;
import inf112.skeleton.app.Views.DealtCardsView;
import inf112.skeleton.app.Views.ProgramSheetView;


public class GameScreen implements Screen {
    final RoboRally game;
    private CardState state;

    private HashMap<String, Texture> textureMap;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private ShapeRenderer shape;

    private Music factoryMusic;
    private SpriteBatch batch;
    private SpriteBatch HUDbatch;
    private IRobot robot;
    private Gamer gamer;
    private Controller controller;

    public static final int TILESIZE = 64;
    private final int NTILES = 10;
    private final int SCREENSIZE = TILESIZE * NTILES;


    public GameScreen(final RoboRally game) {
        this.game = game;
        state = CardState.NOCARDS;
        map = new TmxMapLoader().load("assets/maps/test_flag.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREENSIZE * 2, SCREENSIZE * 2);
        //camera.zoom += 0.002f;
        camera.translate(-280, -550);

        fillTextureMap();

        factoryMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/factory.mp3"));

        // create the camera and the SpriteBatch
        batch = new SpriteBatch();
        HUDbatch = new SpriteBatch();
        shape = new ShapeRenderer();
        gamer = new Gamer(map, "Player1");
        robot = gamer.getSheet().getRobot();
        controller = new Controller(gamer);


    }

    private void fillTextureMap() {
        textureMap = new HashMap<>();
        textureMap.put("robot", new Texture(Gdx.files.internal("assets/img/robot.png")));
        textureMap.put("robot_north", new Texture(Gdx.files.internal("assets/img/robot_north.png")));
        textureMap.put("robot_east", new Texture(Gdx.files.internal("assets/img/robot_east.png")));
        textureMap.put("robot_south", new Texture(Gdx.files.internal("assets/img/robot_south.png")));
        textureMap.put("robot_west", new Texture(Gdx.files.internal("assets/img/robot_west.png")));
        textureMap.put("card", new Texture(Gdx.files.internal("assets/img/card.png")));
        textureMap.put("powerdownon", new Texture(Gdx.files.internal("assets/img/powerdownon.png")));
        textureMap.put("powerdownoff", new Texture(Gdx.files.internal("assets/img/powerdownoff.png")));
        textureMap.put("MoveForward", new Texture(Gdx.files.internal("assets/img/CardIcons/Forward.png")));
        textureMap.put("MoveBackwards", new Texture(Gdx.files.internal("assets/img/CardIcons/Backwards.png")));
        textureMap.put("RotationCardTURN_CLOCKWISE", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_ClockWise.png")));
        textureMap.put("RotationCardTURN_COUNTER_CLOCKWISE", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_Counter_Clockwise.png")));
        textureMap.put("RotationCardTURN_AROUND", new Texture(Gdx.files.internal("assets/img/CardIcons/Turn_Around.png")));

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        controller.runGame(state);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        robot.keyboardMovesRobot();
        String robotString = "";
        switch (gamer.getSheet().getRobot().getDir()) {
            case UP:
                robotString = "robot_north";
                break;
            case RIGHT:
                robotString = "robot_east";
                break;
            case DOWN:
                robotString = "robot_south";
                break;
            case LEFT:
                robotString = "robot_west";
                break;
        }

        batch.draw(textureMap.get(robotString), robot.getPos().getX(), robot.getPos().getY());
        batch.end();
        ProgramSheetView.drawSheet(HUDbatch, shape, textureMap, gamer.getSheet());
        if (state.equals(CardState.DEALTCARDS)) {
            DealtCardsView.drawCards(HUDbatch, shape, textureMap, gamer);
        }
        stateBasedMovement();
    }

    private void stateBasedMovement() {
        if (state.equals(CardState.NOCARDS)) {
            camera.zoom += 0.6;
            camera.translate(0, -390);
            controller.runGame(state);
            state = CardState.DEALTCARDS;
        }
        if (state.equals(CardState.DEALTCARDS) && controller.isGamerReady()) {
            state = CardState.SELECTEDCARDS;
        }
        if (state.equals(CardState.SELECTEDCARDS)) {
            camera.zoom -= 0.6;
            camera.translate(0, 390);
            controller.runGame(state);
            state = CardState.PAUSED;
        }

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
        factoryMusic.dispose();
        batch.dispose();
        shape.dispose();
    }

}

