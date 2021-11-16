import SpaceX05.Strategy.PowerShot;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PowerShotTest {

    @InjectMocks
    private PowerShot underTest;

    @Test
    public void shotTest()
    {
        //assertEquals(1, basic.shoot(aliens));
        assertEquals(0, underTest.getImage());

    }

}