import SpaceX05.AbstractFactory.BalancedAliensFactory;
import SpaceX05.Alien;
import SpaceX05.Strategy.ShootingContext;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ShootingContextTest {

    @InjectMocks
    private ShootingContext underTest;

    @Nested
    @DisplayName("Check for PowerShot test")
    class PowerShot{

        @BeforeEach
        void setUp() {
            underTest = mock(ShootingContext.class);
        }

        @Test
        void executeShoot() {
            var aliens = new ArrayList();
            var players = new ArrayList();
            BalancedAliensFactory balanced = new BalancedAliensFactory();
            for (int i = 0; i<3; i++){
                Alien alien = balanced.spawnSquid("Squid", i,100 + 20 * i,100);
                aliens.add(alien);
            }

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.PowerShot(3,3));
            var shoot = toTest.executeShoot(aliens,players);

            assertEquals(0,shoot);
        }

        @Test
        void executeShootWithKill() {
            var aliens = new ArrayList();
            var players = new ArrayList();
            BalancedAliensFactory balanced = new BalancedAliensFactory();
            for (int i = 0; i<3; i++){
                Alien alien = balanced.spawnSquid("Squid", i,100 + 20 * i,100);
                aliens.add(alien);
            }

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.PowerShot(100,110));
            var shoot = toTest.executeShoot(aliens,players);

            assertEquals(1,shoot);
        }

        @Test
        void whichType() {
            when(underTest.whichType()).thenReturn(2);

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.PowerShot());
            int toTestInt = toTest.whichType();

            assertEquals(underTest.whichType(),toTestInt);
        }

        @Test
        void rShot() {
            when(underTest.rShot()).thenReturn(new SpaceX05.Strategy.PowerShot(3,3));

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.PowerShot(3,3));
            SpaceX05.Strategy.PowerShot toTestShot = (SpaceX05.Strategy.PowerShot) toTest.rShot();
            assertEquals(underTest.rShot().getX(),toTestShot.getX());
            assertEquals(underTest.rShot().getY(),toTestShot.getY());
        }


    }

    @Nested
    @DisplayName("Check for Basic shot test")
    class BasicShot{

        @BeforeEach
        void setUp() {
            underTest = mock(ShootingContext.class);
        }

        @Test
        void executeShoot() {
            var aliens = new ArrayList();
            var players = new ArrayList();
            BalancedAliensFactory balanced = new BalancedAliensFactory();
            for (int i = 0; i<3; i++){
                Alien alien = balanced.spawnSquid("Squid", i,100 + 20 * i,100);
                aliens.add(alien);
            }

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.BasicShot(3,3));
            var shoot = toTest.executeShoot(aliens,players);

            assertEquals(0,shoot);
        }

        @Test
        void executeShootWithKill() {
            var aliens = new ArrayList();
            var players = new ArrayList();
            BalancedAliensFactory balanced = new BalancedAliensFactory();
            for (int i = 0; i<3; i++){
                Alien alien = balanced.spawnSquid("Squid", i,100 + 20 * i,100);
                aliens.add(alien);
            }

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.BasicShot(100,110));
            var shoot = toTest.executeShoot(aliens,players);

            assertEquals(1,shoot);
        }

        @Test
        void whichType() {
            when(underTest.whichType()).thenReturn(1);

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.BasicShot());
            int toTestInt = toTest.whichType();

            assertEquals(underTest.whichType(),toTestInt);
        }

        @Test
        void rShot() {
            when(underTest.rShot()).thenReturn(new SpaceX05.Strategy.BasicShot(3,3));

            ShootingContext toTest = new ShootingContext(new SpaceX05.Strategy.BasicShot(3,3));
            SpaceX05.Strategy.BasicShot toTestShot = (SpaceX05.Strategy.BasicShot) toTest.rShot();

            assertEquals(underTest.rShot().getX(),toTestShot.getX());
            assertEquals(underTest.rShot().getY(),toTestShot.getY());
        }


    }


}