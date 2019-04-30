package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import inf112.skeleton.app.Gamer.Gamer;
import inf112.skeleton.app.Gamer.IGamer;

public class EndGameScreen implements Screen {

    private final RoboRally game;
    private OrthographicCamera camera;
    private IGamer winner;

    EndGameScreen(final RoboRally game, IGamer winner) {
        this.game = game;
        this.winner = winner;
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
        game.font.draw(game.batch, winner.getName() + " has won", 150, Gdx.graphics.getHeight() / 2 + 300);
        Texture game_over_win = new Texture(Gdx.files.internal("assets/img/end_game/game_over_win.png"));
        Texture game_over_lose = new Texture(Gdx.files.internal("assets/img/end_game/game_over_lose.png"));
        if (winner instanceof Gamer) {
            game.batch.draw(game_over_win, Gdx.graphics.getWidth() / 2 - game_over_win.getWidth() / 2, Gdx.graphics.getHeight() / 2 - game_over_win.getHeight() / 2);
        } else {
            game.batch.draw(game_over_lose, Gdx.graphics.getWidth() / 2 - game_over_win.getWidth() / 2, Gdx.graphics.getHeight() / 2 - game_over_win.getHeight() / 2);
        }
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
