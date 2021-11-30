package SpaceX05.Strategy;


import SpaceX05.Alien;
import SpaceX05.Shot;

import java.util.ArrayList;

public interface ShootingStrategy {
    /**
     * TODO | DOING | DONE
     * DONE
     * Interface method for shooting
     * @param aliens
     */
    @SuppressWarnings("SSDoc")
    int shoot(ArrayList<Alien> aliens);
    /**
     * TODO | DOING | DONE
     * DONE
     * Interface method for type method
     */
    @SuppressWarnings("SSDoc")
    int type();
    /**
     * TODO | DOING | DONE
     * DONE
     * Interface method for getting back the Shot
     */
    @SuppressWarnings("SSDoc")
    Shot returnShot();
}
