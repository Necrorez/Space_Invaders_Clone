package SpaceX05.Strategy;

import SpaceX05.Alien;
import SpaceX05.Shot;

import java.util.ArrayList;

public class ShootingContext {
    private  ShootingStrategy strategy;

    public ShootingContext(ShootingStrategy strategy) {
        this.strategy = strategy;
    }
    public int executeShoot(ArrayList<Alien> aliens){
        return strategy.shoot(aliens);
    }
    public int whichType(){
        return strategy.type();
    }
    public Shot rShot(){
        return strategy.returnShot();
    }
}
