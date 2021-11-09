package SpaceX05.Aliens;

import javax.swing.*;
import java.awt.*;

public class OffensiveCrab extends Crab {

    private String crabImg = "/Images/OffensiveCrab.jpg";


    public OffensiveCrab(String src , int id, int PosX, int PosY){
        //super(src, PosX, PosY);

        this.id = id;
        this.damagePoints = 15;
        this.healthPoints=5;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

    public int getDamage(){return this.damagePoints;}
    public int getHealth() {return this.healthPoints;}

}