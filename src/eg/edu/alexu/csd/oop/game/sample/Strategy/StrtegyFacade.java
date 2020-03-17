package eg.edu.alexu.csd.oop.game.sample.Strategy;

import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import org.apache.log4j.Logger;

public class StrtegyFacade {
    private static int stLevel;
    private Level1Strategy level1 = new Level1Strategy();
    private Level2Strategy level2 = new Level2Strategy();
    private Level3Strategy level3 = new Level3Strategy();

    public StrtegyFacade(int stLevel){
        Logger logger = LoggerObject.getLogger();
        this.stLevel=stLevel;
        switch (stLevel){
            case 1:
                loadLevel1();
                break;
            case 2:
                loadLevel2();
                break;
            case 3:
                loadLevel3();
                break;

        }
    }

    public void loadLevel1(){
        level1.loadGame();
    }
    public void loadLevel2(){
        level2.loadGame();
    }
    public void loadLevel3(){
        level3.loadGame();
    }

    public static int getStLevel() {
        return stLevel;
    }
}
