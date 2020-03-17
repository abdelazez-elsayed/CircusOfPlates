package eg.edu.alexu.csd.oop.game.sample.Game;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.Command.BackwardCommand;
import eg.edu.alexu.csd.oop.game.sample.Command.Command;
import eg.edu.alexu.csd.oop.game.sample.Command.ForwardCommand;
import eg.edu.alexu.csd.oop.game.sample.Command.SaveCommand;
import eg.edu.alexu.csd.oop.game.sample.DGameController;
import eg.edu.alexu.csd.oop.game.sample.GUIData;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.ImageObject;
import eg.edu.alexu.csd.oop.game.sample.GameState.GameState;
import eg.edu.alexu.csd.oop.game.sample.GameState.InitialState;
import eg.edu.alexu.csd.oop.game.sample.GameState.PlayingState;
import eg.edu.alexu.csd.oop.game.sample.GameState.ReplayState;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;
import eg.edu.alexu.csd.oop.game.sample.GUI.StartUpTest;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.LeftHand;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.RightHand;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.*;
import java.util.List;


public class Game implements World {
    private static int width;
    private static int height;
    private int Freq;
    private Command cmd = new SaveCommand();
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private static ShapeFactory sF = null ;
    private boolean flag = true;
    private static int i =0;
    private int Speed = 0;
    private static Logger logger = LoggerObject.getLogger();
    private static GameState GState = new InitialState();

    public Game(GameObjectsSave GO){
        this.sF = ShapeFactory.getFactory();
        width = ShapeFactory.getFactory().getWorld().getWidth();
        height = ShapeFactory.getFactory().getWorld().getHeight();
        this.control.addAll(GO.getControl());
        this.moving.addAll(GO.getMoving());
        this.constant.addAll(ShapeFactory.getFactory().getWorld().getConstantObjects());
        this.GState = new ReplayState();
        GameData.setScore(GO.getScore());
        this.GState.doAction();
        DGameController.getInstance().resume();
    }

    public Game(int screenWidth, int screenHeight,int speed,int plSpeed) {
        logger.info("Starting game of Dimensions \n \tHeight : "+this.getHeight()+" And width : "+this.getWidth()+"\n Current Speed :  "+this.getSpeed()+" Max Time : "+GameData.getMaxTime()/(1000*60) +" Minute And " + GameData.getMaxTime()%(1000*60)+" Seconds." );
        GameData.setPlSpeed(plSpeed);
        GameData.setStartTime(System.currentTimeMillis());
        sF = ShapeFactory.getFactory();
        sF.setWorld(this);
        width = screenWidth;
        height = screenHeight;
        this.GState.doAction();
        LeftHand.setLeftHand((ImageObject)control.get(0));
        RightHand.setRightHand((ImageObject)control.get(0));

        Timer timer = new Timer();
        TimerTask task = new Game.MyTask();
        Speed = speed;
        Freq = speed*30;
        timer.schedule(task,0,Freq);
        this.GState = new PlayingState();
    }

    @Override
    public boolean refresh() {
        i++;
        if(i%25 == 0){
            try {
                cmd.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(flag) {
            Frame.getFrames()[Frame.getFrames().length-1].getComponent(0).getParent().addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == 'f') {
                        GState =new  ReplayState();
                        GState.doAction();
                        Command cmd = new BackwardCommand();
                        try {
                            cmd.execute();
                        } catch (SQLException ex) {
                        } catch (Exception ex) {
                            System.exit(0);
                        }
                    }
                    else if (e.getKeyChar() == 'b'){
                        Command cmd = new ForwardCommand();
                        try {
                            cmd.execute();
                        } catch (SQLException ex) {
                        } catch (Exception ex) {
//                            System.exit(0);
                        }
                    }
                    else if (e.getKeyChar() == ' ') {
                        try {
                            if (GUIData.getLaunchedBefore()){
                            } else{
                                GUIData.setLaunchedBefore(true);
                                ShapeFactory.getFactory().setGameover(true);
                                DGameController.getInstance().pause();
                                new Thread() {
                                    @Override
                                    public void run() {
                                        javafx.application.Application.launch(StartUpTest.class);
                                    }
                                }.start();
                                StartUpTest startUpTest = StartUpTest.waitForStartUpTest();
                                startUpTest.printSomething();
                            }
                        }
                        catch (Exception E){}
                    }else if (e.getKeyChar() == 'r'){
                        DGameController.getInstance().resume();
                    }
                    else if (e.getKeyChar() == 'p'){
                        DGameController.getInstance().resume();
                        GState = new ReplayState();
                        Command cmd = new BackwardCommand();
                        try {
                            cmd.execute();
                        } catch (Exception ex) {
                            System.exit(0);
                        }
                    }
                }
                @Override
                public void keyPressed(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {}
            });
            flag = false;
        }
        this.GState.doAction();
        boolean timeOut = GameData.gettimeOut();
        return !timeOut;
    }

    @Override
    public int getSpeed() {
        return Speed;
    }
    @Override
    public int getControlSpeed() {
        return 20;
    }
    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }
    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }
    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public String getStatus(){
        return GameData.getStatus();
    }

    private static int TurnTaker = 0;
    static class MyTask extends TimerTask
    {
        public void run()
        {
            try {
                sF.setGate(TurnTaker);
                TurnTaker++;
                TurnTaker = TurnTaker % 4;
                sF.getShape();
            }
            catch (Exception e){}
        }
    }
}