package inf112.skeleton.app.Network;

public abstract class API {

    public serverAction sAction;

    // TODO javadoc
    public API(serverAction sAction) {
        this.sAction = sAction;
    }

    // TODO javadoc
    public abstract void connect() throws InterruptedException;
}
