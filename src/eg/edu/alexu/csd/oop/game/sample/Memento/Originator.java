package eg.edu.alexu.csd.oop.game.sample.Memento;

import eg.edu.alexu.csd.oop.game.sample.DGameController;
import eg.edu.alexu.csd.oop.game.sample.Game.GameObjectsSave;
import eg.edu.alexu.csd.oop.game.sample.Game.Game;

public class Originator {
    private GameObjectsSave state;

    public void setState(GameObjectsSave state){
        this.state = state;
    }

    public Memento save(){
        return new Memento(state);
    }

    public void restore(){
        DGameController.getInstance().changeWorld(new Game(state));
    }

    public void getStateFromMemento(Memento memento) throws Exception {
        try {
            state = memento.getState();
        }
        catch (Exception e){
            throw new Exception();
        }
    }
}