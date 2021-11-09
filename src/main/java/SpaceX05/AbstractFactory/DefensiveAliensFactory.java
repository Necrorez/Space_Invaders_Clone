package SpaceX05.AbstractFactory;

import SpaceX05.Alien;
import SpaceX05.Aliens.DefensiveCrab;
import SpaceX05.Aliens.DefensiveSquid;
import SpaceX05.Aliens.DefensiveUfo;

public class DefensiveAliensFactory extends AbstractFactory {

    private String squidImg = "/Images/DefensiveSquid.jpg";
    private String crabImg = "/Images/DefensiveCrab.jpg";
    private String ufoImg = "/Images/DefensiveUFO.jpg";

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