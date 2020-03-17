package eg.edu.alexu.csd.oop.game.sample.GameObjects;

import java.util.Stack;

public class LeftHand {
    private static ImageObject LeftHand;
    private static Stack<Plates> LeftHandStack = new Stack<>();

    private static LeftHand ourInstance = new LeftHand();

    public static LeftHand getInstance() {
        return ourInstance;
    }

    private LeftHand() {
    }

    public static ImageObject getLeftHand() {
        return LeftHand;
    }

    public static void setLeftHand(ImageObject rightHand) {
        LeftHand = rightHand;
    }

    public static Stack<Plates> getLeftHandStack(){
        return LeftHandStack;
    }

    public static void setLeftHandStack(Stack<Plates> st){
        LeftHandStack = st;
    }
}
