package inf112.skeleton.app;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally!";
        cfg.width = 900;
        cfg.height = 900;
        cfg.addIcon("assets/img/icons/icon16.png", Files.FileType.Internal);
        cfg.addIcon("assets/img/icons/icon128.png", Files.FileType.Internal);
        new LwjglApplication(new BoardGUI(), cfg);
    }
}