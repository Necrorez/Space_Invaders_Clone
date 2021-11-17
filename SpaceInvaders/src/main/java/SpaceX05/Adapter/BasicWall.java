package SpaceX05.Adapter;

import SpaceX05.Sprite;
import SpaceX05.WallBuilder.Wall;
import SpaceX05.WallBuilder.WallBlockSquare;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BasicWall extends Sprite{
    public BasicWall(int x, int y, Image img){
        setImage(img);
        setX(x);
        setY(y);
    }
    public BasicWall(){
    }
}
