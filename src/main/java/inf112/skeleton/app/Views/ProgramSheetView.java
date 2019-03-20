package inf112.skeleton.app.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.HashMap;

public class ProgramSheetView {

    public static void drawSheet(SpriteBatch batch, ShapeRenderer shape, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        drawImage(batch, textureMap);
        drawPower(batch, textureMap, sheet);
        drawLives(batch, textureMap, sheet);
        drawDamage(batch, textureMap, sheet);
        drawCards(batch, sheet, textureMap, shape);
    }

    private static void drawImage(SpriteBatch batch, HashMap<String, Texture> textureMap) {
        batch.begin();
        //TODO remove magic number (which is tile width x 16 tiles x 2 spacer tiles
        batch.draw(textureMap.get("sheet"), 64 * 18, Gdx.graphics.getHeight() / 2 - (64 * 6), 400, 64 * 12);
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
            for (int i = 0; i < 10; i++){
                batch.draw(textureMap.get("damagered"), 1155 + (i*40), 820, 36, 32);
            }
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
