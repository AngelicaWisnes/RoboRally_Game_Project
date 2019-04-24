package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class EndGameScreen implements Screen {

    private final RoboRally game;
    private OrthographicCamera camera;

    EndGameScreen(final RoboRally game) {
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
        Texture game_over_win = new Texture(Gdx.files.internal("assets/img/end_game/game_over_win.png"));
        Texture game_over_lose = new Texture(Gdx.files.internal("assets/img/end_game/game_over_lose.png"));
        //game.batch.draw(game_over_win, Gdx.graphics.getWidth() / 2 - game_over_win.getWidth() / 2, Gdx.graphics.getHeight() / 2 - game_over_win.getHeight()/2);
        game.batch.draw(game_over_lose, Gdx.graphics.getWidth() / 2 - game_over_win.getWidth() / 2, Gdx.graphics.getHeight() / 2 - game_over_win.getHeight()/2);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            game.setScreen(new MainMenuScreen(game)); // number of players
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
