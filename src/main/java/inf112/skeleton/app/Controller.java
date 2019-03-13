package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardGenerator;
import inf112.skeleton.app.Enums.CardState;
import net.java.games.input.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controller implements IController {


    private Gamer gamer;
    private int[] keys = {8, 9, 10, 11, 12, 13, 14, 15, 16};
    private final int KEY_OFFSET = 8; //Gdx.input.key is offset by 8
    private Stack<AbstractCard> selectedCards = new Stack<>();
    private ArrayList<Integer> selectedKeys = new ArrayList<>();
    private boolean gamerReady = false;


    public Controller(Gamer gamer) {
        this.gamer = gamer;
    }

    @Override
    public void runGame(CardState state) {
        if (state.equals(CardState.NOCARDS)) {
            dealCards();
        } else if (state.equals(CardState.DEALTCARDS)) {
            selectCard();
        } else if (state.equals(CardState.SELECTEDCARDS)) {
            playCards();
        }
    }


    private void dealCards() {
        List<AbstractCard> cards = CardGenerator.getNewCardStack();
        List<AbstractCard> nineCards = new ArrayList<>(cards.subList(0, 9));
        gamer.setCards(nineCards);
    }

    public boolean isGamerReady() {
        return gamerReady;
    }

    private void selectCard() {
        for (int key : keys) {
            int selectedKey = key - KEY_OFFSET;

            if (Gdx.input.isKeyJustPressed(key)) {
                if (!selectedKeys.contains(selectedKey) && selectedKeys.size() < 5) {
                    gamer.getSheet().placeCard(gamer.cardsOnHand.get(selectedKey));
                    selectedKeys.add(selectedKey);
                }
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.FORWARD_DEL)) {
            gamer.getSheet().removeLastCard();
            if (!selectedKeys.isEmpty()) {
                selectedKeys.remove(selectedKeys.size() - 1);
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && gamer.getSheet().allSlotsAreFilled()) {
            gamerReady = true;

        }
    }

    private void playCards() {
        for (int i = 0; i < 5; i++) {
            gamer.getSheet().getRobot().cardMovesRobot(gamer.getSheet().getSlot(i).getCard());
        }
    }


}
