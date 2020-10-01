package Weather;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChange(){
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}
