package eg.edu.alexu.csd.oop.game.sample.Memento;

import java.util.*;

public class Caretaker {
    private static int x =0;
    private static Queue<Memento> undo = new LinkedList<>();
    private static Stack<Memento> redo = new Stack<>();

    public void addMemento (Memento m){
        undo.add(m);
    }

    public Memento getMemento(boolean isUndo){
        if(isUndo) {
            Memento mem = undo.poll();
            redo.push(mem);
            return mem;
        }
        Memento mem = redo.pop();
        undo.add(mem);
        return mem;
    }
}
