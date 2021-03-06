package SpaceX05.Aliens;

import javax.swing.*;
import java.awt.*;

public class OffensiveCrab extends Crab {

    private final String crabImg = "/Images/OffensiveCrab.jpg";


    public OffensiveCrab(String src , int PosX, int PosY){
        this.damagePoints = 15;
        this.healthPoints=5;
        this.PosX = PosX;
        this.PosY = PosY;
        this.type ="OffensiveCrab";

        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }



    public OffensiveCrab(int PosX, int PosY){
        this.damagePoints = 15;
        this.healthPoints=5;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(crabImg));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
    public OffensiveCrab() {

    }

    public OffensiveCrab(String img) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(img));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

    public int getDamage(){return this.damagePoints;}
    public int getHealth() {return this.healthPoints;}

}