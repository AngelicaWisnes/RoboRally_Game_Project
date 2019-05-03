package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;
import inf112.skeleton.app.Card.CardDealer;
import inf112.skeleton.app.Gamer.*;
import inf112.skeleton.app.Controller;
import inf112.skeleton.app.Enums.*;
import inf112.skeleton.app.Helpers.*;
import inf112.skeleton.app.Network.NetworkHandler;
import inf112.skeleton.app.Views.*;

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

    private IGamer hostGamer;
    private Controller controller;
    private ArrayList<IGamer> gamers = new ArrayList<>();

    private ArrayList<Position> lasers = new ArrayList<>();

    private Disposable[] disposables;

    boolean host;
    boolean online;
    private NetworkHandler networkHandler;

    public GameScreen(final RoboRally game, int numberOfPlayers) {
        this.game = game;
        textureMap = TextureLoader.getTextures();
        states = new StateHolder(RoundState.NONE, GameState.GAMING, numberOfPlayers);

        map = new TmxMapLoader().load("assets/maps/Originalmap.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.translate(-TILESIZE, -(Gdx.graphics.getHeight() / 2f - (MAPHEIGHT * TILESIZE) / 2f));

        LaserHandler.findLasers(lasers, map);

        factoryMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/factory.mp3"));
        pew = Gdx.audio.newSound(Gdx.files.internal("assets/laser.wav"));

        // create the camera and the SpriteBatch
        robotBatch = new SpriteBatch();
        HUDBatch = new SpriteBatch();
        shape = new ShapeRenderer();
        laserShape = new ShapeRenderer();
        controller = new Controller(states);
        disposables = new Disposable[]{map, renderer, factoryMusic, pew, robotBatch, HUDBatch, shape, laserShape};


        online = true;
        host = false;
        if (online) {
            networkHandler = new NetworkHandler();
            if (host){
                IGamer localhostgamer = new Gamer(map, "Host", 1, gamers);
                hostGamer = localhostgamer;
                IGamer networkclientgamer = new NetworkGamer(map, "Client", 2, gamers, networkHandler);
                gamers.add(localhostgamer);
                gamers.add(networkclientgamer);
            } else {
                IGamer networkhostgamer = new NetworkHostGamer(map, "Host", 1, gamers);
                IGamer localclientgamer; //min pc hvis jeg kobler til deg
                gamers.add(networkhostgamer);
                gamers.add(localclientgamer);

            }
        }else {
            addGamers(numberOfPlayers);
        }


    }

    private void addGamers(int numberOfPlayers) {
        hostGamer = new Gamer(map, "Player1", 1, gamers);

        gamers.add(hostGamer);
        for (int i = 1; i < numberOfPlayers; i++) {
            gamers.add(new AIGamer(map, "AI-" + i, i + 1, gamers));
        }
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

        } else {
            game.setScreen(new EndGameScreen(game, controller.getWinner()));

        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            LaserHandler.fireRobotLaser(hostGamer, gamers, laserShape);
        }
        sleep(20);
    }

    private void drawRobots() {
        robotBatch.setProjectionMatrix(camera.combined);
        robotBatch.begin();
        for (IGamer g : gamers) {
            String robotString = g.getImage();
            Position pos = g.getSheet().getRobot().getPos();
            robotBatch.draw(textureMap.get(robotString), pos.getX(), pos.getY());
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

    public boolean isHost() {
        return host;
    }

    public boolean isOnline() {
        return online;
    }
}