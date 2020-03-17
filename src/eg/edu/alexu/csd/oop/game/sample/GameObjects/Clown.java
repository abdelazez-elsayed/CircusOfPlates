package eg.edu.alexu.csd.oop.game.sample.GameObjects;

public class Clown extends ImageObject implements Cloneable {
    private static Clown ourInstance = new Clown(650,470,"/smurfy.png");

    public static Clown getInstance() {
        return ourInstance;
    }

    public Clown(int posX, int posY, String path) {
        super(posX, posY, path);
    }
    @Override
    public void setY(int my){
        return;
    }
    public Clown clone() throws CloneNotSupportedException {
        return (Clown) super.clone();
    }
}
