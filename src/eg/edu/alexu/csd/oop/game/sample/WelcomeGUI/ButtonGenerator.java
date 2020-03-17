package eg.edu.alexu.csd.oop.game.sample.WelcomeGUI;

import eg.edu.alexu.csd.oop.game.GameEngine;
import eg.edu.alexu.csd.oop.game.sample.Strategy.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ButtonGenerator extends command {

    private Strategy strategy;
    private JToggleButton e,m,h,s,g;
    private JFrame frame;
    int strategyLevel=0;

    public ButtonGenerator(GameEngine.GameController gameController) {
        super(gameController);
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public GameEngine.GameController getControl() {
        return this.gameController;
    }

    public void generate(){
        //select Button
        s = new JToggleButton();
        s.setIcon(new ImageIcon("images/select.png"));
        s.setBounds(240, 53, 368, 82);
        s.setBorder(null);
        //gro Button
        g = new JToggleButton();
        g.setIcon(new ImageIcon("images/gro.png"));
        g.setBounds(47, 35, 167, 383);
        g.setBorder(null);
        //easy Button
        e = new JToggleButton();
        e.setIcon(new ImageIcon("images/minEasy.png"));
        e.setBounds(321, 169, 115, 232);
        e.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.out.println("d5l f easy");
                strategyLevel=1;
                setStrategy(1);
                frame.setVisible(false);
                chooseStrategy();
            }});
//        e.addActionListener(new A<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
////
//            }
//        });
        //normal Button
        m = new JToggleButton();
        m.setBounds(511, 169, 115, 232);
        m.setIcon(new ImageIcon("images/minMed.png"));
        m.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                strategyLevel=2;
                setStrategy(2);
                frame.setVisible(false);
                chooseStrategy();

            }});
        //hard Button
        h = new JToggleButton();
        h.setBounds(697, 169, 115, 232);
        h.setIcon(new ImageIcon("images/minHard.png"));
        h.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                strategyLevel=3;
                setStrategy(3);
                frame.setVisible(false);
                chooseStrategy();

            }});

    }

    public void chooseStrategy(){
        System.out.println("gah hna");
        int stLevel=getStrategy();
        System.out.println("Level"+stLevel);
        StrtegyFacade st =new StrtegyFacade(stLevel);
    }

    public void setStrategy(int x){
        if(x==1){
            strategy=new Level1Strategy();
            strategyLevel=1;
        }else if(x==2){
            strategy = new Level2Strategy();
            strategyLevel=2;
        }else if(x==3){
            strategy = new Level3Strategy();
            strategyLevel=3;
        }
        System.out.println(strategy+"strategy level");
    }

    public int getStrategy() {
        return strategyLevel;
    }


    public JToggleButton getE() {
        return e;
    }

    public JToggleButton getM() {
        return m;
    }

    public JToggleButton getH() {
        return h;
    }
    public JToggleButton getS() {
        return s;
    }
    public JToggleButton getG() {
        return g;
    }

}

