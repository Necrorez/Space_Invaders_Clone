package SpaceX05.Adapter;

import SpaceX05.WallBuilder.WallBlockSquare;
import SpaceX05.WallBuilder.WallBlockTriangle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TriangleWall extends BasicWall implements WallAdapter {

    private ArrayList<WallBlockTriangle> Temporary;

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

    public ArrayList<BasicWall> changeColor(String color){
        String toSet = "";
        switch (color){
            case "White": toSet = "/Images/WallBlockTriangle.png"; break;
            case "Blue": toSet= "/Images/WallBlockBlueTriangle.png"; break;
            case "Purple": toSet= "/Images/WallBlockPurpleTriangle.png"; break;
            default: throw new RuntimeException("Invalid entry");
        }
        Iterator it = this.Temporary.iterator();
        ArrayList<BasicWall> toReturn = new ArrayList<>();
        while (it.hasNext()){
            WallBlockTriangle wall = (WallBlockTriangle) it.next();
            ImageIcon ii = new ImageIcon(this.getClass().getResource(toSet));
            Image image = ii.getImage();
            Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
            ii = new ImageIcon(newimg);
            wall.setImage(ii.getImage());
            toReturn.add(new BasicWall(wall.getX(),wall.getY(),wall.getImage()));
        }
        return toReturn;
    }
}
