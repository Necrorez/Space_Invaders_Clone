package SpaceX05.Proxy;

import SpaceX05.Aliens.Crab;
import SpaceX05.Aliens.DefensiveCrab;

public class DefensiveCrabProxy extends Crab {
    private DefensiveCrab dCrab;

    public DefensiveCrabProxy(int PosX, int PosY)
    {
        this.PosX = PosX;
        this.PosY = PosY;
    }

    public DefensiveCrab setToBCrabWithImage() {
        dCrab = new DefensiveCrab(PosX, PosY);
        return dCrab;
    }
}
