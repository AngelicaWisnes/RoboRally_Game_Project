package inf112.skeleton.app;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.ArrayList;
import java.util.List;

public interface IGamer {
    ProgramSheet getSheet();
    void resetCards();
    void setCards(List<AbstractCard> cardsOnHand);
    AbstractCard getCard(int i);
    void setCardState(CardState cardState);
    CardState getCardState();
    TiledMap getMap();
    List<AbstractCard> getCards();
}
