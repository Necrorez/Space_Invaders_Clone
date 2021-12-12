package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.BalancedCrab;
import SpaceX05.Aliens.BalancedSquid;
import SpaceX05.Aliens.BalancedUfo;


public class BalancedAliensFactory extends AbstractFactory {

    private final String squidImg = "/Images/Squid.jpg";
    private final String crabImg = "/Images/Crab.jpeg";
    private final String ufoImg = "/Images/UFO.jpeg";

    @Override
    public Alien spawnCrab(String param, int PosX, int PosY)
{
       return new BalancedCrab(crabImg,PosX,PosY);
}
    @Override
    public Alien spawnSquid(String param, int PosX, int PosY)
    {

        return new BalancedSquid(squidImg,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int PosX, int PosY)
    {
        return new BalancedUfo(ufoImg,PosX,PosY);
    }


}
