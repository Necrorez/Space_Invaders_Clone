package SpaceX05.Strategy;


import SpaceX05.Alien;
import SpaceX05.Shot;

import java.util.ArrayList;

public interface ShootingStrategy {
    public int shoot(ArrayList<Alien> aliens);
    public int type();
    public Shot returnShot();
}
