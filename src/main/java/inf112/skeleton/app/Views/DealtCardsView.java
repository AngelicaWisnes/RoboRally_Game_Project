package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Gamer.Gamer;
import com.badlogic.gdx.graphics.Texture;
import inf112.skeleton.app.Gamer.IGamer;

import java.util.HashMap;
import java.util.List;

public class DealtCardsView {

    public static void drawCards(SpriteBatch batch, ShapeRenderer shape, HashMap<String, Texture> textureMap, IGamer gamer){
        List<AbstractCard> cards = gamer.getCards();
        for (int i = 0; i < cards.size(); i++) {
            AbstractCard card = cards.get(i);
            CardView.drawCardForHand(batch, card, textureMap, shape, i);
        }
    }
}
