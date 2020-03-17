package eg.edu.alexu.csd.oop.game.sample.WelcomeGUI;

import eg.edu.alexu.csd.oop.game.GameEngine;

public abstract class command {

    protected GameEngine.GameController gameController;

    public command(GameEngine.GameController gameController) {
        this.gameController = gameController;
    }
    public abstract void generate();
}

