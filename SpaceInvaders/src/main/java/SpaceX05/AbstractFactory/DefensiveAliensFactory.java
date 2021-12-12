package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class DefensiveAliensFactory extends AbstractFactory {

    private final String squidImg = "/Images/DefensiveSquid.jpg";
    private final String crabImg = "/Images/DefensiveCrab.jpg";
    private final String ufoImg = "/Images/DefensiveUFO.jpg";

    @Override
    public Alien spawnCrab(String param, int PosX, int PosY)
    {
        return new DefensiveCrab(crabImg,PosX,PosY);
    }

    @Override
    public Alien spawnSquid(String param, int PosX, int PosY)
    {
        return new DefensiveSquid(squidImg,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int PosX, int PosY)
    {
        return new DefensiveUfo(ufoImg, PosX, PosY);
    }


}