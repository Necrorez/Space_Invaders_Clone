package SpaceX05.Strategy;


import SpaceX05.Alien;
import SpaceX05.Player;
import SpaceX05.Shot;

import java.util.ArrayList;

public interface ShootingStrategy {
    int shoot(ArrayList<Alien> aliens,ArrayList<Player> players);
    int type();
    Shot returnShot();
}
