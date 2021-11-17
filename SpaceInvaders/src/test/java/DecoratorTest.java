import SpaceX05.Aliens.Crab;
import SpaceX05.Aliens.OffensiveCrab;
import SpaceX05.Decorator.CrabDamagePointsDecorator;
import SpaceX05.Decorator.CrabHealthPointsDecorator;
import SpaceX05.Decorator.Decorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DecoratorTest {
    @Test
    public void crabDamagePointsDecoratorTest()
    {
        Crab c = new OffensiveCrab(100, 100);
        CrabDamagePointsDecorator dmg = new CrabDamagePointsDecorator(c);
        assertNotEquals(c.damagePoints, dmg.getDamage());
    }
    @Test
    public void crabHealthPointsDecoratorTest()
    {
        Crab c = new OffensiveCrab(100, 100);
        CrabHealthPointsDecorator health = new CrabHealthPointsDecorator(c);
        assertNotEquals(c.healthPoints, health.getHealth());
    }
}
