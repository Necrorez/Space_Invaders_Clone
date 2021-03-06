package SpaceX05.Strategy;

import SpaceX05.Alien;
import SpaceX05.Player;
import SpaceX05.Shot;

import java.util.ArrayList;

public class ShootingContext {
    private final ShootingStrategy strategy;

    public ShootingContext(ShootingStrategy strategy) {
        this.strategy = strategy;
    }
    public int executeShoot(ArrayList<Alien> aliens,ArrayList<Player> players){
        return strategy.shoot(aliens,players);
    }
    public int whichType(){
        return strategy.type();
    }
    public Shot rShot(){
        return strategy.returnShot();
    }
}
