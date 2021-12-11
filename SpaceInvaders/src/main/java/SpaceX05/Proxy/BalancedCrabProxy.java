package SpaceX05.Proxy;

import SpaceX05.Aliens.BalancedCrab;
import SpaceX05.Aliens.Crab;

public class BalancedCrabProxy extends Crab {
    private BalancedCrab bCrab;

    public BalancedCrabProxy(int PosX, int PosY)
    {
        this.PosX = PosX;
        this.PosY = PosY;
    }

    public BalancedCrab setToBCrabWithImage() {
        bCrab = new BalancedCrab(PosX, PosY);
        return bCrab;
    }
}
