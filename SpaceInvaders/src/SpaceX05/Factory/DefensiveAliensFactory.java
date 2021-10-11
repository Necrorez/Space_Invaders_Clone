package SpaceX05.Factory;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

public class DefensiveAliensFactory extends AbstractFactory {

    //private int alienId = 0;
    private String squidImg ="/SpaceX05/Images/DefensiveSquid.jpg";
    private String crabImg ="/SpaceX05/Images/DefensiveCrab.jpg";
    private String ufoImg ="/SpaceX05/Images/DefensiveUFO.jpg";

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
        return new DefensiveCrab(crabImg,alienId,PosX,PosY);
    }
    @Override
    public Alien spawnSquid(String param, int alienId, int PosX, int PosY)
    {
        return new DefensiveSquid(squidImg,alienId,PosX,PosY);
    }
    @Override
    public Alien spawnUfo(String param, int alienId, int PosX, int PosY) {
        return new DefensiveUfo(ufoImg, alienId, PosX, PosY);
    }
    @Override
    public Alien getAlienShip(String param){
        return new Alien() {
        };
    }

}