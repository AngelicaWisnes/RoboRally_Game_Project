package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.skeleton.app.Gamer.IGamer;

import java.util.ArrayList;
import java.util.HashMap;

public class OpponentView {
    public static void drawOpponents(ArrayList<IGamer> gamers, SpriteBatch batch, HashMap<String, Texture> textureMap) {
        for (int i = 1; i < gamers.size(); i++) {
            drawOpponent(gamers.get(i), batch, textureMap, i - 1);
        }
    }

    private static void drawOpponent(IGamer gamer, SpriteBatch batch, HashMap<String, Texture> textureMap, int i) {
        batch.begin();
        batch.draw(textureMap.get(gamer.getImage()), 1620f, 1050f - (i * 100), 50f, 50f);
        batch.end();
    }

}