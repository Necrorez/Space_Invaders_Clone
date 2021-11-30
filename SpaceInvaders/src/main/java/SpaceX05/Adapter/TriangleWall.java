package SpaceX05.Adapter;

import SpaceX05.WallBuilder.WallBlockTriangle;

import java.util.ArrayList;
import java.util.Iterator;

public class TriangleWall extends BasicWall implements WallAdapter {

    private final ArrayList<WallBlockTriangle> Temporary;

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for TriangleWall object
     * @param temporary
     */
    @SuppressWarnings("SSDoc")
    public TriangleWall(ArrayList<WallBlockTriangle> temporary){
        this.Temporary = temporary;
    }

    @Override
    public ArrayList<BasicWall> getWall() {
        Iterator<WallBlockTriangle> it = this.Temporary.iterator();
        ArrayList<BasicWall> toReturn = new ArrayList<>();
        while (it.hasNext()){
            WallBlockTriangle wall =  it.next();
            toReturn.add(new BasicWall(wall.getX(),wall.getY(),wall.getImage()));
        }
        return toReturn;
    }
}
