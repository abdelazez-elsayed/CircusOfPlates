package eg.edu.alexu.csd.oop.game.sample.WelcomeGUI;

import eg.edu.alexu.csd.oop.game.GameEngine;

import javax.swing.*;
import java.awt.*;


public class GameDifficultyBox extends command {

    private ButtonGenerator buttonGenerator;
    private JFrame frame;

    public GameDifficultyBox(GameEngine.GameController gameController) {
        super(gameController);
    }

    public void setButtonGenerator(ButtonGenerator buttonGenerator) {
        this.buttonGenerator = buttonGenerator;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void  generate(){

        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(buttonGenerator.getE());
        frame.getContentPane().add(buttonGenerator.getM());
        frame.getContentPane().add(buttonGenerator.getH());
        frame.getContentPane().add(buttonGenerator.getS());
        frame.getContentPane().add(buttonGenerator.getG());
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void setFrame() {
        frame = new JFrame();

        frame.setBounds(100, 100, 895, 500);

    }
}
