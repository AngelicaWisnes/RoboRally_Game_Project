package inf112.skeleton.app;

import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardGenerator;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GameAdministrator {


    private static Stack<AbstractCard> cardStack = new Stack<>();
    private static Stack<AbstractCard> trashedCardStack = new Stack<>();
    static {
        cardStack.addAll(CardGenerator.getNewCardStack());
        Collections.shuffle(cardStack);
    }

    public static void returnCardsToDealer(List<AbstractCard> returnedCards) {
        trashedCardStack.addAll(returnedCards);
    }

    private static void reuseTrashedCards() {
        cardStack.addAll(trashedCardStack);
        Collections.shuffle(cardStack);
        trashedCardStack.clear();
    }

    public static void startTurn() {
        //Deal the Program cards

        // Arrange your ProgramCards face down among your five registers

        // Announce intent to power down or continue running NEXT turn

        // Complete each register in order:
        //      Execute the program
        //      Complete board movements
        //      Resolve all interactions
        //      Touch flags and repair sites

        // Clean up any end-of-turn effects
    }

    private static void dealCards(Gamer gamer) {
        int damage = gamer.getSheet().getDamage();
        List<AbstractCard> cards = new ArrayList<>();
        for (int i = 0; i < 9 - damage; i++) {
            if (cardStack.size() == 0) reuseTrashedCards();
            cards.add(cardStack.pop());
        }
        gamer.setCards(cards);
    }

}
