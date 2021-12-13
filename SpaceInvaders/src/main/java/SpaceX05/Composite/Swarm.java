package SpaceX05.Composite;

import SpaceX05.Alien;

import java.util.ArrayList;
import java.util.List;

public class Swarm implements GroupedAlien{

    List<GroupedAlien> swarm;
    String swarmingWay;

    public Swarm(String swarmingWay){
        swarm = new ArrayList<>();
        this.swarmingWay = swarmingWay;
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

    public String getSwarmingWay() {
        return swarmingWay;
    }

    @Override
    public boolean isAlien(){
        return false;
    }
}
