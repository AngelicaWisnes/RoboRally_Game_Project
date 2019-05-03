package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Gamer.IGamer;

import java.util.ArrayList;
import java.util.HashMap;

public class OpponentView {
    private static BitmapFont font = new BitmapFont();

    public static void drawOpponents(ArrayList<IGamer> gamers, SpriteBatch batch, HashMap<String, Texture> textureMap, ShapeRenderer shape) {
        for (int i = 1; i < gamers.size(); i++) {
            drawOpponent(gamers.get(i), batch, textureMap, i - 1);
            drawOpponentCards(gamers.get(i), batch, textureMap, shape, i - 1);
        }
    }

    private static void drawOpponent(IGamer gamer, SpriteBatch batch, HashMap<String, Texture> textureMap, int i) {
        String lives = "" + gamer.getSheet().getLives();
        String damage = "" + gamer.getSheet().getDamage();
        String isPowerDown = "" + gamer.getSheet().isPowerDown();

        batch.begin();
        batch.draw(textureMap.get(gamer.getImage()), 1640f, 1050f - (i * 100), 50f, 50f);
        font.draw(batch, "Lives: " + lives + " Damage: " + damage + " PowerDown: " + isPowerDown, 1650f, 1050f - (i * 100));
        font.getData().setScale(1.5f, 1.5f);
        batch.end();
    }

    private static void drawOpponentCards(IGamer gamer, SpriteBatch batch, HashMap<String, Texture> textureMap, ShapeRenderer shape, int count) {
        if (gamer.getCardState().equals(CardState.SELECTEDCARDS)) {
            for (int i = 0; i < 5; i++) {
                CardView.drawOpponentCard(batch, gamer.getSheet().getSlot(i).getCard(), textureMap, shape, i, count);
            }
        }

    }

}