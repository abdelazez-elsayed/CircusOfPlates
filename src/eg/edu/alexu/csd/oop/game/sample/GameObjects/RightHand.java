package eg.edu.alexu.csd.oop.game.sample.GameObjects;

import java.util.Stack;

public class RightHand {
    private static ImageObject RightHand;
    private static Stack<Plates> RightHandStack= new Stack<>();

    private static RightHand ourInstance = new RightHand();

    public static RightHand getInstance() {
        return ourInstance;
    }

    private RightHand() {
    }

    public static ImageObject getRightHand() {
        return RightHand;
    }

    public static void setRightHand(ImageObject rightHand) {
        RightHand = rightHand;
    }

    public static Stack<Plates> getRightHandStack() {
        return RightHandStack;
    }

    public static void setRightHandStack(Stack<Plates> st){
        RightHandStack = st;
    }


}
