package SpaceX05.Adapter;

import SpaceX05.WallBuilder.WallBlockSquare;
import SpaceX05.WallBuilder.WallBlockTriangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TriangleWall extends BasicWall implements WallAdapter {

    private final ArrayList<WallBlockTriangle> Temporary;

    public TriangleWall(ArrayList<WallBlockTriangle> temporary){
        this.Temporary = temporary;
    }

    @Override
    public ArrayList<BasicWall> getWall() {
        Iterator it = this.Temporary.iterator();
        ArrayList<BasicWall> toReturn = new ArrayList<>();
        while (it.hasNext()){
            WallBlockTriangle wall = (WallBlockTriangle) it.next();
            toReturn.add(new BasicWall(wall.getX(),wall.getY(),wall.getImage()));
        }
        return toReturn;
    }
}
