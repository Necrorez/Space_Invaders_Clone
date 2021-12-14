package SpaceX05.Memento;

import java.util.ArrayList;
import java.util.List;

public class LifeTracker {

    List<INarrowMemento> extraLives;

    public LifeTracker(){
        extraLives = new ArrayList<>();
    }

    public void addLife(INarrowMemento Life){
        extraLives.add(Life);
    }

    public INarrowMemento getLife(String player){
        INarrowMemento memo = null;

        for (INarrowMemento life:extraLives) {
            ExtraLife extraLife = (ExtraLife) life;
            if (extraLife.player == player){
                memo = life;
                extraLives.remove(life);
                break;
            }
        }

        return memo;
    }
}
