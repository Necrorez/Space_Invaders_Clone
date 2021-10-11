package SpaceX05.Factory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class DefensiveAliensFactory extends AbstractFactory {

    private String squidImg ="/SpaceX05/Images/DefensiveSquid.jpg";
    private String crabImg ="/SpaceX05/Images/DefensiveCrab.jpg";
    private String ufoImg ="/SpaceX05/Images/DefensiveUFO.jpg";

    @Override
    public Alien spawnCrab(String param, int alienId, int PosX, int PosY)
    {
        return new DefensiveCrab(crabImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnSquid(String param, int alienId, int PosX, int PosY)
    {
        return new DefensiveSquid(squidImg,alienId,PosX,PosY);
    }

    @Override
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY)
    {
        return new DefensiveUfo(ufoImg, alienId, PosX, PosY);
    }

    @Override
    public Alien getAlienShip(String param){
        return new Alien() {
        };
    }

}