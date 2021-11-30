package SpaceX05.Aliens;

import SpaceX05.Alien;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Crab extends Alien {

    private String crabImg;
    private static final String crabImg1 = "/Images/Crab.jpeg";
    private static final String crabImg2 = "/Images/DefensiveCrab.jpg";
    private static final String crabImg3 = "/Images/OffensiveCrab.jpg";

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for Crab alien object
     * @param PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public Crab(int PosX, int PosY) {
        this.PosX = PosX;
        this.PosY = PosY;
        this.crabImg = crabImg1;

    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Default Constructor
     */
    @SuppressWarnings("SSDoc")
    public Crab() {
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Getter for damagePoints
     */
    @SuppressWarnings("SSDoc")
    public int getDamage(){return this.damagePoints;}
    /**
     * TODO | DOING | DONE
     * DONE
     * Getter for healthPoints
     */
    @SuppressWarnings("SSDoc")
    public int getHealth() {return this.healthPoints;}

    /**
     * TODO | DOING | DONE
     * DONE
     * sets a new img for the Crab aliens
     * @param imageNumber
     */
    @SuppressWarnings("SSDoc")
    public void setImage(int imageNumber) {
        switch (imageNumber) {
            case 1 -> this.crabImg = crabImg1;
            case 2 -> this.crabImg = crabImg2;
            case 3 -> this.crabImg = crabImg3;
        }
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(crabImg)));

        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }

}
