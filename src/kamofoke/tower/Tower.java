package kamofoke.tower;

import java.util.*;
import kamofoke.aircraft.*;

public abstract class Tower {

    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        int position = 0;
        while (position < observers.size()) {
            observers.get(position).updateConditions();
            position++;
        }
    }
    
}
