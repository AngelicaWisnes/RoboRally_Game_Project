package inf112.skeleton.app;

import inf112.skeleton.app.Card.Card;
import inf112.skeleton.app.Card.CardGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GameAdministrator {


    private static Stack<Card> cardStack = new Stack<>();
    private static Stack<Card> trashedCardStack = new Stack<>();
    static {
        cardStack.addAll(CardGenerator.getNewCardStack());
        Collections.shuffle(cardStack);
    }

    public static void returnCardsToDealer(ArrayList<Card> returnedCards) {
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

    private static void dealCards() {

    }

}
