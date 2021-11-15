package SpaceX05.WallBuilder;

import SpaceX05.Sprite;

import javax.swing.*;
import java.awt.*;

public class WallBlockTriangle extends Sprite   {
    public WallBlockTriangle(String color){
        String toSet = "";
        switch (color){
            case "White": toSet = "/Images/WallBlockTriangle.png"; break;
            case "Blue": toSet= "/Images/WallBlockBlueTriangle.png"; break;
            case "Purple": toSet= "/Images/WallBlockPurpleTriangle.png"; break;
            default: throw new RuntimeException("Invalid entry");
        }
        ImageIcon ii = new ImageIcon(this.getClass().getResource(toSet));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
    public WallBlockTriangle(int x, int y,Image img){

        setImage(img);

        setX(x);
        setY(y);
    }
}
