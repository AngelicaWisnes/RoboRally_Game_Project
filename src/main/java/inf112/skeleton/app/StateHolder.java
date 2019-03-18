package inf112.skeleton.app;

import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.RoundState;


public class StateHolder {
    private CardState cardState;
    private RoundState roundState;

    public StateHolder(CardState cardState, RoundState roundState) {
        this.cardState = cardState;
        this.roundState = roundState;

    }

    public CardState getCardState() {
        return cardState;
    }

    public void setCardState(CardState cardState) {
        this.cardState = cardState;
    }

    public RoundState getRoundState() {
        return roundState;
    }

    public void setRoundState(RoundState roundState) {
        this.roundState = roundState;
    }

}

