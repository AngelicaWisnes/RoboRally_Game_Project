package inf112.skeleton.app;

import inf112.skeleton.app.Enums.CardState;
import inf112.skeleton.app.Enums.RoundState;

public interface IController {
    void runGame(CardState state, RoundState roundState);
}
