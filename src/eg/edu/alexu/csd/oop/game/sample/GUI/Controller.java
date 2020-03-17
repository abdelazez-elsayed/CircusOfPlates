package eg.edu.alexu.csd.oop.game.sample.GUI;

import eg.edu.alexu.csd.oop.game.sample.Command.BackwardCommand;
import eg.edu.alexu.csd.oop.game.sample.Command.Command;
import eg.edu.alexu.csd.oop.game.sample.DGameController;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class Controller {
    Logger logger = LoggerObject.getLogger();
    @FXML
    private Pane pane;

    @FXML
    public void replay() throws SQLException {
        logger.info("Replaying");
        Command cmd = new BackwardCommand();
        try {
            cmd.execute();
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        Stage stage = (Stage) pane.getScene().getWindow();
        logger.info("Hide Transient GUI");
        stage.hide();
    }
    @FXML
    public  void resume(){
        logger.info("Resume");
        Stage stage = (Stage) pane.getScene().getWindow();
        Platform.setImplicitExit(false);
        logger.info("Hide Transient GUI");
        stage.hide();
        ShapeFactory.getFactory().setGameover(false);
        DGameController.getInstance().resume();
    }
    @FXML
    public void exit(){
        logger.info("Terminate");
        System.exit(0);
    }

//    final ListView<String> group = new ListView ();
//
//    Task<Void> task = new Task<Void>() {
//        @Override protected Void call() throws Exception {
//            group.getItems().clear();
//            for (int i=0; i<100; i++) {
//                Platform.runLater(new Runnable() {
//                    @Override public void run() {
//                        group.getItems.add(i);
//                    }
//                });
//            }
//            return null;
//        }
//    };
}
