package eg.edu.alexu.csd.oop.game.sample.GameObjects.Composite;

import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import org.apache.log4j.Logger;

public class Gate {
    private int x;
    private int y;
    Logger logger = LoggerObject.getLogger();

    public Gate(int x,int y){
        logger.info("Creating A new Gate of x : " + x + "And Y : "+y);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
