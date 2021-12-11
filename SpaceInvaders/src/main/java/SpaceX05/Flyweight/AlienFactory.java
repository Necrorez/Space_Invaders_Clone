package SpaceX05.Flyweight;

import SpaceX05.Alien;
import SpaceX05.Aliens.*;

import java.util.HashMap;
import java.util.Map;

public class AlienFactory {

    static Map<String, Alien> alienTypes = new HashMap<>();

    public static Alien getAlien(String type)
    {
        Alien res = alienTypes.get(type);
        if (res == null) {
            if (type.equals("bCrab"))
            {
                res = new BalancedCrab("/Images/Crab.jpeg");
                alienTypes.put("bCrab", res);
            }
            else if (type.equals("dCrab"))
            {
                res = new DefensiveCrab("/Images/DefensiveCrab.jpg");
                alienTypes.put("dCrab", res);
            }
            else if (type.equals("oCrab"))
            {
                res = new OffensiveCrab("/Images/OffensiveCrab.jpg");
                alienTypes.put("oCrab", res);
            }
            else if (type.equals("bSquid"))
            {
                res = new BalancedSquid("/Images/Squid.jpg");
                alienTypes.put("bSquid", res);
            }
            else if (type.equals("dCrab"))
            {
                res = new DefensiveSquid("/Images/DefensiveSquid.jpg");
                alienTypes.put("dSquid", res);
            }
            else if (type.equals("oSquid"))
            {
                res = new OffensiveSquid("/Images/OffensiveSquid.jpg");
                alienTypes.put("oSquid", res);
            }
            else if (type.equals("bUfo"))
            {
                res = new BalancedUfo("/Images/UFO.jpeg");
                alienTypes.put("bUfo", res);
            }
            else if (type.equals("dUfo"))
            {
                res = new DefensiveUfo("/Images/DefensiveUFO.jpg");
                alienTypes.put("dUfo", res);
            }
            else if (type.equals("oUfo"))
            {
                res = new OffensiveUfo("/Images/OffensiveUFO.jpg");
                alienTypes.put("oUfo", res);
            }
        }
        return res;
    }
}
