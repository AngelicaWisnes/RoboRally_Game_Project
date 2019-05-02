package inf112.skeleton.app.Gamer;

import com.badlogic.gdx.maps.tiled.TiledMap;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.ProgramSheet.ProgramSheet;

import java.util.ArrayList;
import java.util.List;

public interface IGamer {
    ProgramSheet getSheet();

    /**
     * resets the cards
     */
    void resetCards();

    /**
     *
     * @param cardsOnHand list of the cards on hand
     */
    void setCards(List<AbstractCard> cardsOnHand);

    /**
     *
     * @param i
     * @return
     */
    AbstractCard getCard(int i);

    /**
     *
     * @return the cards
     */
    List<AbstractCard> getCards();

    /**
     *
     * @param cardState set the state of the card
     */
    void setCardState(CardState cardState);

    /**
     *
     * @return status on the card
     */
    CardState getCardState();

    /**
     *
     * @return the map
     */
    TiledMap getMap();

    /**
     *
     * @return the name of the gamer
     */
    String getName();

    /**
     *
     * @return the image of the gamer
     */
    String getImage();
}
