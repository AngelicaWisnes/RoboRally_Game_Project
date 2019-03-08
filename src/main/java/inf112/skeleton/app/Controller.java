package inf112.skeleton.app;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardGenerator;
import inf112.skeleton.app.Enums.CardState;

import java.util.ArrayList;
import java.util.List;

public class Controller {


   private Gamer gamer;

    public Controller(Gamer gamer) {
       this.gamer = gamer;
    }

    public void runGame(CardState state) {
        if (state.equals(CardState.NOCARDS)){
            dealCards();
        } else if (state.equals(CardState.DEALTCARDS)){
            selectCard();
        } else if (state.equals(CardState.SELECTEDCARDS)) {
            playCards();
        }
    }


    private void dealCards() {
        List<AbstractCard> cards = CardGenerator.getNewCardStack();
        List<AbstractCard> nineCards = new ArrayList<>(cards.subList(0,9));
        gamer.setCards(nineCards);
    }

    private void selectCard() {
        //gamer.getSheet().placeCard(gamer.cardsOnHand.get(input));

    }

    private void playCards() {
        //gamer.getSheet().getSlot1().getCard().;
    }

}
