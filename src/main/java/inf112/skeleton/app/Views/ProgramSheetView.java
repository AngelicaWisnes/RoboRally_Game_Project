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
        //drawImage(batch, textureMap);
        drawPower(batch, textureMap, sheet);
        drawLives(batch, textureMap, sheet);
        drawDamage(batch, textureMap, sheet);
        drawCards(batch, sheet, textureMap, shape);
    }

    private static void drawImage(SpriteBatch batch, HashMap<String, Texture> textureMap) {
        batch.begin();
        //TODO remove magic number (which is tile width x 16 tiles x 2 spacer tiles
        batch.draw(textureMap.get("sheet"), 950, 64, 375, 630);
        batch.end();
    }

    private static void drawLives(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        int lives = sheet.getLives();
        batch.begin();
        batch.draw(lives > 0 ? textureMap.get("lifeon") : textureMap.get("lifeoff"), 960+100, 580+50, 60, 60);
        batch.draw(lives > 1 ? textureMap.get("lifeon") : textureMap.get("lifeoff"), 1040+100, 580+50, 60, 60);
        batch.draw(lives > 2 ? textureMap.get("lifeon") : textureMap.get("lifeoff"), 1120+100, 580+50, 60, 60);
        batch.end();
    }

    private static void drawPower(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        batch.begin();
        batch.draw(sheet.isPowerDown() ? textureMap.get("powerdownon") : textureMap.get("powerdownoff"), 1210+100, 560+50, 100, 100);
        batch.end();
    }

    private static void drawDamage(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        batch.begin();
        if (sheet.getDamage() == 10) {
            for (int i = 0; i < 10; i++){
                batch.draw(textureMap.get("damagered"), 100 + 1155 + (i*40), 820 + 50, 36, 32);
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (9 - i > sheet.getDamage()) {
                batch.draw(textureMap.get("damageoff"), 100 + 1000 + (i * 35), 650 + 50, 27, 24);
            } else {
                batch.draw(textureMap.get("damageon"), 100 + 1000 + (i * 35), 650 + 50, 27, 24);

            }
        }
        batch.draw(textureMap.get("damagered"), 100 + 965, 650 + 50, 27, 24);
        batch.end();

    }

    private static void drawCards(SpriteBatch batch, ProgramSheet sheet, HashMap<String, Texture> textureMap, ShapeRenderer shape) {
        for (int i = 0; i < 5; i++) {
            AbstractCard card = sheet.getSlot(i).getCard();
            CardView.drawCardForSheet(batch, card, textureMap, shape, i);
        }
    }
}
