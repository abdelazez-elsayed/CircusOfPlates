package eg.edu.alexu.csd.oop.game.sample.GameState;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.sample.Game.GameData;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.*;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import eg.edu.alexu.csd.oop.game.sample.Observer.Change;
import eg.edu.alexu.csd.oop.game.sample.Observer.Subject;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;
import eg.edu.alexu.csd.oop.game.sample.State.*;
import org.apache.log4j.Logger;
import java.util.Stack;

public class PlayingState implements GameState {
    private static Logger logger = LoggerObject.getLogger();
    private boolean timeOut = GameData.gettimeOut();
    private static int MaxTime = GameData.getMaxTime();
    private static long startTime = GameData.getStartTime();

    @Override
    public void doAction() {
        timeOut = System.currentTimeMillis() - startTime > MaxTime; // time end and game over
        ImageObject lH = LeftHand.getLeftHand();
        Stack<Plates> lHS = LeftHand.getLeftHandStack();
        ImageObject rH = RightHand.getRightHand();
        Stack<Plates> rHS = RightHand.getRightHandStack();
        java.util.List<GameObject> moving = ShapeFactory.getFactory().getWorld().getMovableObjects();
        java.util.List<GameObject> control = ShapeFactory.getFactory().getWorld().getControlableObjects();

        for(int i=0;i<moving.size();i++) {
            if (((Plates) moving.get(i)).getState() instanceof ShelfState || ((Plates) moving.get(i)).getState() instanceof FallingState) {
                ((Plates) moving.get(i)).getState().doAction(((Plates) moving.get(i)));
            }
            else if (((Plates)moving.get(i)).getState() instanceof FloorState)((Plates)moving.get(i)).getState().doAction((Plates) moving.get(i));

            if (((Plates) moving.get(i)).getState() instanceof FallingState) {
//                Plates plateTest = (Plates) moving.get(i);
                if (intersect((ImageObject) moving.get(i), lH,'L')) {
                    if(! (lH instanceof Clown))
                        logger.info("Left hand intersection");
                    lH = (ImageObject) moving.get(i);
                    lHS.push((Plates)lH);
                    ((Plates) moving.get(i)).setState((State) new CaughtState());
                    control.add(moving.get(i));
                    moving.remove(i);
//                    plateTest.setState(new CaughtState());
                    getScoreFrom(lHS);
                    if(!lHS.empty())
                        lH = ((Plates)lHS.peek());
                    else
                        lH = (Clown.getInstance());
                    logger.info("Current Peek of Left Hand  : "+lH.getPath());
                } else if (intersect((ImageObject) moving.get(i), rH ,'R')) {
                    if(! (rH instanceof Clown))
                        logger.info("Right hand intersection");
                    rHS.push((Plates) moving.get(i));
                    rH = ((ImageObject) moving.get(i));
                    ((Plates) moving.get(i)).setState(new CaughtState());
                    control.add(moving.get(i));
                    moving.remove(i);
//                    plateTest.setState(new CaughtState());
                    getScoreFrom(rHS);
                    if(!rHS.empty())
                        rH = ((Plates)rHS.peek());
                    else
                        rH = (Clown.getInstance());
                    logger.info("Current Peek of Right Hand  : "+rH.getPath());
                }
            }
        }
        if(rHS.size() > 1 && lHS.size() > 1) {
            if (rHS.peek().getY() < 80 && lHS.peek().getY() < 80) {
                timeOut = true;
                GameData.settimeOut(true);
//                DGameController.getInstance().pause();
                ShapeFactory.getFactory().setGameover(true);
            }
        }
        LeftHand.setLeftHand(lH);
        LeftHand.setLeftHandStack(lHS);
        RightHand.setRightHand(rH);
        RightHand.setRightHandStack(rHS);
        if (timeOut){
            GameState gs = new GameOverState();
            gs.doAction();
        }
    }

    private boolean intersect(ImageObject o1, ImageObject o2,char Ch){
        int ObCentreX = 2*o1.getX()+o1.getWidth();
        ObCentreX=ObCentreX/2;
        if(o2 instanceof Clown) {
            if ((Math.abs(ObCentreX-o2.getX())<o1.getWidth()/3) && (Math.abs(o1.getY() - o2.getY()+o1.getHeight()) < 4 && Ch=='L')) {
                logger.info("Left hand Clown Intersection/Object Type : "+((Plates)o1).getPath());
                //System.exit(0);
                return true;
            }
            else if ((Math.abs(ObCentreX-o2.getX()-(o2.getWidth()))<o1.getWidth()/3) && (Math.abs(o1.getY() - o2.getY()+o1.getHeight()) < 4&&Ch=='R')){
                logger.info("Right hand Clown Intersection/Object Type : "+((Plates)o1).getPath());
                return true;
            }
            return false;
        }
        else {
            if ((Math.abs(o1.getX()-o2.getX())<o1.getWidth()/2) && (Math.abs(o1.getY() - o2.getY()  +o1.getHeight()) < 4)) {
                logger.info("Object intersection of type "+((Plates)o1).getPath());
                return true;
            }
            return false;
        }
    }

    private void getScoreFrom ( Stack<Plates> HandStack ){
        Subject subject = new Subject();
        subject.setWorld(ShapeFactory.getFactory().getWorld());
        new Change(subject , subject.getWorld() , HandStack );
        subject.setState(GameData.getScore());
        GameData.setScore(subject.getState());
    }
}
