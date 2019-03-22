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

    private int cardWidth = 64;
    private int cardHeight = 32;

    public CardView (int cardWidth, int cardHeight) {
        this.cardWidth = cardWidth;
        this.cardHeight = cardHeight;
    }
    public static void drawCardForSheet(SpriteBatch batch, AbstractCard card, HashMap<String, Texture> textureMap, ShapeRenderer shape, int pos) {
        if (card == null)
            return;
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(960 + 75 * pos, 465, 60, 90);
        shape.end();

        batch.begin();
        batch.draw(textureMap.get(card.getKey()), 970 + 75 * pos, 510, 40, 40);

        font.setColor(Color.RED);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "" + card.getPriority());
        //font.draw(batch, glyphLayout, (2250  - glyphLayout.width)/2 + (80 * pos + 70), 642);
        font.draw(batch, glyphLayout, 975 + 75*pos,505);
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,card.getDescription());
        //font.draw(batch, glyphLayout, (2250  - glyphLayout.width)/2 + (80 * pos + 70), 622);
        font.draw(batch, glyphLayout, 965 + 75*pos, 490);
        batch.end();

    }
    public static void drawCardForHand(SpriteBatch batch, AbstractCard card, HashMap<String, Texture> textureMap, ShapeRenderer shape, int pos){
        if (card == null){
            return;
        }
        int x = 0;
        int y = 0;
        if (pos > 4){
            x -= 350;
            y -= 100;
        }
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.WHITE);
        shape.rect(960 + 75 * pos + x, 165 + y, 60, 90);
        shape.end();

        batch.begin();
        batch.draw(textureMap.get(card.getKey()), 970 + 75 * pos + x, 210 + y, 40, 40);

        font.setColor(Color.RED);
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "" + card.getPriority());
        font.draw(batch, glyphLayout, 975 + 75*pos + x,205+y);
        glyphLayout = new GlyphLayout();
        glyphLayout.setText(font,card.getDescription());
        font.draw(batch, glyphLayout, 965 + 75*pos + x, 190+y);
        batch.end();
    }

}
