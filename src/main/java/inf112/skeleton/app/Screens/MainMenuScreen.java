package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {

    private final RoboRally game;
    private OrthographicCamera camera;

    MainMenuScreen(final RoboRally game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Main Menu ",150, Gdx.graphics.getHeight()/2 + 150);
        game.font.draw(game.batch, "Press any button to begin game...", 150, Gdx.graphics.getHeight()/2);
        game.font.draw(game.batch, "Use numbers 1-9 to select cards", 150, Gdx.graphics.getHeight()/2 - 150);
        game.font.draw(game.batch, "Press enter to play cards, press space to play a blank card", 150, Gdx.graphics.getHeight()/2 - 300);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new GameScreen(game, 2)); // number of players
            dispose();
        }
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
