import SpaceX05.Adapter.SquareWall;
import SpaceX05.Adapter.TriangleWall;
import SpaceX05.Adapter.WallAdapter;
import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlockSquare;
import SpaceX05.WallBuilder.WallBlockTriangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallAdapterTest {


    @Test
    void getWall() {
        Wall wall = new Wall.WallBuilder()
                .triangle(new WallBlockTriangle("Purple"))
                .square(new WallBlockSquare("Purple"))
                .placement(new int[][]{
                        {1,0,1,1},
                        {1,0,1,1},
                        {1,1,1,1}})
                .y(250)
                .x(230)
                .build();
        WallAdapter target = new TriangleWall(wall.getWallTriangle());

        assertNotNull(target);
        assertNotNull(target.getWall());
        target = new SquareWall(wall.getWallSquare());
        assertNotNull(target);
        assertNotNull(target.getWall());


    }
}