package SpaceX05.Aliens;

import SpaceX05.Alien;
import SpaceX05.PowerUps.PowerUp;

import javax.swing.*;
import java.awt.*;

public class DefensiveSquid extends Squid {

    private final String squidImg = "/Images/DefensiveSquid.jpg";
    public DefensiveSquid(String src,int PosX, int PosY){
        super(PosX, PosY);
        this.damagePoints = 5;
        this.healthPoints=15;
        this.PosX = PosX;
        this.PosY = PosY;
        this.type ="DefensiveSquid";

        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
    public DefensiveSquid(int PosX, int PosY){
        super(PosX, PosY);
        this.id = id;
        this.damagePoints = 5;
        this.healthPoints=15;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(squidImg));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
    public DefensiveSquid() {

    }

    public DefensiveSquid(String img) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(img));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

    @Override
    public PowerUp rollPower() {
        return super.rollPower();
    }
    public int getDamage(){return this.damagePoints;}
    public int getHealth() {return this.healthPoints;}

}
