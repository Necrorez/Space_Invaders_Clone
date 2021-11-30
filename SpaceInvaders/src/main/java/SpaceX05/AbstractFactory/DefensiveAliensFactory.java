package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class DefensiveAliensFactory extends AbstractFactory {

    @Override
    public Alien spawnCrab(String param, int alienId, int PosX, int PosY)
    {
        String crabImg = "/Images/DefensiveCrab.jpg";
        return new DefensiveCrab(crabImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnSquid(String param, int alienId, int PosX, int PosY)
    {
        String squidImg = "/Images/DefensiveSquid.jpg";
        return new DefensiveSquid(squidImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY)
    {
        String ufoImg = "/Images/DefensiveUFO.jpg";
        return new DefensiveUfo(ufoImg, alienId, PosX, PosY);
    }


}