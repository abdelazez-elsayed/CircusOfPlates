package eg.edu.alexu.csd.oop.game.sample.GameState;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Clown;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite.Gate;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite.GateDirector;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite.Shelf;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite.ShelfDirector;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.ImageObject;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;

import java.awt.*;
import java.util.List;

public class InitialState implements GameState {
    @Override
    public void doAction() {
        java.util.List<GameObject> control = ShapeFactory.getFactory().getWorld().getControlableObjects();
        List<GameObject> constant = ShapeFactory.getFactory().getWorld().getConstantObjects();

        ShapeFactory sF = ShapeFactory.getFactory();
        sF.addShape("Sample.jar");

        control.add(Clown.getInstance());
        constant.add(new ImageObject((int)(0),(int)(-250),"/kk.png"));
        constant.add(new Shelf(10,70,450,true, Color.BLACK));
        constant.add(new Shelf(800,70,500,true, Color.BLACK));
        constant.add(new Shelf(10,70+100,250,true, Color.BLACK));
        constant.add(new Shelf(1000,70+100,300,true, Color.BLACK));
        for(int i = 1;i<constant.size();i++)
            ShelfDirector.getInstance().addShelf((Shelf)constant.get(i));
        GateDirector.getInstance().addGate(new Gate(ShelfDirector.getInstance().showShelfeDetails(0).getX(), 0));
//          sF.setGate(0);
//          sF.getShape();
        GateDirector.getInstance().addGate(new Gate(ShelfDirector.getInstance().showShelfeDetails(1).getX()+ShelfDirector.getInstance().showShelfeDetails(1).getWidth(), 0));
//          sF.setGate(1);
//        sF.getShape();
        //    moving.add(sF.getShape());
        GateDirector.getInstance().addGate(new Gate(ShelfDirector.getInstance().showShelfeDetails(2).getX(), 0+100));
//            sF.setGate(2);
//        sF.getShape();
        // moving.add(sF.getShape());
        GateDirector.getInstance().addGate(new Gate(ShelfDirector.getInstance().showShelfeDetails(3).getX()+ShelfDirector.getInstance().showShelfeDetails(3).getWidth(), 0+100));
//           sF.setGate(3);
//        sF.getShape();
        //   moving.add(sF.getShape());
    }
}
