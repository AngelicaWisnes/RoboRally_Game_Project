package inf112.skeleton.app.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class UIStage {
    public static Stage getStage(){
        //TODO move: Gdx.input.setInputProcessor(stage);
        Stage stage = new Stage();
        Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        Table table = new Table();
        //table.setDebug(true);

        Table damageTable = new Table();
        Image damageRed = new Image(new Texture(Gdx.files.internal("assets/img/damagered.png")));
        Image damageOff = new Image(new Texture(Gdx.files.internal("assets/img/damageoff.png")));
        Image damageOn1 = new Image(new Texture(Gdx.files.internal("assets/img/damageon.png")));
        Image damageOn2 = new Image(new Texture(Gdx.files.internal("assets/img/damageon.png")));
        Image damageOn3 = new Image(new Texture(Gdx.files.internal("assets/img/damageon.png")));
        Image damageOn4 = new Image(new Texture(Gdx.files.internal("assets/img/damageon.png")));
        Image damageOn5 = new Image(new Texture(Gdx.files.internal("assets/img/damageon.png")));
        Image damageOn6 = new Image(new Texture(Gdx.files.internal("assets/img/damageon.png")));
        Image damageOn7 = new Image(new Texture(Gdx.files.internal("assets/img/damageon.png")));
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
        Image lifeOn1 = new Image(new Texture(Gdx.files.internal("assets/img/lifeon.png")));
        Image lifeOn2 = new Image(new Texture(Gdx.files.internal("assets/img/lifeon.png")));
        Image lifeOff = new Image(new Texture(Gdx.files.internal("assets/img/lifeoff.png")));
        Image powerdownon = new Image(new Texture(Gdx.files.internal("assets/img/powerdownon.png")));
        lifeTable.add(lifeOff).width(100).height(100);
        lifeTable.add(lifeOn1).width(100).height(100);
        lifeTable.add(lifeOn2).width(100).height(100);
        lifeTable.add(new Image()).width(100).height(100);
        lifeTable.add(powerdownon).width(100).height(100);
        table.add(lifeTable);
        table.row();

        Table cardTable = new Table();
        Image image1 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image2 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image3 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image4 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image5 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image11 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image22 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image33 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image44 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image55 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image111 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image222 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image333 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));
        Image image444 = new Image(new Texture(Gdx.files.internal("assets/img/card.png")));

        cardTable.add(image1);
        cardTable.add(image2);
        cardTable.add(image3);
        cardTable.add(image4);
        cardTable.add(image5);
        table.add(cardTable);
        table.row();

        Label robotType = new Label("Robot type: normal", skin);
        table.add(robotType);
        table.row();

        Label selectCards = new Label("Select cards: ", skin);
        table.add(selectCards);
        table.row();

        Table topCards = new Table();
        topCards.add(image11);
        topCards.add(image22);
        topCards.add(image33);
        topCards.add(image44);
        topCards.add(image55);
        table.add(topCards);
        table.row();

        Table bottomCards = new Table();
        bottomCards.add(image111);
        bottomCards.add(image222);
        bottomCards.add(image333);
        bottomCards.add(image444);
        table.add(bottomCards);
        table.row();

        table.setFillParent(true);
        stage.addActor(table);
        stage.getRoot().setX(64 * 8);
        return stage;
    }
}
