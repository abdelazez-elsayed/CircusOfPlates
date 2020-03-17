package eg.edu.alexu.csd.oop.game.sample.Command;

import eg.edu.alexu.csd.oop.game.sample.DGameController;
import eg.edu.alexu.csd.oop.game.sample.Memento.Caretaker;
import eg.edu.alexu.csd.oop.game.sample.Memento.Originator;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;

public class BackwardCommand implements Command  {
    @Override
    public void execute() throws Exception {
        DGameController.getInstance().pause();
        Originator or = new Originator();
        Caretaker cr = new Caretaker();
        or.getStateFromMemento(cr.getMemento(true));
        ShapeFactory.getFactory().setGameover(true);
        or.restore();
    }
}
