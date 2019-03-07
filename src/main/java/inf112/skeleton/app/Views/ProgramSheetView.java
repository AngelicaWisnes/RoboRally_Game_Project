package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.HashMap;

public class ProgramSheetView {

    public static void drawSheet(SpriteBatch batch, ShapeRenderer shape, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        drawBackground(shape);
        drawCards(batch, sheet, textureMap, shape);
        drawPower(batch, textureMap, sheet);
        drawDamage(shape, sheet);
        drawLives(shape, sheet);
    }

    private static void drawLives(ShapeRenderer shape, ProgramSheet sheet) {
        int lives = sheet.getLives();
        shape.begin(ShapeRenderer.ShapeType.Filled); //I'm using the Filled ShapeType, but remember you have three of them
        if (lives < 1) shape.setColor(Color.DARK_GRAY);
        else shape.setColor(Color.GREEN);
        shape.circle(525, 330, 30);
        if (lives < 2) shape.setColor(Color.DARK_GRAY);
        shape.circle(450, 330, 30);
        if (lives < 3) shape.setColor(Color.DARK_GRAY);
        shape.circle(375, 330, 30);
        shape.end();
    }

    private static void drawPower(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        batch.begin();
        batch.draw(sheet.isPowerDown() ? textureMap.get("powerdownon") : textureMap.get("powerdownoff"), 50, 275, 100, 100);
        batch.end();


    }

    private static void drawDamage(ShapeRenderer shape, ProgramSheet sheet) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        //int damage = sheet.getDamage();
        int unDamaged = 10;
        unDamaged -= sheet.getDamage();
        for (int i = 9; i >= 0; i--) {
            int x1 = 5 + 25 + 42 + (i * 84);
            int y1 = 240;

            int x2 = x1 - 20;
            int y2 = 270;

            int x3 = x1 + 20;
            int y3 = 270;

            if (i == 0) {
                shape.setColor(Color.RED);
            } else if (unDamaged <= i){
                shape.setColor(Color.YELLOW);
            } else {
                shape.setColor(Color.DARK_GRAY);
            }
            if (unDamaged == 0){shape.setColor(Color.RED);}
            shape.triangle(x1, y1, x2, y2, x3, y3);
        }
        shape.end();
    }

    private static void drawCards(SpriteBatch batch, ProgramSheet sheet, HashMap<String, Texture> textureMap, ShapeRenderer shape) {
        for (int i = 0; i < 5; i++) {
            AbstractCard card = sheet.getSlot(i).getCard();
            CardView.drawCard(batch, card, textureMap, shape, i);
        }
    }

    private static void drawBackground(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled); //I'm using the Filled ShapeType, but remember you have three of them
        shape.setColor(Color.GRAY);
        shape.rect(25, 25, 850, 350); //assuming you have created those x, y, width and height variables
        shape.end();
    }
}
