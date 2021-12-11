import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlockSquare;
import SpaceX05.WallBuilder.WallBlockTriangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WallTest {

    @Mock
    private  Wall.WallBuilder underTest;
    private ArrayList<WallBlockTriangle> wallBlockTriangle;
    private ArrayList<WallBlockSquare> wallBlockSquare;
    @BeforeEach
    void innit(){
        underTest = new Wall.WallBuilder();
        wallBlockTriangle = new ArrayList<>();
        wallBlockSquare  = new ArrayList<>();

    }

    @ParameterizedTest
    @ValueSource(strings = { "Blue", "Purple", "White" })
    public void Test_Triangle_Wall_Creation(String color) throws Exception{

        underTest.triangle(new WallBlockTriangle(color))
                .placement(new int[][]{
                        {1,0,1,1},
                        {1,0,1,1},
                        {1,1,1,1}})
                .y(250)
                .x(230)
                .build();
        wallBlockTriangle = new Wall(underTest).getWallTriangle();
        assertNotNull(wallBlockTriangle);
    }
    @ParameterizedTest
    @ValueSource(strings = { "Blue", "Purple", "White" })
    public void Test_Square_Wall_Creation(String color) throws Exception{

        underTest.square(new WallBlockSquare(color))
                .placement(new int[][]{
                        {1,0,1,1},
                        {1,0,1,1},
                        {1,1,1,1}})
                .y(250)
                .x(230)
                .build();
        wallBlockSquare = new Wall(underTest).getWallSquare();
        assertNotNull(wallBlockSquare);
    }

    @Test
    public void Test_Bad_Wall_Creation() {
        Throwable exception = assertThrows(RuntimeException.class, () -> underTest.square(new WallBlockSquare("anyString()")));
        assertEquals("Invalid entry", exception.getMessage());

        exception = assertThrows(RuntimeException.class, () -> underTest.triangle(new WallBlockTriangle("anyString()")));
        assertEquals("Invalid entry", exception.getMessage());
    }
}