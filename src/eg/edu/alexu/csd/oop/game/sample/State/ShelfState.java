package eg.edu.alexu.csd.oop.game.sample.State;

import eg.edu.alexu.csd.oop.game.sample.Game.GameData;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite.ShelfDirector;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;

public class ShelfState implements State {
    private Object FallingState = new FallingState();
    private static int plSpeed = GameData.getPlSpeed();

    @Override
    public void doAction(Plates plate) {
        if(plate.getGate()== 0||plate.getGate() == 2) {
            plate.setX((plate.getX() + plSpeed));
            if (plate.getX() > ShelfDirector.getInstance().showShelfeDetails(plate.getGate()).getWidth())
                plate.setState((State) FallingState);
        }
        else if(plate.getGate() == 1||plate.getGate() == 3){
            plate.setX((plate.getX() - plSpeed));
            if (plate.getX() < ShelfDirector.getInstance().showShelfeDetails(plate.getGate()).getX()-60)
                plate.setState((State) FallingState);
        }
    }
}