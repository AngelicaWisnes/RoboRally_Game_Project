package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.BlankCard;
import inf112.skeleton.app.Card.CardGenerator;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.GameState;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Helpers.StateHolder;

import java.util.ArrayList;
import java.util.List;

public class Controller {


    private Gamer gamer;
    private CardState cardState;
    private RoundState roundState;
    private GameState gameState;
    private int[] keys = {8, 9, 10, 11, 12, 13, 14, 15, 16};
    private final int KEY_OFFSET = 8; //Gdx.input.key is offset by 8
    private ArrayList<Integer> selectedKeys = new ArrayList<>();
    private boolean gamerReady = false;
    private int roundCounter = 0;


    public Controller(Gamer gamer, StateHolder stateHolder) {
        this.gamer = gamer;
        cardState = stateHolder.getCardState();
        roundState = stateHolder.getRoundState();
        gameState = stateHolder.getGameState();
    }

    public StateHolder runGame(StateHolder states) {
        cardState = states.getCardState();
        roundState = states.getRoundState();

        if (cardState.equals(CardState.NOCARDS)) {
            if (gamer.getSheet().isPowerDown()) {
                gamer.getSheet().setPowerDown(false);
                powerDownRound();
                cardState.equals(CardState.PLAYINGCARDS);
            } else {
                dealCards();
                cardState = CardState.DEALTCARDS;
            }
        } else if (cardState.equals(CardState.DEALINGCARDS)) {
            //waiting for cards to be dealt
        } else if (cardState.equals(CardState.DEALTCARDS)) {
            selectCard();
        } else if (cardState.equals(CardState.SELECTEDCARDS)) {
            //waiting for screen to reset
        } else if (cardState.equals(CardState.PLAYINGCARDS)) {
            listenForPowerDown();
            if (roundCounter < 5) {
                startRound();
            } else {
                resetRound();
            }
        }
        return new StateHolder(cardState, roundState, gameState);
    }

    private void listenForPowerDown() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            gamer.getSheet().setPowerDown(!gamer.getSheet().isPowerDown());
        }


    }


    public void isEndState() {
        if (gamer.getSheet().getLives() <= 0) {
            System.out.println("GAME OVER");
            gameState = GameState.GAME_OVER;
        } else if (gamer.getSheet().getLastVisitedFlag() == 3) {
            System.out.println("YOU WIN!");
            gameState = GameState.GAME_OVER;

        }
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
        } else if (roundState.equals(RoundState.PART1)) {
            playCard();
            gamer.getSheet().getRobot().tileRobotImpact(roundState);
            roundState = RoundState.PART2;
        } else if (roundState.equals(RoundState.PART2)) {
            //express conveyors move 1
            gamer.getSheet().getRobot().tileRobotImpact(roundState);
            roundState = RoundState.PART3;
        } else if (roundState.equals(RoundState.PART3)) {
            //all conveyors move 1
            gamer.getSheet().getRobot().tileRobotImpact(roundState);
            roundState = RoundState.PART4;
        } else if (roundState.equals(RoundState.PART4)) {
            //pushers rotate
            gamer.getSheet().getRobot().tileRobotImpact(roundState);
            roundState = RoundState.PART5;
        } else if (roundState.equals(RoundState.PART5)) {
            //lasers shoot

            //roundState = RoundState.PART6;
        } else if (roundState.equals(RoundState.PART6)) {
            //checkpoints
            gamer.getSheet().getRobot().tileRobotImpact(roundState);
            isEndState();
            roundState = RoundState.NONE;
            roundCounter++;
        }

    }

    private void playCard() {
        gamer.getSheet().getRobot().cardMovesRobot(gamer.getSheet().getSlot(roundCounter).getCard());
    }


    private void dealCards() {
        List<AbstractCard> cards = CardGenerator.getNewCardStack();
        List<AbstractCard> nineCards = new ArrayList<>(cards.subList(0, 9));
        gamer.setCards(nineCards);
    }

    public boolean isGamerReady() {
        return gamerReady;
    }

    private void powerDownRound() {
        gamer.getSheet().resetDamage();
        for (int i = 0; i < 5; i++) {
            gamer.getSheet().placeCard(new BlankCard(11));
        }
        gamerReady = true;
    }

    private void selectCard() {
        for (int key : keys) {
            int selectedKey = key - KEY_OFFSET;

            if (Gdx.input.isKeyJustPressed(key)) {
                if (!selectedKeys.contains(selectedKey) && selectedKeys.size() < 5) {
                    gamer.getSheet().placeCard(gamer.getCard(selectedKey));
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

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            gamer.getSheet().placeCard(new BlankCard(11));
        }
    }


}
