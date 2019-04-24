package inf112.skeleton.app;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import inf112.skeleton.app.Screens.RoboRally;

public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally!";
        cfg.useHDPI = true; //comment out if W10
        cfg.width = 1620;
        cfg.height = 972;
        cfg.addIcon("assets/img/icons/icon16.png", Files.FileType.Internal);
        cfg.addIcon("assets/img/icons/icon128.png", Files.FileType.Internal);
        new LwjglApplication(new RoboRally(), cfg);
    }
}