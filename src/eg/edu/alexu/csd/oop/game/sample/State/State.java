package eg.edu.alexu.csd.oop.game.sample.State;

import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;

public interface State {
    public void doAction(Plates plate);
}
