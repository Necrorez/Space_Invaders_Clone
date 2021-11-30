package SpaceX05.Decorator;

import SpaceX05.Aliens.Crab;

public class CrabHealthPointsDecorator extends Decorator{

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for CrabHealthPointsDecorator object
     * @param crab
     */
    @SuppressWarnings("SSDoc")
    public CrabHealthPointsDecorator(Crab crab)
    {
        super(crab);
    }


    /**
     * TODO | DOING | DONE
     * DONE
     * adds more health to Crab aliens
     * @return
     */
    @SuppressWarnings("SSDoc")
    public int getHealth()
    {
        return super.getHealth() + 10;
    }


}
