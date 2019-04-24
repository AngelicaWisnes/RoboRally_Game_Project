package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ScreenUtils;
import inf112.skeleton.app.AIGamer;
import inf112.skeleton.app.Controller;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.GameState;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Gamer;
import inf112.skeleton.app.Helpers.LaserHandler;
import inf112.skeleton.app.Helpers.Position;
import inf112.skeleton.app.Helpers.StateHolder;
import inf112.skeleton.app.IGamer;
import inf112.skeleton.app.Views.DealtCardsView;
import inf112.skeleton.app.Views.ProgramSheetView;
import inf112.skeleton.app.Views.StateTextView;

import java.util.ArrayList;
import java.util.HashMap;

import static inf112.skeleton.app.Helpers.Constants.*;


public class GameScreen implements Screen {
    private RoboRally game;

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
    private SpriteBatch HUDBatch;

    private Gamer hostGamer;
    private Controller controller;
    private ArrayList<IGamer> gamers = new ArrayList<>();

    private ArrayList<Position> lasers;

    private Disposable[] disposables;



    public GameScreen(final RoboRally game, int numberOfPlayers) {
        this.game = game;
        states = new StateHolder(RoundState.NONE, GameState.GAMING, numberOfPlayers);

        map = new TmxMapLoader().load("assets/maps/Originalmap.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(-TILESIZE, -(Gdx.graphics.getHeight() / 2f - (MAPHEIGHT * TILESIZE) / 2f));

        fillTextureMap();
        findLasers();

        factoryMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/factory.mp3"));
        pew = Gdx.audio.newSound(Gdx.files.internal("assets/laser.wav"));

        // create the camera and the SpriteBatch
        robotBatch = new SpriteBatch();
        HUDBatch = new SpriteBatch();
        shape = new ShapeRenderer();
        laserShape = new ShapeRenderer();
        hostGamer = new Gamer(map, "Player1", 1);
        controller = new Controller(states);

        gamers.add(hostGamer);
        for (int i = 1; i < numberOfPlayers; i++) {
            gamers.add(new AIGamer(map, "AI-" + i, i + 1));
        }
        disposables = new Disposable[]{map, renderer, factoryMusic, pew, robotBatch, HUDBatch, shape, laserShape};
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
        drawRobots();
        laserShape.setProjectionMatrix(camera.combined);
        if (!states.getGameState().equals(GameState.GAME_OVER)) {
            ProgramSheetView.drawSheet(HUDBatch, shape, textureMap, hostGamer.getSheet());
            StateTextView.drawStates(HUDBatch, states); //testing purposes only
            hostGamer.getSheet().getRobot().keyboardMovesRobot(); //testing purposes only
            states = controller.runGame(states, this);
            stateBasedBoardActions();

        }else{
            game.setScreen(new EndGameScreen(game));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            LaserHandler.fireRobotLaser(hostGamer, gamers, laserShape);

        }
        System.out.println(gamers.get(1).getSheet().getDamage());

        sleep(20);
    }

    private void drawRobots() {
        robotBatch.setProjectionMatrix(camera.combined);
        robotBatch.begin();
        for (IGamer g : gamers) {
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
    }

    private void stateBasedBoardActions() {
        if (gamers.get(0).getCardState().equals(CardState.DEALTCARDS)) {
            DealtCardsView.drawCards(HUDBatch, shape, textureMap, hostGamer);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        factoryMusic.setLooping(true);
        /*factoryMusic.play();*/
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
        for (Disposable d : disposables) {
            d.dispose();
        }
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

    public ShapeRenderer getLaserShape() {
        return laserShape;
    }

    public Sound getPew() {
        return pew;
    }

    public ArrayList<Position> getLasers() {
        return lasers;
    }

    public ArrayList<IGamer> getGamers() {
        return gamers;
    }
}