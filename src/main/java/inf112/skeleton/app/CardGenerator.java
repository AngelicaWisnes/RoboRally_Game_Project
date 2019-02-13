package inf112.skeleton.app;

import inf112.skeleton.app.Enums.Rotation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CardGenerator {
    private static ArrayList<Card> cards;

    public static ArrayList<Card> getNewCardStack() {
        cards = new ArrayList<>();
        createCards();
        return cards;
    }


    private static void createCards() {
        rotate(Rotation.TURN_COUNTER_CLOCKWISE, 70, 18, 20);
        rotate(Rotation.TURN_CLOCKWISE, 80, 18, 20);
        rotate(Rotation.TURN_AROUND, 10, 6, 10);
        movement(1, 490, 18, false);
        movement(2, 670, 12, false);
        movement(3, 790, 6, false);
        movement(1, 430, 6, true);
    }


    private static void movement(int steps, int startingValue, int n, boolean backwards) {
        for (int i = 0; i < n; i++) {
            if (backwards) {
                cards.add(new MoveBackwards(startingValue + (10 * i), steps + 1));
            } else {
                cards.add(new MoveForward(startingValue + (10 * i), steps + 1));
            }
        }
    }

    private static void rotate(Rotation rotation, int startingValue, int n, int increment) {
        for (int i = 0; i < n; i++) {
            cards.add(new RotationCard(startingValue + (increment * i), rotation));
        }
    }
}
