import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlockTriangle;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WallTest {
    @Mock
    private Wall.WallBuilder underTest;

    @Before
    public void beforeMethod(){
        underTest = new Wall.WallBuilder();
    }

    @Test
    public void testWallBuilder() throws Exception{
        underTest.triangle(new WallBlockTriangle("Purple"))
                .placement(new int[][]{
                        {1,0,1,1},
                        {1,0,1,1},
                        {1,1,1,1}})
                .y(250)
                .x(230)
                .build();
        Wall newwall = new Wall(underTest);
        newwall.getWallTriangle();
    }
}