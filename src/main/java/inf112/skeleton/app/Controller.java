package inf112.skeleton.app;

import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Card.CardGenerator;

import java.util.ArrayList;

public class Controller {

   private Gamer gamer;

    public Controller(Gamer gamer) {
       this.gamer = gamer;

    }

    public void runGame() {
        while (true) {
            dealCards(); // 9
           // selectCard(); // 5
           // playCards();

        }
    }

    private void dealCards() {
        ArrayList<Card> cards = CardGenerator.getNewCardStack();
        ArrayList<Card> firstHand = (ArrayList<Card>) cards.subList(0,8);
        gamer.setCards(firstHand);
    }

}
