package eg.edu.alexu.csd.oop.game.sample.Command;

import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;

import org.apache.log4j.Logger;

import java.awt.*;
import java.sql.SQLException;

public class NewGameCommand implements Command {
    private static Logger logger = LoggerObject.getLogger();
    @Override
    public void execute() throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
