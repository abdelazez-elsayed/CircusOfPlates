package eg.edu.alexu.csd.oop.game.sample.Strategy;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.sample.DGameController;
import eg.edu.alexu.csd.oop.game.sample.Game.Game;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import org.apache.log4j.Logger;

import java.awt.*;

public class Level3Strategy implements Strategy {
    private Game level_3;

    @Override
    public void loadGame() {
        Logger logger = LoggerObject.getLogger();
        logger.info("Loading Level 3");
        level_3  = new Game(1250, 675, 10,3) ;
        DGameController.setWorld(GameEngine.start("Demo Game Level 3", level_3, Color.BLACK));
    }
}
