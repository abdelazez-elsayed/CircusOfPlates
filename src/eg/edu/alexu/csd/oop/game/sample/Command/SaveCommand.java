package eg.edu.alexu.csd.oop.game.sample.Command;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.Game.GameData;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Clown;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;
import eg.edu.alexu.csd.oop.game.sample.Game.GameObjectsSave;
import eg.edu.alexu.csd.oop.game.sample.Memento.Caretaker;
import eg.edu.alexu.csd.oop.game.sample.Memento.Originator;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;

import java.util.ArrayList;
import java.util.List;

public class SaveCommand implements Command {
    private static Caretaker careTaker = new Caretaker();
    @Override
    public void execute() throws Exception {
        Originator originator = new Originator();
        try {
            List<GameObject> moving = ShapeFactory.getFactory().getWorld().getMovableObjects();
            List<GameObject> control = ShapeFactory.getFactory().getWorld().getControlableObjects();
            List<GameObject> constant = ShapeFactory.getFactory().getWorld().getConstantObjects();
            ArrayList<GameObject> Mgame = new ArrayList<>();
            for (int i =0;i<moving.size();i++){
                Mgame.add(((Plates)moving.get(i)).clone());
            }
            ArrayList<GameObject> Congame = new ArrayList<>();
            for (int i =0;i<constant.size();i++){
                if (constant.get(i) instanceof Plates)
                    Congame.add(((Plates)constant.get(i)).clone());
                else Congame.add(constant.get(i));
            }
            ArrayList<GameObject> Cgame = new ArrayList<>();
            Cgame.add(Clown.getInstance().clone());
            for (int i =0;i<control.size();i++){
                if (control.get(i) instanceof Plates)
                    Cgame.add(((Plates)control.get(i)).clone());
                else if (control.get(i) instanceof Clown)
                    Cgame.add (Clown.getInstance().clone());
            }
            originator.setState(new GameObjectsSave(Congame,Mgame,Cgame, GameData.getScore()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        careTaker.addMemento(originator.save());
    }

}
