package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.skeleton.app.Card.Card;

import java.util.HashMap;

public class CardView {

    private static BitmapFont font = new BitmapFont();

    private int cardWidth = 64;
    private int cardHeight = 32;

    public CardView (int cardWidth, int cardHeight) {
        this.cardWidth = cardWidth;
        this.cardHeight = cardHeight;
    }

    public static void drawCard(SpriteBatch batch, Card card, HashMap<String, Texture> textureMap, ShapeRenderer shape, int pos) {
        int priority = card.getPriority();
        shape.begin(ShapeRenderer.ShapeType.Filled); //I'm using the Filled ShapeType, but remember you have three of them
        shape.setColor(Color.WHITE);
        shape.rect(70 + 160 * pos, 50, 130, 180); //assuming you have created those x, y, width and height variables
        shape.end();

        batch.begin();
        batch.draw(textureMap.get(card.getKey()), 90 + 160 * pos, 90, 90, 90);

        font.setColor(Color.BLACK);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "" + card.getPriority());
        font.draw(batch, glyphLayout, (135  - glyphLayout.width)/2 + 160 * pos + 70, 210);

        glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,card.getDescription());
        font.draw(batch, glyphLayout, (135  - glyphLayout.width)/2 + 160 * pos + 70, 85);

        batch.end();

    }
}
