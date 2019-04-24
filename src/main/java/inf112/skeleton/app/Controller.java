package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.BlankCard;
import inf112.skeleton.app.Card.CardGenerator;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.GameState;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Helpers.Constants;
import inf112.skeleton.app.Helpers.LaserHandler;
import inf112.skeleton.app.Helpers.StateHolder;
import inf112.skeleton.app.Screens.GameScreen;

import java.util.*;

public class Controller {
    private IGamer gamer;
    private RoundState roundState;
    private GameState gameState;
    private int playerTurn;
    private int[] keys = {8, 9, 10, 11, 12, 13, 14, 15, 16};
    private final int KEY_OFFSET = 8; //Gdx.input.key is offset by 8
    private ArrayList<Integer> selectedKeys = new ArrayList<>();
    private ArrayList<IGamer> gamers;
    private int roundCounter = 0;
    private GameScreen gameScreen;
    private ArrayList<AbstractCard> cardStack;
    private ArrayList<AbstractCard> usedCards = new ArrayList<>();

    //TODO rewrite to singleton
    public Controller(StateHolder stateHolder) {
        roundState = stateHolder.getRoundState();
        gameState = stateHolder.getGameState();
        playerTurn = stateHolder.getPlayerTurn();
        cardStack = CardGenerator.getNewCardStack();
    }

    public StateHolder runGame(StateHolder states, GameScreen gameScreen) {
        this.gamers = gameScreen.getGamers();
        this.gameScreen = gameScreen;
        roundState = states.getRoundState();
        gameState = states.getGameState();
        playerTurn = states.getPlayerTurn();

        boolean allGamersReady = true;
        for (IGamer gamer : gamers){
            if (!gamer.getCardState().equals(CardState.SELECTEDCARDS)){
                setupCards(gamer);
                allGamersReady = false;
            }
        }
        if (allGamersReady){
            if (roundCounter < 5) {
                startRound();
            } else {
                resetRound();
            }
        }

        return new StateHolder(roundState, gameState, playerTurn);
    }


    private void setupCards(IGamer gamer){
        this.gamer = gamer;
        if (this.gamer.getCardState().equals(CardState.NOCARDS)) {
            if (gamer.getSheet().isPowerDown()) {
                gamer.getSheet().setPowerDown(false);
                powerDownRound();
                this.gamer.setCardState(CardState.SELECTEDCARDS);
            } else {
                dealCards();
                this.gamer.setCardState(CardState.DEALTCARDS);
            }
        } else if (this.gamer.getCardState().equals(CardState.DEALTCARDS)) {
            if (gamer instanceof AIGamer){
                AICardSelect();
            } else {
                selectCard();
            }
        }
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
        selectedKeys = new ArrayList<>();
        for (IGamer g : gamers){
            g.setCardState(CardState.NOCARDS);
            g.resetCards();
            usedCards.addAll(g.getSheet().clearUnlockedSlots());
        }
    }

    private void startRound() {
        if (roundState.equals(RoundState.NONE)) {
            roundState = RoundState.PART1;
        } else if (roundState.equals(RoundState.PART1)) {
            playCards();
            robotTileImpacts();
            roundState = RoundState.PART2;
        } else if (roundState.equals(RoundState.PART2)) {
            robotTileImpacts();
            roundState = RoundState.PART3;
        } else if (roundState.equals(RoundState.PART3)) {
            robotTileImpacts();
            roundState = RoundState.PART4;
        } else if (roundState.equals(RoundState.PART4)) {
            roundState = RoundState.PART5;
        } else if (roundState.equals(RoundState.PART5)) {
            LaserHandler.fireBoardLaser(gameScreen.getLasers(), gamer, gameScreen.getLaserShape(), gameScreen.getPew(), Constants.TILESIZE);
            roundState = RoundState.PART6;
        } else if (roundState.equals(RoundState.PART6)) {
            robotTileImpacts();
            isEndState();
            roundState = RoundState.NONE;
            roundCounter++;
        }

    }
    private void robotTileImpacts(){
        for (IGamer g : gamers){
            g.getSheet().getRobot().tileRobotImpact(roundState);
        }
    }

    private void playCards() {
        //TODO choose lowest card from each gamer and play them in order
        //the cards can be sorted by priority
        for (IGamer g : gamers){
            g.getSheet().getRobot().cardMovesRobot(g.getSheet().getSlot(roundCounter).getCard());
        }
    }


    private void dealCards() {
        List<AbstractCard> nineCards = new ArrayList<>();
        for (int i = 0; i < 9; i++){
            if (!cardStack.isEmpty()){
                nineCards.add(cardStack.remove(0));
            } else {
                cardStack = new ArrayList<>(usedCards);
                usedCards = new ArrayList<>();
                Collections.shuffle(cardStack);
                nineCards.add(cardStack.remove(0));
            }
        }
        gamer.setCards(nineCards);
    }

    private void powerDownRound() {
        gamer.getSheet().resetDamage();
        for (int i = 0; i < 5; i++) {
            gamer.getSheet().placeCard(new BlankCard(11));
        }
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
            for (int i = 0; i < 9; i++){
                if (!selectedKeys.contains(i)){
                    usedCards.add(gamer.getCard(i));
                }
            }
            gamer.setCardState(CardState.SELECTEDCARDS);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            gamer.getSheet().placeCard(new BlankCard(11));
        }
    }
    private void AICardSelect() {
        gamer.getSheet().placeCard(gamer.getCard(0));
        gamer.getSheet().placeCard(gamer.getCard(1));
        gamer.getSheet().placeCard(gamer.getCard(2));
        gamer.getSheet().placeCard(gamer.getCard(3));
        gamer.getSheet().placeCard(gamer.getCard(4));
        usedCards.add(gamer.getCard(5));
        usedCards.add(gamer.getCard(6));
        usedCards.add(gamer.getCard(7));
        usedCards.add(gamer.getCard(8));
        gamer.setCardState(CardState.SELECTEDCARDS);
    }


}
