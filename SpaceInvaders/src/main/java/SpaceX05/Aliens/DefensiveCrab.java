package SpaceX05.Aliens;

import javax.swing.*;
import java.awt.*;

public class DefensiveCrab extends Crab {

    private String crabImg = "/Images/DefensiveCrab.jpg";

    public DefensiveCrab(String src , int id, int PosX, int PosY){
        //super(src, PosX, PosY);

        this.id = id;
        this.damagePoints = 5;
        this.healthPoints=15;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

    public int getDamage(){return this.damagePoints;}
    public int getHealth() {return this.healthPoints;}
}