package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.BalancedCrab;
import SpaceX05.Aliens.BalancedSquid;
import SpaceX05.Aliens.BalancedUfo;


public class BalancedAliensFactory extends AbstractFactory {

    private String squidImg = "/Images/Squid.jpg";
    private String crabImg = "/Images/Crab.jpeg";
    private String ufoImg = "/Images/UFO.jpeg";

    @Override
    public Alien spawnCrab(String param, int alienId, int PosX, int PosY)
{
       return new BalancedCrab(crabImg,alienId,PosX,PosY);
}
    @Override
    public Alien spawnSquid(String param, int alienId, int PosX, int PosY)
    {

        return new BalancedSquid(squidImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY)
    {
        return new BalancedUfo(ufoImg,alienId,PosX,PosY);
    }

    @Override
    public Alien getAlienShip(String param){
        return new Alien() {
        };
    }

}
