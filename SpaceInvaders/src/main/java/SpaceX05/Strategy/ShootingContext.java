package SpaceX05.Strategy;

import SpaceX05.Alien;
import SpaceX05.Shot;

import java.util.ArrayList;

public record ShootingContext(ShootingStrategy strategy) {
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for Shooting context
     * @param strategy
     */
    @SuppressWarnings("SSDoc")
    public ShootingContext {
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Method that executes the shoot method in strategy pattern
     * @param aliens
     * @return strategy.shoot() method
     */
    @SuppressWarnings("SSDoc")
    public int executeShoot(ArrayList<Alien> aliens) {
        return strategy.shoot(aliens);
    }

    /**
     * TODO | DOING | DONE
     * Method that returns the type of shot used
     * @return type
     */
    @SuppressWarnings("SSDoc")
    public int whichType() {
        return strategy.type();
    }

    /**
     * TODO | DOING | DONE
     * Method that returns the type of shot used
     * @return returnShot()
     */
    @SuppressWarnings("SSDoc")
    public Shot rShot() {
        return strategy.returnShot();
    }
}
