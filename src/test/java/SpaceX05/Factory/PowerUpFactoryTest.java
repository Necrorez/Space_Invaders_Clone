package SpaceX05.Factory;
import SpaceX05.Factory.PowerUpFactory;
import SpaceX05.PowerUps.ExtraLife;
import SpaceX05.PowerUps.PowerUp;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

class PowerUpFactoryTest {

    @Test
    public void firstTest() {
        PowerUpFactory factory = new PowerUpFactory();
        String extraLifeImg = "/Images/PowerUps/ExtraLife.png";
        PowerUp expected = new ExtraLife(extraLifeImg,1,10,10);
        Assert.assertEquals("object not equal",expected,factory.factoryMethod("ExtraLife",10,10));

    }

}