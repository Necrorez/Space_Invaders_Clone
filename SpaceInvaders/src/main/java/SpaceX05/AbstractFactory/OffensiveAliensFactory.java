package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class OffensiveAliensFactory extends AbstractFactory {

    @Override
    public Alien spawnCrab(String param, int alienId, int PosX, int PosY)
    {
        String crabImg = "/Images/OffensiveCrab.jpg";
        return new OffensiveCrab(crabImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnSquid(String param, int alienId, int PosX, int PosY)
    {
        String squidImg = "/Images/OffensiveSquid.jpg";
        return new OffensiveSquid(squidImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY)
    {
        String ufoImg = "/Images/OffensiveUFO.jpg";
        return new OffensiveUfo(ufoImg, alienId, PosX, PosY);
    }

}