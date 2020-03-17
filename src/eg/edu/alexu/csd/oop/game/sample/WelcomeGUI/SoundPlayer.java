package eg.edu.alexu.csd.oop.game.sample.WelcomeGUI;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    static Long currentFrame;
    static Clip clip;

    // current status of clip
    static String status;

    static AudioInputStream audioInputStream;
    public static void play(String filePath) throws UnsupportedAudioFileException,IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\hp\\Desktop\\College\\OOPAssignments\\CircusOfPlates\\Circus-Of-Plates\\res\\HMM.mp3").getAbsoluteFile());
        // create clip reference
        clip = AudioSystem.getClip();
        // open audioInputStream to the clip
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
