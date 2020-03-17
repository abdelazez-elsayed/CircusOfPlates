package eg.edu.alexu.csd.oop.game.sample.Game;

public class GameData{
    private static int plSpeed;


    public static int getPlSpeed() {
        return plSpeed;
    }

    public static void setPlSpeed(int plSpeed) {
        GameData.plSpeed = plSpeed;
    }

    private static boolean timeOut;

    public static boolean gettimeOut() {
        return timeOut;
    }

    public static void settimeOut(boolean NewScore) {
        timeOut = NewScore;
    }

    private static int score;

    public static int getScore() {
        return score;
    }

    public static void setScore(int NewScore) {
        score = NewScore;
    }

    private static int MAX_TIME = 1 * 60 * 1000;

    public static int getMaxTime() {
        return MAX_TIME;
    }

    private static long startTime;


    public static long getStartTime() {
        return startTime;
    }

    public static void setStartTime(long starTime) {
        startTime = starTime;
    }

    public static String getStatus() {
        return "Please Use Arrows To Move  |   Location = "+"   |   Score="+score+"   |   Time="+Math.max(0,(MAX_TIME -(System.currentTimeMillis()-startTime))/1000);    // update status
    }
}
