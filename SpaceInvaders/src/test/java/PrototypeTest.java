import SpaceX05.Location;
import SpaceX05.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PrototypeTest {

        @Mock
        Player player1;
        Player player2;
        Player player3;
        Player player4;
        @BeforeEach
        void innit(){
            player1 = new Player("/Images/player.png",false,new Location());
        }

        @Test
        public void DeepCopyTest() throws  Exception {

            player2 = player1.copyDeep();
            assertNotNull(player2);
        }

        @Test
        public void ShallowCopyTest() throws  Exception {
            player2 = player1.copyShallow();

            assertNotNull(player2);

        }
        @Test void DeepCopyLocationTest(){
           player2 = player1.copyDeep();

           player2.location.START_Y=100;
           player2.location.START_X=100;

           assertNotEquals(player1.location,player2.location);
        }
        @Test void ShallowCopyLocationTest(){
            player2 = player1.copyShallow();

            player2.location.START_Y=100;
            player2.location.START_X=100;

            assertEquals(player1.location,player2.location);
        }






       /* @Test
        public void Test_Bad_Cloning() {

            Throwable exception = assertThrows(RuntimeException.class, () -> player4 = player3.copyShallow());
            assertEquals("Cannot invoke \"SpaceX05.Player.copyShallow()\" because \"this.player3\" is null", exception.getMessage());

            exception = assertThrows(RuntimeException.class, () -> player4 = player3.copyDeep());
            assertEquals("Cannot invoke \"SpaceX05.Player.copyDeep()\" because \"this.player3\" is null", exception.getMessage());
        }*/
}

