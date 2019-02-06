package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloWorld implements ApplicationListener {
    private SpriteBatch batch;
    private Sprite tile;
    private OrthographicCamera cam;

    @Override
    public void create() {
        cam = new OrthographicCamera(100,100);
        batch = new SpriteBatch();
        tile = new Sprite(new Texture("assets/factorytile.png"));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {
        float squareWidth = cam.viewportWidth / 8;
        float squareHeight = cam.viewportHeight / 8;
        tile.setSize(80,80);
        batch.begin();
        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                tile.setX(x * squareWidth);
                tile.setY(y * squareHeight);
                tile.draw(batch);
             }
        }
        batch.end();

/*
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        tile.draw(batch);
        batch.end();
*/
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
