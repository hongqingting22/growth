package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    List<Observer> observers = new ArrayList<>();

    public void register(Observer o){
        observers.add(o);
        System.out.println("register:" + o);
    }

    public void remove(Observer o){
        observers.remove(o);
        System.out.println("remove:" + o);
    }

    public void notifyObservers(String state){
        for(Observer o : observers){
            o.update(state);
        }
    }
}
