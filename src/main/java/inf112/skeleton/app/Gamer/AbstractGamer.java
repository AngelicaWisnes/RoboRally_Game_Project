package inf112.skeleton.app.Gamer;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.ArrayList;
import java.util.List;

public class AbstractGamer implements IGamer {

    private TiledMap map;
    private ProgramSheet sheet;
    private String name;
    private int playerNumber;
    private CardState cardState;

    protected List<AbstractCard> cardsOnHand;

    public AbstractGamer(TiledMap map, String name, int playerNumber) {
        this.map = map;
        this.name = name;
        this.playerNumber = playerNumber;
        sheet = new ProgramSheet(map, playerNumber);
        cardState = CardState.NOCARDS;
    }

    @Override
    public ProgramSheet getSheet() {
        return sheet;
    }

    @Override
    public void resetCards() {
        cardsOnHand = new ArrayList<>();
    }

    @Override
    public void setCards(List<AbstractCard> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    @Override
    public AbstractCard getCard(int i) {
        return cardsOnHand.get(i);
    }

    @Override
    public List<AbstractCard> getCards() {
        return this.cardsOnHand;
    }

    @Override
    public void setCardState(CardState cardState) {
        this.cardState = cardState;
    }

    @Override
    public CardState getCardState() {
        return cardState;
    }

    @Override
    public TiledMap getMap() {
        return map;
    }
}
