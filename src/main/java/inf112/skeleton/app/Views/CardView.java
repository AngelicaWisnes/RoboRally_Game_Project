package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.skeleton.app.Card.AbstractCard;

import java.util.HashMap;

public class CardView {

    private static BitmapFont font = new BitmapFont();

    public static void drawCardForSheet(SpriteBatch batch, AbstractCard card, HashMap<String, Texture> textureMap, ShapeRenderer shape, int pos) {
        if (card == null)
            return;
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect((1130 + 90 * pos) , 605, 80, 90);

        shape.end();

        batch.begin();
        batch.draw(textureMap.get(card.getKey()), (1145 + 90 * pos), 645, 45, 45);

        font.setColor(Color.BLACK);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "" + card.getPriority());
        font.draw(batch, glyphLayout, (1155 + 90 * pos), 642);
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,card.getDescription());
        font.draw(batch, glyphLayout, (1132 + 90 * pos), 622);




        batch.end();
    }

    public static void drawCardForHand(SpriteBatch batch, AbstractCard card, HashMap<String, Texture> textureMap, ShapeRenderer shape, int pos){
        if (card == null){
            return;
        }
        int x = 0;
        int y = 0;
        if (pos > 4){
            x -= 400;
            y -= 100;
        }
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect((1130 + 90 * pos) + x, 250 + y, 80, 90);
        shape.end();

        batch.begin();
        batch.draw(textureMap.get(card.getKey()), (1145 + 90 * pos) + x, 285 + y, 45, 45);
        font.setColor(Color.BLACK);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "" + card.getPriority());
        font.draw(batch, glyphLayout, (1155 + 90 * pos) + x, 280 + y);
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,card.getDescription());
        font.draw(batch, glyphLayout, (1132 + 90 * pos) + x, 265 + y);
        batch.end();
    }
}
