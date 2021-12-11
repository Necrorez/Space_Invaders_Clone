package SpaceX05.Adapter;

import SpaceX05.Sprite;
import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlockSquare;

import java.util.ArrayList;
import java.util.Iterator;

public class SquareWall extends BasicWall implements WallAdapter{

    private final ArrayList<WallBlockSquare> Temporary;

    public SquareWall(ArrayList<WallBlockSquare> temporary){
        this.Temporary = temporary;
    }

    @Override
    public ArrayList<BasicWall> getWall() {
        Iterator it = this.Temporary.iterator();
        ArrayList<BasicWall> toReturn = new ArrayList<>();
        while (it.hasNext()){
            WallBlockSquare wall = (WallBlockSquare) it.next();
            toReturn.add(new BasicWall(wall.getX(),wall.getY(),wall.getImage()));
        }
        return toReturn;
    }
}
