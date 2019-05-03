package inf112.skeleton.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.CardDealer;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.GameState;
import inf112.skeleton.app.Enums.RoundState;
import inf112.skeleton.app.Gamer.*;
import inf112.skeleton.app.Helpers.Constants;
import inf112.skeleton.app.Helpers.LaserHandler;
import inf112.skeleton.app.Helpers.StateHolder;
import inf112.skeleton.app.Network.NetworkHandler;
import inf112.skeleton.app.Network.IPacket;
import inf112.skeleton.app.Network.PacketFromClient;
import inf112.skeleton.app.Network.PacketFromHost;
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
    private IPacket recievePacket;
    private IPacket sendPacket;
    private NetworkHandler networkHandler;
    private List<AbstractCard> remainingClientCards, chosenClientCards, cardsToClient, chosenHostCards;

    //TODO rewrite to singleton
    public Controller(StateHolder stateHolder, GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        roundState = stateHolder.getRoundState();
        gameState = stateHolder.getGameState();
        playerTurn = stateHolder.getPlayerTurn();
        cardDealer = CardDealer.getInstance();
        recievePacket = null;
        sendPacket = null;
        networkHandler = gameScreen.getNetworkHandler();
        //remainingClientCards = null;
        //chosenClientCards = null;
        //cardsToClient = null;
        //chosenHostCards = null;
    }

    public StateHolder runGame(StateHolder states) {
        gamers = gameScreen.getGamers();
        roundState = states.getRoundState();
        gameState = states.getGameState();
        playerTurn = states.getPlayerTurn();
        isEndState();

        boolean allGamersReady = true;
        if (gameScreen.isOnline()) handlePacket();
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

    private void handlePacket() {
        if (recievePacket == null || recievePacket.isEmpty()) recievePacket = networkHandler.getNextPacket();

        if (gameScreen.getLocalGamer() instanceof LocalHostGamer) {
            if (recievePacket != null) {
                if (remainingClientCards == null) {
                    remainingClientCards = ((PacketFromClient) recievePacket).getRemainingCards();
                    ((PacketFromClient) recievePacket).setRemainingCards(null);
                }
                if (chosenClientCards == null) {
                    chosenClientCards = ((PacketFromClient) recievePacket).getRemainingCards();
                    ((PacketFromClient) recievePacket).setChosenClientCards(null);
                }
            }

            if (sendPacket == null) sendPacket = new PacketFromHost(null, null);
            if (((PacketFromHost) sendPacket).getCardsToClient() == null) {
                ((PacketFromHost) sendPacket).setCardsToClient(cardsToClient);
            }
            if (((PacketFromHost) sendPacket).getChosenHostCards() == null){
                ((PacketFromHost) sendPacket).setChosenHostCards(chosenHostCards);
            }
            if (sendPacket.isFull()) networkHandler.sendPacket(sendPacket);

        } else if (gameScreen.getLocalGamer() instanceof LocalClientGamer) {
            if (recievePacket != null) {
                if (cardsToClient == null) {
                    cardsToClient = ((PacketFromHost) recievePacket).getCardsToClient();
                    ((PacketFromHost) recievePacket).setCardsToClient(null);
                }
                if (chosenHostCards == null) {
                    chosenHostCards = ((PacketFromHost) recievePacket).getChosenHostCards();
                    ((PacketFromHost) recievePacket).setChosenHostCards(null);
                }
            }

            if (sendPacket == null) sendPacket = new PacketFromClient(null, null);
            if (((PacketFromClient) sendPacket).getChosenClientCards() == null) {
                ((PacketFromClient) sendPacket).setChosenClientCards(chosenClientCards);
            }
            if (((PacketFromClient) sendPacket).getRemainingCards() == null){
                ((PacketFromClient) sendPacket).setRemainingCards(remainingClientCards);
            }
            if (sendPacket.isFull()) networkHandler.sendPacket(sendPacket);
        }
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
            }
        } else if (this.gamer.getCardState().equals(CardState.DEALTCARDS)) {
            if (gamer instanceof LocalHostGamer || gamer instanceof LocalClientGamer) {
                LocalCardSelect();

            } else if (gamer instanceof ExternalHostGamer || gamer instanceof ExternalClientGamer) {
                ExternalCardSelect();
            } if (gamer instanceof AIGamer) {
                AICardSelect();
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
            ArrayList<AbstractCard> cardsToReturn = g.getSheet().clearUnlockedSlots();
            if (g instanceof LocalClientGamer) remainingClientCards.addAll(cardsToReturn);
            cardDealer.returnCardList(cardsToReturn);
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
        if (gameScreen.isOnline()) {
            if (gamer instanceof LocalClientGamer) {
                if (cardsToClient != null) {
                    gamer.setCards(new ArrayList<>(cardsToClient.subList(0, cardQuantity)));
                    this.gamer.setCardState(CardState.DEALTCARDS);
                    cardsToClient = null;
                }
            } else if (gamer instanceof ExternalHostGamer) {
                if (chosenHostCards != null) {
                    gamer.setCards(chosenHostCards);
                    this.gamer.setCardState(CardState.DEALTCARDS);
                    chosenHostCards = null;
                }
            } else if (gamer instanceof LocalHostGamer) {
                gamer.setCards(cardDealer.dealCards(cardQuantity));
                this.gamer.setCardState(CardState.DEALTCARDS);
            } else if (gamer instanceof ExternalClientGamer) {
                if (cardsToClient == null) cardsToClient = cardDealer.dealCards(cardQuantity);
                if (chosenClientCards != null) {
                    gamer.setCards(chosenClientCards);
                    this.gamer.setCardState(CardState.DEALTCARDS);
                    chosenClientCards = null;
                }
            }
        } else {
            gamer.setCards(cardDealer.dealCards(cardQuantity));
            this.gamer.setCardState(CardState.DEALTCARDS);
        }
    }

    private void powerDownRound() {
        gamer.getSheet().resetDamage();
        for (int i = 0; i < 5; i++) {
            gamer.getSheet().placeCardInSlot(cardDealer.dealBlankCard());
        }
    }

    private void LocalCardSelect() {
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
                    if (gamer instanceof LocalClientGamer) remainingClientCards.add(gamer.getCard(i));
                    cardDealer.returnCard(gamer.getCard(i));
                }
            }
            if (gamer instanceof LocalClientGamer) {
                chosenClientCards = gamer.getSheet().getChosenCardsFromSlots();
                remainingClientCards = gamer.getCards();
                remainingClientCards.removeAll(chosenClientCards);
            }
            if (gamer instanceof LocalHostGamer) {
                chosenHostCards = gamer.getSheet().getChosenCardsFromSlots();
            }
            gamer.setCardState(CardState.SELECTEDCARDS);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            gamer.getSheet().placeCardInSlot(cardDealer.dealBlankCard());
        }
    }

    private void ExternalCardSelect() {

        if (gamer instanceof ExternalHostGamer) {
            if (chosenHostCards != null) {
                for (AbstractCard c : gamer.getCards()) gamer.getSheet().placeCardInSlot(c);
                gamer.getCards().clear();
                gamer.setCardState(CardState.SELECTEDCARDS);
            }
        } else if (gamer instanceof ExternalClientGamer) {
            if (chosenClientCards != null) {
                for (AbstractCard c : gamer.getCards()) gamer.getSheet().placeCardInSlot(c);
                gamer.getCards().clear();
                if (remainingClientCards != null) {
                    cardDealer.returnCardList((ArrayList) remainingClientCards);
                    remainingClientCards = null;
                }
                gamer.setCardState(CardState.SELECTEDCARDS);
            }
        }
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
