package SpaceX05.Decorator;

import SpaceX05.Alien;
import SpaceX05.Aliens.Crab;

public class CrabHealthPointsDecorator extends Decorator{

    public CrabHealthPointsDecorator(Crab crab)
    {
        super(crab);
    }

    public int getHealth()
    {
        return super.getHealth() + 10;
    }




}
