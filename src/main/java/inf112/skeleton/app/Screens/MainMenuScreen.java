package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import inf112.skeleton.app.Views.UIStage;

public class MainMenuScreen implements Screen {

    final RoboRally game;

    OrthographicCamera camera;

    Stage stage;


    public MainMenuScreen(final RoboRally game) {
        this.game = game;
        Graphics.DisplayMode m = null;
        for (Graphics.DisplayMode mode : Gdx.graphics.getDisplayModes()) {
            if (m == null) {
                m = mode;
            } else {
                if (m.width < mode.width) {
                    m = mode;
                }
            }
        }
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());

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
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        //TODO insert Scene2Dui
        game.font.draw(game.batch, "" + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight(), 20, 20);

        game.font.draw(game.batch, "Main Menu ",200,80);
        game.font.draw(game.batch, "Press any button to begin game...", 200, 20);
        game.font.draw(game.batch, "Use numbers 1-9 to select cards", 200, 40);
        game.font.draw(game.batch, "Press enter to play cards, press space to play a blank card", 200, 60);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }



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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
