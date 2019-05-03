package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardDealer;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.GameState;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Gamer.AIGamer;
import inf112.skeleton.app.Gamer.IGamer;
import inf112.skeleton.app.Gamer.NetworkGamer;
import inf112.skeleton.app.Helpers.Constants;
import inf112.skeleton.app.Helpers.LaserHandler;
import inf112.skeleton.app.Helpers.StateHolder;
import inf112.skeleton.app.Network.NetworkHandler;
import inf112.skeleton.app.Network.Packet;
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
    private CardDealer cardDealer;
    private IGamer winner;

    //TODO rewrite to singleton
    public Controller(StateHolder stateHolder) {
        roundState = stateHolder.getRoundState();
        gameState = stateHolder.getGameState();
        playerTurn = stateHolder.getPlayerTurn();
        cardDealer = CardDealer.getInstance();
    }

    public StateHolder runGame(StateHolder states, GameScreen gameScreen) {
        gamers = gameScreen.getGamers();
        this.gameScreen = gameScreen;
        roundState = states.getRoundState();
        gameState = states.getGameState();
        playerTurn = states.getPlayerTurn();
        isEndState();

        boolean allGamersReady = true;
        for (IGamer gamer : gamers) {
            if (!gamer.getCardState().equals(CardState.SELECTEDCARDS)) {
                setupCards(gamer);
                allGamersReady = false;
            }
        }

        if (allGamersReady) {
            listenForPowerDown();
            if (roundCounter < 5) {
                startRound();
            } else {
                resetRound();
            }
        }

        return new StateHolder(roundState, gameState, playerTurn);
    }

    private void setupCards(IGamer gamer) {
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
            if (gamer instanceof AIGamer) {
                AICardSelect();
            } else if (gamer instanceof NetworkGamer) {
                NetworkCardSelect();
            } else {
                CardSelect();
            }
        }
    }

    private void listenForPowerDown() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            gamer.getSheet().setPowerDown(!gamer.getSheet().isPowerDown());
        }
    }

    public IGamer getWinner() {
        return winner;
    }

    private void isEndState() {
        if (gamers == null) {
            gameState = GameState.GAME_OVER;
            return;
        }
        for (IGamer g : gamers) {
            if (gamers.size() == 1) {
                winner = g;
                gameState = GameState.GAME_OVER;
            } else if (g.getSheet().getLives() <= 0) {
                for (int i = 0; i < g.getCards().size(); i++) {
                    cardDealer.returnCard(g.getCard(i));
                }
                gamers.set(gamers.indexOf(g), null);
            } else if (g.getSheet().getLastVisitedFlag() == 3) {
                gameState = GameState.GAME_OVER;
                winner = g;
            }
        }
        gamers.removeAll(Collections.singletonList(null));
    }

    private void resetRound() {
        roundCounter = 0;
        roundState = RoundState.NONE;
        selectedKeys = new ArrayList<>();
        for (IGamer g : gamers) {
            g.setCardState(CardState.NOCARDS);
            g.resetCards();
            cardDealer.returnCardList(g.getSheet().clearUnlockedSlots());
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
            LaserHandler.fireBoardLaser(gameScreen.getLasers(), gamer, gameScreen.getLaserShape(),
                    gameScreen.getPew(), Constants.TILESIZE);
            for (IGamer gamer : gamers) {
                LaserHandler.fireRobotLaser(gamer, gamers, gameScreen.getLaserShape());
            }
            roundState = RoundState.PART6;

        } else if (roundState.equals(RoundState.PART6)) {
            robotTileImpacts();
            //isEndState();
            roundState = RoundState.NONE;
            roundCounter++;
        }
    }

    private void robotTileImpacts() {
        for (IGamer g : gamers) {
            g.getSheet().getRobot().tileRobotImpact(roundState);
        }
    }

    private void playCards() {
        //TODO choose lowest card from each gamer and play them in order
        //the cards can be sorted by priority
        for (IGamer g : gamers) {
            g.getSheet().getRobot().cardMovesRobot(g.getSheet().getSlot(roundCounter).getCard());
        }
    }

    private void dealCards() {
        int cardQuantity = 9 - gamer.getSheet().getDamage();
        if (gamer instanceof NetworkGamer) {
            NetworkHandler networkHandler = ((NetworkGamer) gamer).getNetworkHandler();
            Packet packet = networkHandler.getNextPacket();
            List<AbstractCard> cards = packet.getCardsToClient(); //velg 5 av disse 9
            gamer.setCards(cards.subList(0, cardQuantity));
        } //TODO distribute cards from host to host-imitation on client machine
        else{
            gamer.setCards(cardDealer.dealCards(cardQuantity));
        }
    }

    private void powerDownRound() {
        gamer.getSheet().resetDamage();
        for (int i = 0; i < 5; i++) {
            gamer.getSheet().placeCardInSlot(cardDealer.dealBlankCard());
        }
    }

    private void CardSelect() {
        for (int key : keys) {
            int selectedKey = key - KEY_OFFSET;

            if (Gdx.input.isKeyJustPressed(key)) {
                if (!selectedKeys.contains(selectedKey) && selectedKeys.size() < 5) {
                    if (selectedKey < gamer.getCards().size()) {
                        gamer.getSheet().placeCardInSlot(gamer.getCard(selectedKey));
                        selectedKeys.add(selectedKey);
                    }
                }
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.FORWARD_DEL)) {
            gamer.getSheet().returnLastCardToHandFromSlot();
            if (!selectedKeys.isEmpty()) {
                selectedKeys.remove(selectedKeys.size() - 1);
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && gamer.getSheet().allSlotsAreFilled()) {
            for (int i = 0; i < gamer.getCards().size(); i++) {
                if (!selectedKeys.contains(i)) {
                    cardDealer.returnCard(gamer.getCard(i));
                }
            }
            gamer.setCardState(CardState.SELECTEDCARDS);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            gamer.getSheet().placeCardInSlot(cardDealer.dealBlankCard());
        }
    }

    private void NetworkCardSelect() {
        CardSelect();
        //return packet with two arraylists
        List<AbstractCard>  cardsFromHost = new ArrayList<>(gamer.getCards());
        List<AbstractCard> chosenCards = gamer.getSheet().getSlotCards();
        cardsFromHost.removeAll(chosenCards);
        Packet packet = new Packet(false, cardsFromHost, chosenCards);


    }

    private void AICardSelect() {
        int counter = gamer.getCards().size() - 1; //9 kort
        while (counter > 0) {
            if (gamer.getSheet().placeCardInSlot(gamer.getCard(counter))) {
                gamer.getCards().remove(counter);
            }
            counter--;
        }
        for (int i = 0; i < gamer.getCards().size(); i++) {
            cardDealer.returnCard(gamer.getCard(i));
        }
        gamer.setCardState(CardState.SELECTEDCARDS);
    }
}
