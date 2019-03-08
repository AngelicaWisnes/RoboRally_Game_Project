package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardGenerator;
import inf112.skeleton.app.Enums.CardState;

import java.util.ArrayList;
import java.util.List;

public class Controller implements IController{


   private Gamer gamer;

    public Controller(Gamer gamer) {
       this.gamer = gamer;
    }

    public void runGame(CardState state) {
        if (state.equals(CardState.NOCARDS)){
            dealCards();
        } else if (state.equals(CardState.DEALTCARDS)){
            selectCard(state);
        } else if (state.equals(CardState.SELECTEDCARDS)) {
            playCards();
        }
    }


    private void dealCards() {
        List<AbstractCard> cards = CardGenerator.getNewCardStack();
        List<AbstractCard> nineCards = new ArrayList<>(cards.subList(0,9));
        gamer.setCards(nineCards);
    }

    private void selectCard(CardState state) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(0));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(1));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(2));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(3));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(4));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(5));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_7)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(6));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_8)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(7));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_9)){
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(8));
        }
    }

    private void playCards() {
        for (int i = 0; i < 5; i++){
            gamer.getSheet().getRobot().cardMovesRobot(gamer.getSheet().getSlot(i).getCard());
        }
    }


}
