package eg.edu.alexu.csd.oop.game.sample.ShapeFactory;


import eg.edu.alexu.csd.oop.game.GameObject;

import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.DynamicLinkage.Linkage;
import eg.edu.alexu.csd.oop.game.sample.DynamicLinkage.Linker;
import eg.edu.alexu.csd.oop.game.sample.FlyWeight.FlyWeight;
import eg.edu.alexu.csd.oop.game.sample.FlyWeight.IFlyWeight;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import org.apache.log4j.Logger;
import java.util.*;

public class ShapeFactory {
    private static Logger logger = LoggerObject.getLogger();
    private static World world;
    private static List<GameObject> shapes;
    private static int gate;
    private static ShapeFactory factory;
    private static  ArrayList<String> ShapesString = new ArrayList<>();
    private boolean gameover = false ;

    private ShapeFactory() {
    }

    public static ShapeFactory getFactory(){
        if (factory==null)factory =new ShapeFactory();
        return factory;
    }

    public void addShape(String jarPath){
        logger.info("Loading Images Of Plate From Linker");
        Linkage linker = new Linker();
        linker.loadImages(jarPath);
        ShapesString = linker.getShapesString();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
        shapes = world.getMovableObjects();
    }

    public void setGate(int gate) {
        if (!gameover) {
            this.gate = gate;
        }
    }

    public void setGameover(boolean gameover) {
        this.gameover = gameover;
    }

    public void getShape() {
        if (!gameover) {
            String type = getRandomFullShape();
            IFlyWeight fl = new FlyWeight();
            fl.getShape(type,gate,shapes);
        }
    }

    private String getRandomFullShape(){
        return ShapesString.get((int) (Math.random()*ShapesString.size()));
    }
}