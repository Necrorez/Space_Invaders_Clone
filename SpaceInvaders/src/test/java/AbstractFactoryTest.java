import SpaceX05.AbstractFactory.AbstractFactory;
import SpaceX05.AbstractFactory.BalancedAliensFactory;
import SpaceX05.AbstractFactory.DefensiveAliensFactory;
import SpaceX05.AbstractFactory.OffensiveAliensFactory;
import SpaceX05.Alien;
import SpaceX05.Aliens.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractFactoryTest {
@Test
    public void balancedFactoryTest()
    {
        BalancedCrab bCrab = new BalancedCrab();
        BalancedSquid bSquid = new BalancedSquid();
        BalancedUfo bUfo = new BalancedUfo();

        var alienList = new ArrayList<>();

        AbstractFactory balanced = new BalancedAliensFactory();
        Alien first = balanced.spawnCrab("Crab", 1, 100, 100);
        Alien second = balanced.spawnSquid("Squid", 2, 100, 100);
        Alien third = balanced.spawnUfo("Ufo", 3, 100, 100);
        alienList.add(first);
        alienList.add(second);
        alienList.add(third);

        assertEquals(bCrab.getClass(), alienList.get(0).getClass());
        assertEquals(bSquid.getClass(), alienList.get(1).getClass());
        assertEquals(bUfo.getClass(), alienList.get(2).getClass());
        assertNotEquals(bSquid.getClass(), alienList.get(0).getClass());
    }

    @Test
    public void defensiveFactoryTest()
    {
        DefensiveCrab dCrab = new DefensiveCrab();
        DefensiveSquid dSquid = new DefensiveSquid();
        DefensiveUfo dUfo = new DefensiveUfo();

        var alienList = new ArrayList<>();

        AbstractFactory defensive = new DefensiveAliensFactory();
        Alien first = defensive.spawnCrab("Crab", 1, 100, 100);
        Alien second = defensive.spawnSquid("Squid", 2, 100, 100);
        Alien third = defensive.spawnUfo("Ufo", 3, 100, 100);
        alienList.add(first);
        alienList.add(second);
        alienList.add(third);

        assertEquals(dCrab.getClass(), alienList.get(0).getClass());
        assertEquals(dSquid.getClass(), alienList.get(1).getClass());
        assertEquals(dUfo.getClass(), alienList.get(2).getClass());
        assertNotEquals(dSquid.getClass(), alienList.get(0).getClass());
    }

    @Test
    public void offensiveFactoryTest()
    {
        OffensiveCrab oCrab = new OffensiveCrab();
        OffensiveSquid oSquid = new OffensiveSquid();
        OffensiveUfo oUfo = new OffensiveUfo();

        var alienList = new ArrayList<>();

        AbstractFactory offensive = new OffensiveAliensFactory();
        Alien first = offensive.spawnCrab("Crab", 1, 100, 100);
        Alien second = offensive.spawnSquid("Squid", 2, 100, 100);
        Alien third = offensive.spawnUfo("Ufo", 3, 100, 100);
        alienList.add(first);
        alienList.add(second);
        alienList.add(third);

        assertEquals(oCrab.getClass(), alienList.get(0).getClass());
        assertEquals(oSquid.getClass(), alienList.get(1).getClass());
        assertEquals(oUfo.getClass(), alienList.get(2).getClass());
        assertNotEquals(oSquid.getClass(), alienList.get(0).getClass());
    }

}
