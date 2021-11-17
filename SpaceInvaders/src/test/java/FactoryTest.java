import SpaceX05.Factory.PowerUpFactory;
import SpaceX05.PowerUps.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class FactoryTest {

    @Mock
    private static PowerUpFactory factory;
    @BeforeEach
    void innit(){
        factory = new PowerUpFactory();
    }


    @ParameterizedTest
    @ValueSource(strings = { "ExtraLife", "MovementSpeed", "AttackSpeed" })
    public void factoryMethodTest(String type) throws Exception{

        PowerUp powerUp = factory.factoryMethod(type,10,10);

        assertNotNull(powerUp);

    }


    @ParameterizedTest
    @ValueSource(strings = { "ExtraLife", "MovementSpeed", "AttackSpeed" })
    public void getPowerUpMethodTest(String type) {
        assertNotNull(factory.getPowerUp(type));
    }


    @Test
    public void Test_Bad_PowerUp_Creation() {

        Throwable exception = assertThrows(RuntimeException.class, () -> factory.factoryMethod("anyString()",10,10));
        assertEquals("Invalid entry", exception.getMessage());
    }
}