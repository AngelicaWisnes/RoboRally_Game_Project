package inf112.skeleton.app.Screens;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import inf112.skeleton.app.AIGamer;
import inf112.skeleton.app.Controller;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.GameState;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Gamer;
import inf112.skeleton.app.Helpers.LaserHandler;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.IGamer;
import inf112.skeleton.app.Robot.IRobot;
import inf112.skeleton.app.Helpers.StateHolder;
import inf112.skeleton.app.Views.DealtCardsView;
import inf112.skeleton.app.Views.ProgramSheetView;
import inf112.skeleton.app.Views.StateTextView;


public class GameScreen implements Screen {
    final RoboRally game;
    private StateHolder states;


    private HashMap<String, Texture> textureMap;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    private ShapeRenderer shape;
    private ShapeRenderer laserShape;

    private Music factoryMusic;
    private Sound pew;
    private SpriteBatch robotBatch;
    private SpriteBatch HUDbatch;
    private IRobot robot;
    private Gamer gamer;
    private Controller controller;

    private ArrayList<Position> lasers;
    private ArrayList<IGamer> gamers =  new ArrayList<>();

    public static final int TILESIZE = 64;
    private final int MAPWIDTH = 16;
    private final int MAPHEIGHT = 12;

    public GameScreen(final RoboRally game, int numberOfPlayers) {
        this.game = game;
        states = new StateHolder(CardState.NOCARDS, RoundState.NONE, GameState.GAMING, numberOfPlayers);

        map = new TmxMapLoader().load("assets/maps/Originalmap.tmx");

        MapProperties prop = map.getProperties();
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        float newX = 64; //Gdx.graphics.getWidth() / 2 - (16*64) / 2;
        float newY = Gdx.graphics.getHeight() / 2 - (12 * 64) / 2;
        camera.translate(-newX, -newY);


        fillTextureMap();
        findLasers();

        factoryMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/factory.mp3"));
        pew = Gdx.audio.newSound(Gdx.files.internal("assets/laser.wav"));


        // create the camera and the SpriteBatch
        robotBatch = new SpriteBatch();
        HUDbatch = new SpriteBatch();
        shape = new ShapeRenderer();
        laserShape = new ShapeRenderer();
        gamer = new Gamer(map, "Player1", 1);
        robot = gamer.getSheet().getRobot();
        controller = new Controller(gamer, states);

        //TODO for multiple players, also get playerNumber in order
        gamers.add(gamer);
        gamers.add(new AIGamer(map, "AI-1", 2));


    }

    private void findLasers() {
        lasers = new ArrayList<>();
        for (int i = 0; i < MAPWIDTH; i++) {
            for (int j = 0; j < MAPHEIGHT; j++) {
                TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(i, j);
                int id = cell.getTile().getId();
                if (id == 929 || id == 646) {
                    lasers.add(new Position(i * TILESIZE, j * TILESIZE));
                }
            }
        }
    }

    private void fillTextureMap() {
        textureMap = new HashMap<>();
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
        textureMap.put("Blank card", new Texture(Gdx.files.internal("assets/img/CardIcons/Blank.png")));
        textureMap.put("sheet", new Texture(Gdx.files.internal("assets/img/sheet.png")));
        textureMap.put("lifeon", new Texture(Gdx.files.internal("assets/img/lifeon.png")));
        textureMap.put("lifeoff", new Texture(Gdx.files.internal("assets/img/lifeoff.png")));
        textureMap.put("damageoff", new Texture(Gdx.files.internal("assets/img/damageoff.png")));
        textureMap.put("damageon", new Texture(Gdx.files.internal("assets/img/damageon.png")));
        textureMap.put("damagered", new Texture(Gdx.files.internal("assets/img/damagered.png")));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        renderer.setView(camera);
        renderer.render();

        robotBatch.setProjectionMatrix(camera.combined);
        //for each robot, get the string, draw the robot
        robotBatch.begin();
        for (IGamer g : gamers){
            String robotString = "";
            switch (g.getSheet().getRobot().getDir()) {
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
            robotBatch.draw(textureMap.get(robotString), g.getSheet().getRobot().getPos().getX(), g.getSheet().getRobot().getPos().getY());
        }
        robotBatch.end();

        laserShape.setProjectionMatrix(camera.combined);
        //TODO if gameover, run game over screen, else run the following block
        if (!states.getGameState().equals(GameState.GAME_OVER)) {
            ProgramSheetView.drawSheet(HUDbatch, shape, textureMap, gamer.getSheet());
            StateTextView.drawStates(HUDbatch, states);
            robot.keyboardMovesRobot();
            states = controller.runGame(states,gamers);
            stateBasedBoardActions();
        }
        sleep(20);
    }

    private void stateBasedBoardActions() {
        if (states.getCardState().equals(CardState.DEALTCARDS) && controller.isGamerReady()) {
            states.setCardState(CardState.SELECTEDCARDS);
        } else if (states.getCardState().equals(CardState.DEALTCARDS)) {
            DealtCardsView.drawCards(HUDbatch, shape, textureMap, gamer);
        } else if (states.getCardState().equals(CardState.SELECTEDCARDS)) {
            states.setCardState(CardState.PLAYINGCARDS);
        }

        if (states.getRoundState().equals(RoundState.PART5)) {
            LaserHandler.fireBoardLaser(lasers, gamer, laserShape, pew, TILESIZE);
            states.setRoundState(RoundState.PART6);

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
        robotBatch.dispose();
        shape.dispose();
    }

    private void screenshot() {
        byte[] pixels = ScreenUtils.getFrameBufferPixels(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), true);
        for (int i = 4; i < pixels.length; i += 4) {
            pixels[i - 1] = (byte) 255;
        }

        Pixmap pixmap = new Pixmap(Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), Pixmap.Format.RGBA8888);
        BufferUtils.copy(pixels, 0, pixmap.getPixels(), pixels.length);
        PixmapIO.writePNG(Gdx.files.external("mypixmap.png"), pixmap);
        pixmap.dispose();
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}