package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.BlankCard;
import inf112.skeleton.app.Card.CardGenerator;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.RoundState;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Controller implements IController {


    private Gamer gamer;
    private CardState cardState;
    private RoundState roundState;
    private int[] keys = {8, 9, 10, 11, 12, 13, 14, 15, 16};
    private final int KEY_OFFSET = 8; //Gdx.input.key is offset by 8
    private ArrayList<Integer> selectedKeys = new ArrayList<>();
    private boolean gamerReady = false;
    private int roundCounter = 0;


    public Controller(Gamer gamer, StateHolder stateHolder) {
        this.gamer = gamer;
        this.cardState = stateHolder.getCardState();
        this.roundState = stateHolder.getRoundState();
    }

    @Override
    public StateHolder runGame(StateHolder states) {
        this.cardState = states.getCardState();
        this.roundState = states.getRoundState();

        if (this.cardState.equals(CardState.NOCARDS)) {
            gamer.resetCards();
            dealCards();
        } else if (this.cardState.equals(CardState.DEALINGCARDS)) {
            //waiting for cards to be dealt
        } else if (this.cardState.equals(CardState.DEALTCARDS)) {
            selectCard();
        } else if (this.cardState.equals(CardState.SELECTEDCARDS)) {
            //waiting for screen to reset
        } else if (this.cardState.equals(CardState.PLAYINGCARDS)){
            if (roundCounter < 5){
                startRound();
            } else {
                //RESET
                resetRound();
            }
        }
        return new StateHolder(this.cardState, this.roundState);
    }

    private void resetRound() {
        roundCounter = 0;
        roundState = RoundState.NONE;
        cardState = CardState.NOCARDS;
        gamer.getSheet().clearUnlockedSlots();
        gamer.resetCards();
        selectedKeys = new ArrayList<>();
        gamerReady = false;

    }

    private void startRound() {
        if (roundState.equals(RoundState.NONE)) {
            roundState = RoundState.PART1;
        } else if (this.roundState.equals(RoundState.PART1)) {
            playCard();
            gamer.getSheet().getRobot().tileMovesRobot(roundState);
            roundState = RoundState.PART2;
            System.out.println("part 1");
        } else if (roundState.equals(RoundState.PART2)) {
            //express conveyors move 1
            gamer.getSheet().getRobot().tileMovesRobot(roundState);
            roundState = RoundState.PART3;
            System.out.println("part 2");
        } else if (roundState.equals(RoundState.PART3)) {
            //all conveyors move 1
            gamer.getSheet().getRobot().tileMovesRobot(roundState);
            roundState = RoundState.PART4;
            System.out.println("part 3");
        }else if (roundState.equals(RoundState.PART4)) {
            //gears rotate
            gamer.getSheet().getRobot().tileMovesRobot(roundState);
            roundState = RoundState.NONE;
            System.out.println("part 4");
        }

    }

    private void playCard() {
        gamer.getSheet().getRobot().cardMovesRobot(gamer.getSheet().getSlot(roundCounter++).getCard());
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            gamer.getSheet().placeCard(new BlankCard(11));
        }
    }



}
