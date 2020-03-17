package eg.edu.alexu.csd.oop.game.sample.GameObjects;

import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;
import eg.edu.alexu.csd.oop.game.sample.State.CaughtState;
import eg.edu.alexu.csd.oop.game.sample.State.ShelfState;
import eg.edu.alexu.csd.oop.game.sample.State.State;

import java.awt.image.BufferedImage;


public class Plates extends ImageObject implements Cloneable {
    private final Object ShelfState = new ShelfState();
    private int gate;
    private String path;
    private boolean isUsed;
    private String color ;
    private String type;

   public  void setBuf(BufferedImage img){
        super.setBuf(img);
   }


    public Plates clone() throws CloneNotSupportedException {
        return (Plates) super.clone();
    }


    public Plates(int posX, int posY, String path) {
        super(posX, posY, path);
        state = (State) ShelfState;
        this.path = path;
        isUsed = false;
//        isControllable=false;
    }

    private State state;

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public int getGate() {
        return gate;
    }
    @Override
    public void setX(int myX){
        if(this.getState() instanceof CaughtState&&(Clown.getInstance().getX()==0 || Clown.getInstance().getX()== ShapeFactory.getFactory().getWorld().getWidth()-Clown.getInstance().getWidth())){
            return;
        }
        super.setX(myX);
    }
    @Override
    public void setY(int newY){
        if(this.getState() instanceof CaughtState)return;
        super.setY(newY);
    }
    public void setGate(int gate) {
        this.gate = gate;
    }
    public String getPath(){
        return this.getColor()+this.getType();
    }
//
//    public boolean isUsed() {
//        return isUsed;
//    }
//
//    public void setUsed(boolean used) {
//        isUsed = used;
//    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setType(String Type){
        this.type=Type;
    }
    public String getType(){return type;}
}