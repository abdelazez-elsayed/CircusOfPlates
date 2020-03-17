package eg.edu.alexu.csd.oop.game.sample.WelcomeGUI;

import eg.edu.alexu.csd.oop.game.GameEngine;

public class MainMenu {

    public void start() {
        final GameEngine.GameController[] gameController = new GameEngine.GameController[1];
        ButtonGenerator buttonGenerator = new ButtonGenerator(gameController[0]);
        buttonGenerator.generate();
        GameDifficultyBox difficultyBox = new GameDifficultyBox(gameController[0]);
        difficultyBox.setFrame();
        buttonGenerator.setFrame(difficultyBox.getFrame());
        difficultyBox.setButtonGenerator(buttonGenerator);
        difficultyBox.generate();
    }
}

