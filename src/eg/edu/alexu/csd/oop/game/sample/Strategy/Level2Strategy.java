package eg.edu.alexu.csd.oop.game.sample.Strategy;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.sample.DGameController;
import eg.edu.alexu.csd.oop.game.sample.Game.Game;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import org.apache.log4j.Logger;

import java.awt.*;

public class Level2Strategy implements Strategy {
    private Game level_2;

    @Override
    public void loadGame() {
        Logger logger = LoggerObject.getLogger();
        logger.info("Loading Level 2");
        level_2  = new Game(1250, 675,10,2) ;
        DGameController.setWorld(GameEngine.start("Demo Game Level 2", level_2, Color.BLACK));
    }
}
