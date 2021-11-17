package SpaceX05.Aliens;

import SpaceX05.Alien;

import javax.swing.*;
import java.awt.*;

public class OffensiveUfo extends Ufo {
    private String ufoImg = "/Images/OffensiveUFO.jpg";


    public OffensiveUfo(String src, int id, int PosX, int PosY){
        this.id = id;
        this.damagePoints = 15;
        this.healthPoints=5;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

    public OffensiveUfo(int PosX, int PosY){
        this.damagePoints = 15;
        this.healthPoints=5;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(ufoImg));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

    public OffensiveUfo() {

    }

    public int getDamage(){return this.damagePoints;}
    public int getHealth() {return this.healthPoints;}

}