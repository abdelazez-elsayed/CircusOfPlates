package eg.edu.alexu.csd.oop.game.sample.Game;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

public class GameObjectsSave {
    private int score;
    private List<GameObject> control;
    private List<GameObject> moving;
    private List<GameObject> constant;
    private static GameObjectsSave saved;


    public GameObjectsSave(List<GameObject> constant,List<GameObject> moving,List<eg.edu.alexu.csd.oop.game.GameObject> control,int score){
        this.constant = constant;
        this.moving = moving;
        this.control = control;
        this.score = score;
    }

    public static GameObjectsSave getSaved() {
        return saved;
    }

    public static void setSaved(GameObjectsSave saved) {
        GameObjectsSave.saved = saved;
    }

    public List<eg.edu.alexu.csd.oop.game.GameObject> getControl() {
        return control;
    }

    public int getScore() {
        return score;
    }

    public List<GameObject> getMoving() {
        return moving;
    }
}
