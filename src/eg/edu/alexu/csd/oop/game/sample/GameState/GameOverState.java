package eg.edu.alexu.csd.oop.game.sample.GameState;

import eg.edu.alexu.csd.oop.game.sample.DGameController;
import eg.edu.alexu.csd.oop.game.sample.GUI.MainLoader;
import eg.edu.alexu.csd.oop.game.sample.GUIData;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;

public class GameOverState implements GameState {
    @Override
    public void doAction() {
        try {
            DGameController.getInstance().pause();
            if (!GUIData.getLaunchedBefore()){
                GUIData.setLaunchedBefore(true);
                new Thread() {
                    @Override
                    public void run() {
                        javafx.application.Application.launch(MainLoader.class);
                    }
                }.start();
                MainLoader startUpTest = MainLoader.waitForStartUpTest();
                startUpTest.printSomething();
                ShapeFactory.getFactory().setGameover(true);
            }
        }
        catch (Exception E){}
    }
}
