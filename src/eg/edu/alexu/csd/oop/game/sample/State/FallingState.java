package eg.edu.alexu.csd.oop.game.sample.State;

import eg.edu.alexu.csd.oop.game.sample.Game.GameData;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;

public class FallingState implements State {
    private Object FloorState = new FloorState();
    private static int plSpeed = GameData.getPlSpeed();

    @Override
    public void doAction(Plates plate) {
        plate.setY((plate.getY() + plSpeed));
        if(plate.getY() > ShapeFactory.getFactory().getWorld().getHeight()){
            plate.setState((State) FloorState);
            plate.getState().doAction(plate);
        }
    }
}
