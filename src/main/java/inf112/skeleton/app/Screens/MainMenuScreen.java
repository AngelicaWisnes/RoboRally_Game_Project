package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

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
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        Texture main_screen = new Texture(Gdx.files.internal("assets/img/end_game/main_screen.png"));
        game.batch.draw(main_screen, Gdx.graphics.getWidth() / 2 - main_screen.getWidth() / 2, Gdx.graphics.getHeight() / 2 - main_screen.getHeight() / 2);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            game.setScreen(new GameScreen(game, 2)); // number of players
            dispose();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            game.setScreen(new GameScreen(game, 3)); // number of players
            dispose();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            game.setScreen(new GameScreen(game, 4)); // number of players
            dispose();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
            game.setScreen(new GameScreen(game, 5)); // number of players
            dispose();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {
            game.setScreen(new GameScreen(game, 6)); // number of players
            dispose();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_7)) {
            game.setScreen(new GameScreen(game, 7)); // number of players
            dispose();
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_8)) {
            game.setScreen(new GameScreen(game, 8)); // number of players
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
