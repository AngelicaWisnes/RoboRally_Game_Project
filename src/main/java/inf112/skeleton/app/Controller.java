package inf112.skeleton.app;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

   private Gamer gamer;

    public Controller(Gamer gamer) {
       this.gamer = gamer;
    }

    public void runGame() {
        //while (true) {
            dealCards(); // 9
            selectCard(); // 5
            playCards();

        //}
    }


    private void dealCards() {
        List<AbstractCard> cards = CardGenerator.getNewCardStack();
        List<AbstractCard> firstHand = new ArrayList<>(cards.subList(0,9));
        gamer.setCards(firstHand);

        int i = 0;

        for (AbstractCard card : gamer.cardsOnHand) {
            System.out.println(i++ + " " + card);
        }
    }

    private void selectCard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select 5 cards");

        for (int i = 0; i < 5; i++) {
            int input = scan.nextInt();
            gamer.getSheet().placeCard(gamer.cardsOnHand.get(input));

        }

    }

    private void playCards() {
        //gamer.getSheet().getSlot1().getCard().;
    }

}
