package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.HashMap;

public class ProgramSheetView {

    public static void drawSheet(SpriteBatch batch, ShapeRenderer shape, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        drawBackground(shape);
        batch.begin();
        drawCards(batch, textureMap, sheet);
        drawPower(batch, textureMap, sheet);
        batch.end();
        drawDamage(shape);

    }

    private static void drawPower(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        batch.draw(textureMap.get("powerdownoff"), 50, 275, 100, 100);

    }

    private static void drawDamage(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.DARK_GRAY);
        for (int i = 0; i < 10; i++){
            int x1 = 5 + 25 + 42 + (i * 84);
            int y1 = 240;

            int x2 = x1-20;
            int y2 = 270;

            int x3 = x1+20;
            int y3 = 270;
            if (i == 9){shape.setColor(Color.YELLOW);}
            shape.triangle(x1,y1,x2,y2,x3,y3);
        }
        shape.end();

    }

    private static void drawCards(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        Texture cardImage = textureMap.get("card");
        for (int i = 0; i < 5; i++) {
            batch.draw(cardImage, 70 + (160*i), 50, cardImage.getWidth() / 5, cardImage.getHeight() / 5);
        }
    }

    private static void drawBackground(ShapeRenderer shape) {
        shape.begin(ShapeRenderer.ShapeType.Filled); //I'm using the Filled ShapeType, but remember you have three of them
        shape.setColor(Color.GRAY);
        shape.rect(25, 25, 850, 350); //assuming you have created those x, y, width and height variables
        shape.end();
    }
}
