package SpaceX05.Aliens;

import SpaceX05.Alien;

import javax.swing.*;
import java.awt.*;

public class Crab extends Alien {

    private String crabImg;
    private static final String crabImg1 = "/Images/Crab.jpeg";
    private static final String crabImg2 = "/Images/DefensiveCrab.jpg";
    private static final String crabImg3 = "/Images/OffensiveCrab.jpg";

    public Crab(int PosX, int PosY) {
        this.PosX = PosX;
        this.PosY = PosY;
        this.crabImg = crabImg1;

    }
    public Crab() {
    }

    public  int getDamage() {return this.damagePoints;}
    public  int getHealth() {return this.healthPoints;}

    public void setImage(int imageNumber) {
        switch (imageNumber) {
            case 1 -> this.crabImg = crabImg1;
            case 2 -> this.crabImg = crabImg2;
            case 3 -> this.crabImg = crabImg3;
        }
        ImageIcon ii = new ImageIcon(this.getClass().getResource(crabImg));

        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

}
