package inf112.skeleton.app.Views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.skeleton.app.Helpers.StateHolder;

public class StateTextView {
    private static BitmapFont font = new BitmapFont();

    public static void drawStates(SpriteBatch batch, StateHolder states){
        StringBuilder sb = new StringBuilder();
        sb.append("player turn: " + states.getNumberOfPlayers());
        sb.append("\n");
        sb.append(states.getRoundState());
        batch.begin();
        font.getData().setScale(3, 3);
        font.setColor(Color.WHITE);
        font.draw(batch, sb.toString(), 100, 100);
        batch.end();
    }
}
