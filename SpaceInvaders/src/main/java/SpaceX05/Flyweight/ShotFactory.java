package SpaceX05.Flyweight;

import SpaceX05.Alien;
import SpaceX05.Shot;
import SpaceX05.Strategy.BasicShot;
import SpaceX05.Strategy.PowerShot;

import java.util.HashMap;
import java.util.Map;

public class ShotFactory {
    public static Map<String, Shot> shotTypes = new HashMap<>();

    public static Shot getShot(String type)
    {
        Shot shot = shotTypes.get(type);
        if (shot == null)
        {
            if (type.equals("Basic"))
            {
                shot = new BasicShot("/Images/BasicShot.png");
                shotTypes.put("Basic", shot);
            }
            else if (type.equals("Power")) {
                shot = new PowerShot("/Images/PowerShot.png");
                shotTypes.put("Power", shot);
            }

        }
        return shot;
    }
}
