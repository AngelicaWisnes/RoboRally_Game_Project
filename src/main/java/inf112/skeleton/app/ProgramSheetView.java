package inf112.skeleton.app;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;

public class ProgramSheetView {

    public static void drawSheet(SpriteBatch batch, HashMap<String, Texture> textureMap, ProgramSheet sheet){
        Texture cardImage = textureMap.get("card");
        for (int i = 0; i < 5; i++){
            batch.draw(cardImage, (cardImage.getWidth()/5 * i) + 30, 0, cardImage.getWidth()/5, cardImage.getHeight()/5);
        }



    }
}
