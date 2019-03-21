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
        cfg.useHDPI = true; //comment out if W10
        int resolution = java.awt.Toolkit.getDefaultToolkit().getScreenResolution(); //comment out if OSX Retina
        float multiplier = resolution / 96f; //comment out if OSX Retina
        if (Toolkit.getDefaultToolkit().getScreenSize().width * multiplier / 20 * 12 > Toolkit.getDefaultToolkit().getScreenSize().height * multiplier){
            cfg.height = Math.round(Toolkit.getDefaultToolkit().getScreenSize().height * multiplier * 0.9f);
            cfg.width = cfg.height / 12 * 20;
        } else {
            cfg.width = Math.round(Toolkit.getDefaultToolkit().getScreenSize().width * multiplier * 0.9f);
            cfg.height = cfg.width / 20 * 12;
        }

        //cfg.fullscreen = true;
        //cfg.vSyncEnabled = true;
        cfg.addIcon("assets/img/icons/icon16.png", Files.FileType.Internal);
        cfg.addIcon("assets/img/icons/icon128.png", Files.FileType.Internal);
        new LwjglApplication(new RoboRally(), cfg);
    }
}