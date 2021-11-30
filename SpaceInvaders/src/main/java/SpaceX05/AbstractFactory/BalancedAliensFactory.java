package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.BalancedCrab;
import SpaceX05.Aliens.BalancedSquid;
import SpaceX05.Aliens.BalancedUfo;


public class BalancedAliensFactory extends AbstractFactory {

    @Override
    public Alien spawnCrab(String param, int alienId, int PosX, int PosY)
{
    String crabImg = "/Images/Crab.jpeg";
    return new BalancedCrab(crabImg,alienId,PosX,PosY);
}
    @Override
    public Alien spawnSquid(String param, int alienId, int PosX, int PosY)
    {

        String squidImg = "/Images/Squid.jpg";
        return new BalancedSquid(squidImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY)
    {
        String ufoImg = "/Images/UFO.jpeg";
        return new BalancedUfo(ufoImg,alienId,PosX,PosY);
    }


}
