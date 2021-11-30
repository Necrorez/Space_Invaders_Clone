package SpaceX05.Aliens;

import SpaceX05.Alien;
import SpaceX05.PowerUps.MovementSpeed;
import SpaceX05.PowerUps.PowerUp;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class Squid extends Alien {

    private String squidImg;
    private static final String squidImg1 = "/Images/Squid.jpg";
    private static final String squidImg2 = "/Images/DefensiveSquid.jpg";
    private static final String squidImg3 = "/Images/OffensiveSquid.jpg";

    /**
     * TODO | DOING | DONE
     * DONE
     * Default Constructor
     */
    @SuppressWarnings("SSDoc")
    public Squid() {

    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Abstract method to get the damage
     */
    @SuppressWarnings("SSDoc")
    public abstract int getDamage();
    /**
     * TODO | DOING | DONE
     * DONE
     * Abstract method to get the health
     */
    @SuppressWarnings("SSDoc")
    public abstract int getHealth();

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for Squid alien object
     * @param PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public Squid(int PosX, int PosY) {
        this.PosX = PosX;
        this.PosY = PosY;
        this.squidImg = squidImg1;

    }

    /**
     * TODO | DOING | DONE
     * DOING: add random number generator
     * Method that rolls for powerUp that is dropped from an alien
     * @return powerUp
     */
    @SuppressWarnings("SSDoc")
    public PowerUp rollPower()
    {
        String movementSpeedImg = "/Images/PowerUps/MovementSpeed.png";
        int numb = 2;
        return switch (numb) {

            case 2 -> new MovementSpeed(movementSpeedImg, this.PosX, this.PosY);
            default -> null;
        };

    }
    /**
     * TODO | DOING | DONE
     * DONE
     * sets a new img for the squid aliens
     * @param imageNumber
     */
    @SuppressWarnings("SSDoc")
    public void setImage(int imageNumber) {
        switch (imageNumber) {
            case 1 -> this.squidImg = squidImg1;
            case 2 -> this.squidImg = squidImg2;
            case 3 -> this.squidImg = squidImg3;
        }
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(squidImg)));

        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }

}
