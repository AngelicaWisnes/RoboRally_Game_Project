package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import java.util.HashMap;
import inf112.skeleton.app.TileTypes.iTile;


public class BoardGUI extends ApplicationAdapter {
    private HashMap<String, Texture> textureMap;
    private Texture robotImage;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;



    private Board board;
    private Music factoryMusic;
    private SpriteBatch batch;
    private Rectangle robot;

    private final int TILESIZE = 64;
    private final int NTILES = 10;
    private final int SCREENSIZE = TILESIZE*NTILES;
    //private final int OFFSET = (SCREENSIZE/2);
    private final int OFFSET = 0;


    @Override
    public void create() {
        map = new TmxMapLoader().load("assets/maps/map.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCREENSIZE * 2, SCREENSIZE * 2);


        board = new Board(NTILES);
        textureMap = new HashMap<>();
        robotImage = new Texture(Gdx.files.internal("assets/img/robot.png"));
        factoryMusic = Gdx.audio.newMusic(Gdx.files.internal("assets/factory.mp3"));
        // create textures and add to hashmap
        populateTextureMap();

        // start the playback of the background music immediately
        factoryMusic.setLooping(true);
        factoryMusic.play();

        // create the camera and the SpriteBatch

        batch = new SpriteBatch();

        // create a Rectangle to logically represent the robot
        robot = new Rectangle();
        robot.x = 0; // center the robot horizontally
        robot.y = 0; // bottom left corner of the robot is 20 pixels above the bottom screen edge
        robot.width = TILESIZE;
        robot.height = TILESIZE;
    }


    private void populateTextureMap(){
        textureMap.put("factoryTile", new Texture(Gdx.files.internal("assets/img/factorytile.png")));
        textureMap.put("conveyor_up", new Texture(Gdx.files.internal("assets/img/conveyor_up.png")));
        textureMap.put("conveyor_down", new Texture(Gdx.files.internal("assets/img/conveyor_down.png")));
        textureMap.put("conveyor_left", new Texture(Gdx.files.internal("assets/img/conveyor_left.png")));
        textureMap.put("conveyor_right", new Texture(Gdx.files.internal("assets/img/conveyor_right.png")));
        textureMap.put("dbl_conveyor_up", new Texture(Gdx.files.internal("assets/img/dbl_conveyor_up.png")));
        textureMap.put("dbl_conveyor_down", new Texture(Gdx.files.internal("assets/img/dbl_conveyor_down.png")));
        textureMap.put("dbl_conveyor_left", new Texture(Gdx.files.internal("assets/img/dbl_conveyor_left.png")));
        textureMap.put("dbl_conveyor_right", new Texture(Gdx.files.internal("assets/img/dbl_conveyor_right.png")));
        textureMap.put("rotate_cw", new Texture(Gdx.files.internal("assets/img/rotate_cw.png")));
        textureMap.put("rotate_ccw", new Texture(Gdx.files.internal("assets/img/rotate_ccw.png")));
        textureMap.put("pit", new Texture(Gdx.files.internal("assets/img/pit.png")));
        textureMap.put("void", new Texture(Gdx.files.internal("assets/img/pit.png")));
        textureMap.put("flag", new Texture(Gdx.files.internal("assets/img/flag.png")));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
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
        batch.draw(robotImage, 0,0);
        batch.end();

        moveRobot();
    }

    private void moveRobot() {
        //move the robot one tile in a direction
        if(Gdx.input.isKeyJustPressed(Keys.LEFT)) robot.x -= TILESIZE;
        if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) robot.x += TILESIZE;
        if(Gdx.input.isKeyJustPressed(Keys.UP)) robot.y += TILESIZE;
        if(Gdx.input.isKeyJustPressed(Keys.DOWN)) robot.y -= TILESIZE;


        // make sure the robot stays within the screen bounds
/*
        if(robot.x > 0) robot.x = 0;
        if(robot.x > SCREENSIZE - TILESIZE) robot.x = SCREENSIZE - TILESIZE;
        if(robot.y < 0) robot.y = 0;
        if(robot.y > SCREENSIZE - TILESIZE) robot.y = SCREENSIZE - TILESIZE;
*/

        if(Gdx.input.isKeyPressed(Keys.RIGHT)){
            int x = (int)robot.x / 64;
            int y = (int)robot.y / 64;

            TiledMapTileLayer.Cell cell = ((TiledMapTileLayer) map.getLayers().get(0)).getCell(x,y  );
            System.out.println(cell.getTile().getId());
        }
    }



    @Override
    public void dispose() {
        // dispose of all resources
        robotImage.dispose();
        factoryMusic.dispose();
        batch.dispose();
    }
}