package eg.edu.alexu.csd.oop.game.sample.State;

import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;

public class FloorState implements State{
    @Override
    public void doAction(Plates plate){
        plate.setVisible(false);
    }
}
