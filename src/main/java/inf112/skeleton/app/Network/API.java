package inf112.skeleton.app.Network;

public abstract class API {

    public serverAction sAction;

    public API(serverAction sAction) {
        this.sAction = sAction;
    }

    public abstract void connect() throws InterruptedException;
}
