package SpaceX05.Aliens;

import SpaceX05.Alien;
import SpaceX05.PowerUps.MovementSpeed;
import SpaceX05.PowerUps.PowerUp;

import javax.swing.*;
import java.awt.*;

public abstract class Squid extends Alien {

    private String movementSpeedImg = "/Images/PowerUps/MovementSpeed.png";
    private String squidImg;
    private static final String squidImg1 = "/Images/Squid.jpg";
    private static final String squidImg2 = "/Images/DefensiveSquid.jpg";
    private static final String squidImg3 = "/Images/OffensiveSquid.jpg";

    public Squid() {

    }

    public abstract int getDamage();
    public abstract int getHealth();

    private PowerUp powerup;

    public Squid(int PosX, int PosY) {
        this.PosX = PosX;
        this.PosY = PosY;
        this.squidImg = squidImg1;

    }

    public PowerUp rollPower()
    {
        int numb = 2;
        switch(numb){
            case 2:
                powerup = new MovementSpeed(movementSpeedImg, this.PosX, this.PosY);
                return powerup;
            default: return null;
        }

    }
    public void setImage(int imageNumber) {
        switch (imageNumber) {
            case 1 -> this.squidImg = squidImg1;
            case 2 -> this.squidImg = squidImg2;
            case 3 -> this.squidImg = squidImg3;
        }
        ImageIcon ii = new ImageIcon(this.getClass().getResource(squidImg));

        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

}
