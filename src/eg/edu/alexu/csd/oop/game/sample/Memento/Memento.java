package eg.edu.alexu.csd.oop.game.sample.Memento;

import eg.edu.alexu.csd.oop.game.sample.Game.GameObjectsSave;

public class Memento {
    private GameObjectsSave state;

    public Memento (GameObjectsSave state){
        this.state = state;
    }

    public GameObjectsSave getState(){
        return state;
    }
}
