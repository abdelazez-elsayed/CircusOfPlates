package eg.edu.alexu.csd.oop.game.sample.Observer;

import eg.edu.alexu.csd.oop.game.World;
import eg.edu.alexu.csd.oop.game.sample.GameObjects.Plates;
import eg.edu.alexu.csd.oop.game.sample.ShapeFactory.ShapeFactory;
import eg.edu.alexu.csd.oop.game.sample.State.ShelfState;

import java.util.Stack;

public class Change extends Observer {
    private boolean flag = true ;

    public Change(Subject subject , World world , Stack <Plates> HandStack) {
        this.subject = subject ;
        this.world = world ;
        this.HandStack = HandStack ;
        subject.attach(this);
    }

    @Override
    public void update() {
        Stack<Plates> Demo = new Stack<>();
        if(!HandStack.empty() && HandStack.size() > 2) {
            Plates last = HandStack.pop() ;
            Demo.push(last);
            for (int z =1  ; z < 3 ; z++){
                Plates plate =  HandStack.pop();
                Demo.push(plate) ;
                if(! last.getColor().equalsIgnoreCase( plate.getColor() )){
                     flag = false;
                    break;
                }
            }
            if (flag == false){
                for (int z = 0 ; Demo.size() != 0 ; z++){
                    HandStack.push(Demo.pop());
                }
            }else{
                for(int z = 0 ;  Demo.size() != 0  ; z++){
                    Demo.peek().setVisible(false);
                    Demo.peek().setState(new ShelfState());
                    Demo.peek().setGate(0);
                    ShapeFactory.getFactory().getWorld().getControlableObjects().remove(Demo.pop());
                }
                subject.setState(subject.getState()+1);
            }
        }
    }
}