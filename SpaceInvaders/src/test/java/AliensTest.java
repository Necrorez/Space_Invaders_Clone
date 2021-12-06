import SpaceX05.AbstractFactory.AbstractFactory;
import SpaceX05.AbstractFactory.BalancedAliensFactory;
import SpaceX05.Alien;
import SpaceX05.Aliens.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class AliensTest {

    @Test
    public void balancedCrabHealthAndDamageTest()
    {
      Crab bCrab = new BalancedCrab(100, 100);
      int health = 10;
      int damage = 10;
      int crabHealth = bCrab.getHealth();
      int crabDamage = bCrab.getDamage();
      assertEquals(health, crabHealth);
      assertEquals(damage, crabDamage);
    }
    @Test
    public void balancedSquidHealthAndDamageTest()
    {
        Squid bSquid= new BalancedSquid(100, 100);
        int health = 10;
        int damage = 10;
        int squidHealth = bSquid.getHealth();
        int squidDamage = bSquid.getDamage();
        assertEquals(health, squidHealth);
        assertEquals(damage, squidDamage);
    }
    @Test
    public void balancedSquidRollPowerTest()
    {
        Squid bSquid= new BalancedSquid(100, 100);
       assertNotNull(bSquid.rollPower());
    }
    @Test
    public void balancedUfoHealthAndDamageTest()
    {
        Ufo bUfo= new BalancedUfo(100, 100);
        int health = 10;
        int damage = 10;
        int ufoHealth = bUfo.getHealth();
        int ufoDamage = bUfo.getDamage();
        assertEquals(health, ufoHealth);
        assertEquals(damage, ufoDamage);
    }
    @Test
    public void defensiveCrabHealthAndDamageTest()
    {
        Crab dCrab = new DefensiveCrab(100, 100);
        int health = 15;
        int damage = 5;
        int crabHealth = dCrab.getHealth();
        int crabDamage = dCrab.getDamage();
        assertEquals(health, crabHealth);
        assertEquals(damage, crabDamage);
    }
    @Test
    public void defensiveSquidHealthAndDamageTest()
    {
        Squid dSquid = new DefensiveSquid(100, 100);
        int health = 15;
        int damage = 5;
        int squidHealth = dSquid.getHealth();
        int squidDamage = dSquid.getDamage();
        assertEquals(health, squidHealth);
        assertEquals(damage, squidDamage);
    }
    @Test
    public void defensiveSquidRollPowerTest()
    {
        Squid dSquid= new DefensiveSquid(100, 100);
        assertNotNull(dSquid.rollPower());
    }
    @Test
    public void defensiveUfoHealthAndDamageTest()
    {
        Ufo dUfo = new DefensiveUfo(100, 100);
        int health = 15;
        int damage = 5;
        int ufoHealth = dUfo.getHealth();
        int ufoDamage = dUfo.getDamage();
        assertEquals(health, ufoHealth);
        assertEquals(damage, ufoDamage);
    }
    @Test
    public void offensiveCrabHealthAndDamageTest()
    {
        Crab oCrab = new OffensiveCrab(100, 100);
        int health = 5;
        int damage = 15;
        int crabHealth = oCrab.getHealth();
        int crabDamage = oCrab.getDamage();
        assertEquals(health, crabHealth);
        assertEquals(damage, crabDamage);
    }
    @Test
    public void offensiveSquidHealthAndDamageTest()
    {
        Squid oSquid = new OffensiveSquid(100, 100);
        int health = 5;
        int damage = 15;
        int squidHealth = oSquid.getHealth();
        int squidDamage = oSquid.getDamage();
        assertEquals(health, squidHealth);
        assertEquals(damage, squidDamage);
    }
    @Test
    public void offensiveSquidRollPowerTest()
    {
        Squid oSquid= new OffensiveSquid(100, 100);
        assertNotNull(oSquid.rollPower());
    }
    @Test
    public void offensiveUfoHealthAndDamageTest()
    {
        Ufo oUfo = new OffensiveUfo(100, 100);
        int health = 5;
        int damage = 15;
        int ufoHealth = oUfo.getHealth();
        int ufoDamage = oUfo.getDamage();
        assertEquals(health, ufoHealth);
        assertEquals(damage, ufoDamage);
    }
    @Test
    public void crabHealthAndDamageTest()
    {
        Crab crab = new Crab(200, 200);
        assertNotNull(crab.getDamage());
        assertNotNull(crab.getHealth());
    }
    @Test
    public void crabSetImageTest()
    {
        Crab firstCrab = new Crab(200, 200);
        firstCrab.setImage(1);
        Crab secondCrab = new Crab(200, 200);
        Crab thirdCrab = new Crab(200, 200);
        secondCrab.setImage(2);
        thirdCrab.setImage(3);
        assertNotEquals(firstCrab, secondCrab);
        assertNotEquals(secondCrab, thirdCrab);
        assertNotEquals(secondCrab.getImage(), firstCrab.getImage());
    }
    @Test
    public void squidHealthAndDamageTest()
    {
        Squid squid = Mockito.mock(
                Squid.class,
                Mockito.withSettings().useConstructor(10, 10));
        Squid asquid = Mockito.mock(
                Squid.class,
                Mockito.CALLS_REAL_METHODS);
        Squid sq = new BalancedSquid();
        Squid sq2 = new BalancedSquid(10, 10);
        assertNotNull(squid.getDamage());
        assertNotNull(squid.getHealth());
        assertNotNull(squid);
        assertNotNull(sq);
        assertNotNull(sq2);

    }
    @Test
    public void squidSetImageTest()
    {
        Squid squid = new OffensiveSquid();
        squid.setImage(2);
        Squid squid2 = new OffensiveSquid();
        squid2.setImage(3);
        Squid squid3 = new OffensiveSquid();
        squid3.setImage(1);
        assertNotEquals(squid, squid2);
        assertNotEquals(squid.getImage(), squid2.getImage());
        assertNotEquals(squid2.getImage(), squid3.getImage());
    }


}
