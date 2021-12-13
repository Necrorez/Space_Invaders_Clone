package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class OffensiveAliensFactory extends AbstractFactory {

    private final String squidImg = "/Images/OffensiveSquid.jpg";
    private final String crabImg = "/Images/OffensiveCrab.jpg";
    private final String ufoImg = "/Images/OffensiveUFO.jpg";

    @Override
    public Alien spawnCrab(String param, int PosX, int PosY)
    {
        return new OffensiveCrab(crabImg,PosX,PosY);
    }

    @Override
    public Alien spawnSquid(String param, int PosX, int PosY)
    {
        return new OffensiveSquid(squidImg,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int PosX, int PosY)
    {
        return new OffensiveUfo(ufoImg, PosX, PosY);
    }
}