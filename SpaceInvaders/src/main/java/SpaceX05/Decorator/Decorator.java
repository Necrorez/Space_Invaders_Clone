package SpaceX05.Decorator;
import SpaceX05.Aliens.Crab;

public abstract class Decorator extends Crab {
    protected Crab wrapee;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for decorator pattern
     * @param crab
     */
    @SuppressWarnings("SSDoc")
    public Decorator(Crab crab)
    {
        super(crab.PosX, crab.PosY);
        this.wrapee = crab;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Getter for decorator method to get the damage
     * @return the damage amount
     */
    @SuppressWarnings("SSDoc")
    public int getDamage()
    {
        return this.wrapee.getDamage();
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Getter for decorator method to get the health
     * @return the health amount
     */
    @SuppressWarnings("SSDoc")
    public int getHealth()
    {
        return this.wrapee.getHealth();
    }

}
