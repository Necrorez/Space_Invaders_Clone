package SpaceX05.Decorator;
import SpaceX05.Aliens.Crab;

public abstract class Decorator extends Crab {
    protected Crab wrapee;

    public Decorator(Crab crab)
    {
        super(crab.PosX, crab.PosY);
        this.wrapee = crab;
    }

    public int getDamage()
    {
        return this.wrapee.getDamage();
    }

    public int getHealth()
    {
        return this.wrapee.getHealth();
    }

}
