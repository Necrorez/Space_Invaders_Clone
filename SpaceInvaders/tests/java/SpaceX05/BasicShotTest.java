package SpaceX05;

import SpaceX05.Aliens.DefensiveUfo;
import SpaceX05.Factory.DefensiveAliensFactory;
import SpaceX05.Strategy.BasicShot;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BasicShotTest {
    BasicShot basic = new BasicShot();
    @Test
    public void shotTest()
    {
        ArrayList<Alien> aliens = new ArrayList<Alien>();
        ArrayList<Alien> emptyAliens = new ArrayList<Alien>();
        DefensiveAliensFactory defensive = new DefensiveAliensFactory();
        Alien ufo = defensive.spawnUfo("Ufo", 0, 1, 3);
        aliens.add(ufo);
        //assertEquals(1, basic.shoot(aliens));
        assertEquals(0, basic.shoot(emptyAliens));

    }

}