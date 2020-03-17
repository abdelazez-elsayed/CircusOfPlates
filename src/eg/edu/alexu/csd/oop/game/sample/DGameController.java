package eg.edu.alexu.csd.oop.game.sample;

import eg.edu.alexu.csd.oop.game.GameEngine;

public class DGameController {
    private static GameEngine.GameController ourInstance;

    public static GameEngine.GameController getInstance() {
        return ourInstance;
    }

    public static void setWorld(GameEngine.GameController OurInstance){
        ourInstance = OurInstance;
    }

    private DGameController() {
    }
}
