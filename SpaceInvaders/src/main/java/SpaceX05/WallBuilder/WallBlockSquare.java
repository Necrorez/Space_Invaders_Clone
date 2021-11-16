package SpaceX05.WallBuilder;

import SpaceX05.Sprite;

import javax.swing.*;
import java.awt.*;

public class WallBlockSquare extends Sprite {

    public WallBlockSquare(String color){
        String toSet = "";
        switch (color){
            case "White": toSet = "/Images/WallBlock.png"; break;
            case "Blue": toSet= "/Images/WallBlockBlue.png"; break;
            case "Purple": toSet= "/Images/WallBlockPurple.png"; break;
            default: throw new RuntimeException("Invalid entry");
        }

        ImageIcon ii = new ImageIcon(this.getClass().getResource(toSet));
        Image image = ii.getImage();

        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
    public WallBlockSquare(int x, int y, Image img){

        setImage(img);

        setX(x);
        setY(y);
    }
}
