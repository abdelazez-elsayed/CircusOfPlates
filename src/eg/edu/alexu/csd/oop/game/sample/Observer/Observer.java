package eg.edu.alexu.csd.oop.game.sample.Observer;

import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;

import java.util.Stack;

public abstract class Observer {
    protected Subject subject;
    protected World world ;
    protected Stack <Plates>HandStack  ;
    public abstract void update();
}