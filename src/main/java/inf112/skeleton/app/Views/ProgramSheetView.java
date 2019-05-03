package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Gamer.IGamer;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.HashMap;

public class ProgramSheetView {
    static BitmapFont font = new BitmapFont();

    public static void drawSheet(SpriteBatch batch, ShapeRenderer shape, HashMap<String, Texture> textureMap, IGamer gamer) {
        ProgramSheet sheet = gamer.getSheet();
        drawUseInfo(gamer, batch, textureMap);
        drawPower(batch, textureMap, sheet);
        drawLives(batch, textureMap, sheet);
        drawDamage(batch, textureMap, sheet);
        drawCards(batch, sheet, textureMap, shape);
    }

    private static void drawUseInfo(IGamer gamer, SpriteBatch batch, HashMap<String, Texture> textureMap) {
        String name = gamer.getName();
        String image = gamer.getImage();

        batch.begin();
        font.draw(batch, name, 1155, 920);
        font.getData().setScale(3f, 3f);
        batch.draw(textureMap.get(image), 1200, 920, 50, 50);
        batch.end();
    }

    private static void drawLives(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        int lives = sheet.getLives();
        batch.begin();
        batch.draw(lives > 0 ? textureMap.get("lifeon") : textureMap.get("lifeoff"), 1370, 755, 60, 60);
        batch.draw(lives > 1 ? textureMap.get("lifeon") : textureMap.get("lifeoff"), 1300, 755, 60, 60);
        batch.draw(lives > 2 ? textureMap.get("lifeon") : textureMap.get("lifeoff"), 1230, 755, 60, 60);
        batch.end();
    }

    private static void drawPower(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        batch.begin();
        batch.draw(sheet.isPowerDown() ? textureMap.get("powerdownon") : textureMap.get("powerdownoff"), 1450, 730, 100, 100);
        batch.end();
    }

    private static void drawDamage(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        batch.begin();
        if (sheet.getDamage() == 10) {
            for (int i = 0; i < 10; i++) {
                batch.draw(textureMap.get("damagered"), 1155 + (i * 40), 820, 36, 32);
            }
            batch.end();
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (9 - i > sheet.getDamage()) {
                batch.draw(textureMap.get("damageoff"), 1195 + (i * 40), 820, 36, 32);
            } else {
                batch.draw(textureMap.get("damageon"), 1195 + (i * 40), 820, 36, 32);
            }
        }
        batch.draw(textureMap.get("damagered"), 1155, 820, 36, 32);
        batch.end();
    }

    private static void drawCards(SpriteBatch batch, ProgramSheet sheet, HashMap<String, Texture> textureMap, ShapeRenderer shape) {
        for (int i = 0; i < 5; i++) {
            AbstractCard card = sheet.getSlot(i).getCard();
            CardView.drawCardForSheet(batch, card, textureMap, shape, i);
        }
    }
}
