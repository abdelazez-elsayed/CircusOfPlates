package eg.edu.alexu.csd.oop.game.sample.DynamicLinkage;

import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;

import java.util.ArrayList;
import java.util.Map;


public interface Linkage {
    public void loadImages(String jarPath);
    public Map<String,Class<? extends Plates> >getClasses();
    public ArrayList<String> getColors();
    public ArrayList<String> getShapes();
    public ArrayList<String> getShapesString();
}
