package SpaceX05.Composite;

import SpaceX05.Alien;

import java.util.ArrayList;
import java.util.List;

public class Swarm implements GroupedAlien{

    List<GroupedAlien> swarm;

    public Swarm(){
        swarm = new ArrayList<>();
    }

    public void add(GroupedAlien alien){
        swarm.add(alien);
    }

    public void remove(Alien alien){
        swarm.remove(alien);
    }

    public List<GroupedAlien> getSwarm(){
        return swarm;
    }

    @Override
    public boolean isAlien(){
        return false;
    }
}
