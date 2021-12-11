package SpaceX05.Proxy;

import SpaceX05.Aliens.Crab;
import SpaceX05.Aliens.OffensiveCrab;

public class OffensiveCrabProxy extends Crab {
    private OffensiveCrab oCrab;

    public OffensiveCrabProxy(int PosX, int PosY)
    {
        this.PosX = PosX;
        this.PosY = PosY;
    }

    public OffensiveCrab setToBCrabWithImage() {
        oCrab = new OffensiveCrab(PosX, PosY);
        return oCrab;
    }
}