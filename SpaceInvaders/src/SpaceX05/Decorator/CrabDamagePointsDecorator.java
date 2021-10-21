package SpaceX05.Decorator;

import SpaceX05.Alien;
import SpaceX05.Aliens.Crab;

public class CrabDamagePointsDecorator extends Decorator {

    public CrabDamagePointsDecorator(Crab crab) {
        super(crab);
    }

    public int getDamage() {
        return super.getDamage() + 10;
    }
}