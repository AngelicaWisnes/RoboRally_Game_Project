package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.HashMap;

public class ProgramSheetView {

    public static void drawSheet(SpriteBatch batch, ShapeRenderer shape, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        drawBackground(shape);
        drawCards(batch, textureMap, sheet);
    }

    private static void drawCards(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet) {
        batch.begin();
        Texture cardImage = textureMap.get("card");
        for (int i = 0; i < 5; i++) {
            batch.draw(cardImage, 70 + (160*i), 50, cardImage.getWidth() / 5, cardImage.getHeight() / 5);
        }
        batch.end();
    }

    private static void drawBackground(ShapeRenderer shape) {
        shape = new ShapeRenderer();
        shape.begin(ShapeRenderer.ShapeType.Filled); //I'm using the Filled ShapeType, but remember you have three of them
        shape.setColor(Color.GRAY);
        shape.rect(25, 25, 850, 350); //assuming you have created those x, y, width and height variables
        shape.end();
    }
}
