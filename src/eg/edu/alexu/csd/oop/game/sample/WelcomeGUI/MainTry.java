package eg.edu.alexu.csd.oop.game.sample.WelcomeGUI;

import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import org.apache.log4j.Logger;

import java.awt.*;

public class MainTry {
    public static void main(String[] args) {
        Logger logger = LoggerObject.getLogger();
        logger.info("Loading Welcome GUI");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//                    SoundPlayer.play("/HMM.mp3");
                    MainTry wind7ow = new  MainTry();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        MainMenu m = new MainMenu();
        m.start();
    }
}
