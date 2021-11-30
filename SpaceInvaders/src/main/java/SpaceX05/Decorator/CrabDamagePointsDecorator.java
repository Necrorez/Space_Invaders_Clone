package SpaceX05.Decorator;

import SpaceX05.Aliens.Crab;

public class CrabDamagePointsDecorator extends Decorator {

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for CrabDamagePointsDecorator object
     * @param crab
     */
    @SuppressWarnings("SSDoc")
    public CrabDamagePointsDecorator(Crab crab) {
        super(crab);
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * adds more damage to the crab alien
     * @return new damage amount
     */
    @SuppressWarnings("SSDoc")
    public int getDamage() {
        return super.getDamage() + 10;
    }
}