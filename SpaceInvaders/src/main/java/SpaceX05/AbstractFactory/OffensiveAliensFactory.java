package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class OffensiveAliensFactory extends AbstractFactory {

    private String squidImg = "/Images/OffensiveSquid.jpg";
    private String crabImg = "/Images/OffensiveCrab.jpg";
    private String ufoImg = "/Images/OffensiveUFO.jpg";

    @Override
    public Alien spawnCrab(String param, int alienId, int PosX, int PosY)
    {
        return new OffensiveCrab(crabImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnSquid(String param, int alienId, int PosX, int PosY)
    {
        return new OffensiveSquid(squidImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY)
    {
        return new OffensiveUfo(ufoImg, alienId, PosX, PosY);
    }

}