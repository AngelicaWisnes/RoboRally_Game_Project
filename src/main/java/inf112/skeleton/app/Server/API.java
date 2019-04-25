package inf112.skeleton.app.Server;

public abstract class API {

    public serverAction sAction;

    public API(serverAction sAction) {
        this.sAction = sAction;
    }

    public abstract void connect() throws InterruptedException;
}
