package inf112.skeleton.app.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainMenuScreen implements Screen {

    final RoboRally game;

    OrthographicCamera camera;
    Viewport viewport;

    Stage stage;
    Skin skin;

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
        viewport = new FitViewport(1920, 1280, camera);
        this.stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        Table table = new Table();
        table.setDebug(true);

        Table damageTable = new Table();
        Image damageRed = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damagered.png"))));
        Image damageOff = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageoff.png"))));
        Image damageOn1 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageon.png"))));
        Image damageOn2 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageon.png"))));
        Image damageOn3 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageon.png"))));
        Image damageOn4 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageon.png"))));
        Image damageOn5 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageon.png"))));
        Image damageOn6 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageon.png"))));
        Image damageOn7 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/damageon.png"))));
        damageTable.add(damageRed).width(55).height(55);
        damageTable.add(damageOff).width(55).height(55);
        damageTable.add(damageOn1).width(55).height(55);
        damageTable.add(damageOn2).width(55).height(55);
        damageTable.add(damageOn3).width(55).height(55);
        damageTable.add(damageOn4).width(55).height(55);
        damageTable.add(damageOn5).width(55).height(55);
        damageTable.add(damageOn6).width(55).height(55);
        damageTable.add(damageOn7).width(55).height(55);
        table.add(damageTable);
        table.row();

        Table lifeTable = new Table();
        Image lifeOn1 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/lifeon.png"))));
        Image lifeOn2 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/lifeon.png"))));
        Image lifeOff = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/lifeoff.png"))));
        Image powerdownon = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/powerdownon.png"))));

        lifeTable.add(lifeOff).width(100).height(100);
        lifeTable.add(lifeOn1).width(100).height(100);
        lifeTable.add(lifeOn2).width(100).height(100);
        lifeTable.add(new Image()).width(100).height(100);
        lifeTable.add(powerdownon).width(100).height(100);

        table.add(lifeTable);
        table.row();

        Table cardTable = new Table();
        table.add(cardTable);
        Image image1 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image2 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image3 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image4 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image5 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image11 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image22 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image33 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image44 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image55 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image111 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image222 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image333 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image444 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));
        Image image555 = new Image(new TextureRegionDrawable(new Texture(Gdx.files.internal("assets/img/card.png"))));

        cardTable.add(image1);
        cardTable.add(image2);
        cardTable.add(image3);
        cardTable.add(image4);
        cardTable.add(image5);
        table.row();
        Label robotType = new Label("Robot type: normal", skin);
        table.add(robotType);
        table.row();
        Label selectCards = new Label("Select cards: ", skin);
        table.add(selectCards);
        table.row();
        Table topCards = new Table();
        table.add(topCards);
        topCards.add(image11);
        topCards.add(image22);
        topCards.add(image33);
        topCards.add(image44);
        topCards.add(image55);
        table.row();

        Table bottomCards = new Table();
        table.add(bottomCards);
        bottomCards.add(image111);
        bottomCards.add(image222);
        bottomCards.add(image333);
        bottomCards.add(image444);

        table.row();

        table.setFillParent(true);
        stage.addActor(table);



    }

    @Override
    public void show() {
        stage.draw();

    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(camera.combined);

        stage.draw();
/*
        game.batch.begin();

        game.font.draw(game.batch, "" + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight(), 20, 20);

        game.font.draw(game.batch, "Main Menu ",200,80);
        game.font.draw(game.batch, "Press any button to begin game...", 200, 20);
        game.font.draw(game.batch, "Use numbers 1-9 to select cards", 200, 40);
        game.font.draw(game.batch, "Press enter to play cards, press space to play a blank card", 200, 60);
        game.batch.end();
*/

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }



    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        stage.getViewport().update(width, height, true);
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
        stage.dispose();

    }
}
