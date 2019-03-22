package inf112.skeleton.app;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import inf112.skeleton.app.Screens.RoboRally;
import java.awt.Toolkit;



public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally!";
        //either resolution (W10) or HDPI (OSX Retina) must be used to get proper sized screen
        if (Toolkit.getDefaultToolkit().getScreenSize().width / 26 * 14 > Toolkit.getDefaultToolkit().getScreenSize().height){
            cfg.height = Math.round(Toolkit.getDefaultToolkit().getScreenSize().height * 0.9f);
            cfg.width = cfg.height / 14 * 26;
        } else {
            cfg.width = Math.round(Toolkit.getDefaultToolkit().getScreenSize().width * 0.9f);
            cfg.height = cfg.width / 26 * 14;
        }
        //cfg.fullscreen = true;
        //cfg.vSyncEnabled = true;
        cfg.addIcon("assets/img/icons/icon16.png", Files.FileType.Internal);
        cfg.addIcon("assets/img/icons/icon128.png", Files.FileType.Internal);
        new LwjglApplication(new RoboRally(), cfg);
    }
}