package inf112.skeleton.app.Card;

public class BlankCard extends AbstractCard{

    public BlankCard(int priority) {
        super(priority);
    }

    @Override
    public String getKey() {
        return "Blank card";
    }

    @Override
    public String getDescription() {
        return "Blank card";
    }
}
