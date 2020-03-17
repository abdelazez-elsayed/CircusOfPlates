package eg.edu.alexu.csd.oop.game.sample;

public class GUIData {
    private static Boolean launchedBefore = false;

    public static Boolean getLaunchedBefore() {
        return launchedBefore;
    }

    public static void setLaunchedBefore(Boolean launchedBefore) {
        GUIData.launchedBefore = launchedBefore;
    }
}
