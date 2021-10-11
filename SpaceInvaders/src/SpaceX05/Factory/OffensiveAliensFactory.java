package SpaceX05.Factory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class OffensiveAliensFactory extends AbstractFactory {

    //private int alienId = 0;
    private String squidImg ="/SpaceX05/Images/OffensiveSquid.jpg";
    private String crabImg ="/SpaceX05/Images/OffensiveCrab.jpg";
    private String ufoImg ="/SpaceX05/Images/OffensiveUFO.jpg";

    //    @Override
//     public Alien factoryMethod(String param, int PosX, int PosY){
//        switch (param){
//            case "Squid":
//                alienId++;
//                return new BalancedSquid(squidImg,alienId,PosX,PosY);
//            case "Crab":
//                alienId++;
//                return new BalancedCrab(crabImg,alienId,PosX,PosY);
//            case "Ufo":
//                alienId++;
//                return new BalancedUfo(ufoImg,alienId,PosX,PosY);
//            default:
//                return null;
//        }
//    }
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
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY) {
        return new OffensiveUfo(ufoImg, alienId, PosX, PosY);
    }
    @Override
    public Alien getAlienShip(String param){
        return new Alien() {
        };
    }

}