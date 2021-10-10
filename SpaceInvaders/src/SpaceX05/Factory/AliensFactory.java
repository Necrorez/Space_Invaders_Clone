package SpaceX05.Factory;

import SpaceX05.Alien;
import SpaceX05.Aliens.Crab;
import SpaceX05.Aliens.Squid;
import SpaceX05.Aliens.Ufo;
public class AliensFactory extends Factory {

    private int alienId = 0;
    private String squidImg ="/SpaceX05/Images/Squid.jpg";
    private String crabImg ="/SpaceX05/Images/Crab.jpeg";
    private String ufoImg ="/SpaceX05/Images/UFO.jpeg";

    @Override
     public Alien factoryMethod(String param, int PosX, int PosY){
        switch (param){
            case "Squid":
                alienId++;
                return new Squid(squidImg,alienId,PosX,PosY);
            case "Crab":
                alienId++;
                return new Crab(crabImg,alienId,PosX,PosY);
            case "Ufo":
                alienId++;
                return new Ufo(ufoImg,alienId,PosX,PosY);
            default:
                return null;
        }
    }
    @Override
    public Alien getAlienShip(String param){
        return new Alien() {
        };
    }

}
