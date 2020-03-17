package eg.edu.alexu.csd.oop.game.sample.GUI;
import eg.edu.alexu.csd.oop.game.sample.Logger.LoggerObject;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.concurrent.CountDownLatch;

public class MainLoader extends Application {
    private static Logger logger = LoggerObject.getLogger();
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static MainLoader startUpTest = null;

    public static MainLoader waitForStartUpTest() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return startUpTest;
    }

    public static void MainLoader(MainLoader startUpTest0) {
        startUpTest = startUpTest0;
        latch.countDown();
    }

    public MainLoader() {
        MainLoader(this);
    }

    public void printSomething() {
        System.out.println("You called a method on the application");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Platform.setImplicitExit(false);
        logger.info("Pausing The Game");
        logger.info("Load Transient GUI");
        Parent root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
        primaryStage.setTitle("Game Over");
        primaryStage.setScene(new Scene(root, 379, 435));
        primaryStage.show();
        URL resource = getClass().getResource("/HMM.mp3");
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                mediaPlayer.stop();
            }
        });

    }
    public static void main(String[] args) {
        launch(args);
    }
}
