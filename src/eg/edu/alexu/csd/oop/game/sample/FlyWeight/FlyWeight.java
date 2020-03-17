package eg.edu.alexu.csd.oop.game.sample.FlyWeight;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.DynamicLinkage.Linker;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite.GateDirector;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import eg.edu.alexu.csd.oop.game.sample.State.ShelfState;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class FlyWeight implements IFlyWeight {
    Logger logger = LoggerObject.getLogger();
    @Override
    public void getShape(String type, int gate, List<GameObject> shapes) {
        Map<String,Class<? extends Plates> > ShapesClasses = new Linker().getClasses();
        ListIterator<GameObject> iterator = shapes.listIterator();
        System.out.println(ShapesClasses);
        while (iterator.hasNext()) {
            Plates plate = (Plates) iterator.next();
            String PlateType = plate.getColor()+plate.getType();
            if (type.equalsIgnoreCase(PlateType) && !plate.isVisible()) {
                logger.info("(Flyweight) Using old shape of type " + PlateType);
                plate.setGate(gate);
                plate.setX(GateDirector.getInstance().showGateDetails(gate).getX());
                plate.setY(GateDirector.getInstance().showGateDetails(gate).getY());
                plate.setState(new ShelfState());
                plate.setVisible(true);
                return;
            }
        }
        try {
            logger.info("Set new Shape of Type "+type+" Shape at Gate : " + gate);
            type="eg.edu.alexu.csd.oop.game.sample.GameObjects."+type;
            Constructor constructor=ShapesClasses.get(type).getDeclaredConstructor(int.class,int.class,String.class);
            Plates plate = (Plates)constructor.newInstance(GateDirector.getInstance().showGateDetails(gate).getX(),GateDirector.getInstance().showGateDetails(gate).getY(),"/"+type+".png");
            plate.setGate(gate);
            plate.setVisible(true);
            plate.setState(new ShelfState());
            // plate.setColor(color);
            shapes.add(plate);
            return;
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e ) {
            e.printStackTrace();
        }
    }
}
