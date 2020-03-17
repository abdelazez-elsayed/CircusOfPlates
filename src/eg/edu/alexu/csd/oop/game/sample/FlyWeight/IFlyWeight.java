package eg.edu.alexu.csd.oop.game.sample.FlyWeight;

import eg.edu.alexu.csd.oop.game.GameObject;

import java.util.List;

public interface IFlyWeight{
    public void getShape(String type, int gate, List<GameObject> shapes);
}
