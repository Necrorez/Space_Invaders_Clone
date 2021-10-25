package SpaceX05.WallBuilder;

import SpaceX05.Sprite;

import javax.swing.*;
import java.awt.*;

public class WallBlock extends Sprite {

    public WallBlock(int x, int y,String imageSource){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(imageSource));
        Image image = ii.getImage();

        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
        setX(x);
        setY(y);
    }
}
