package inf112.skeleton.app;

import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Card.CardGenerator;

import java.util.ArrayList;
import java.util.List;

public class Controller {

   private Gamer gamer;

    public Controller(Gamer gamer) {
       this.gamer = gamer;

    }

    public void runGame() {
        //while (true) {
            dealCards(); // 9
            selectCard(); // 5
           // playCards();

        //}
    }

    private void dealCards() {
        List<Card> cards = CardGenerator.getNewCardStack();
        List<Card> firstHand = new ArrayList<>(cards.subList(0,8));
        gamer.setCards(firstHand);

        for (Card card : gamer.cardsOnHand) {
            System.out.println(card);
        }
    }

    private void selectCard() {

    }

}
