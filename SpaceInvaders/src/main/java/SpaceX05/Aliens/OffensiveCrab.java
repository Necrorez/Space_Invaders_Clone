package SpaceX05.Aliens;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class OffensiveCrab extends Crab {


    /**
     * TODO | DOING | DONE
     * Constructor for OffensiveCrab alien object
     * @param src, id, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public OffensiveCrab(String src , int id, int PosX, int PosY){
        this.id = id;
        this.damagePoints = 15;
        this.healthPoints=5;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(src)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for OffensiveCrab alien object
     * @param PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public OffensiveCrab(int PosX, int PosY){
        this.damagePoints = 15;
        this.healthPoints=5;
        this.PosX = PosX;
        this.PosY = PosY;

        String crabImg = "/Images/OffensiveCrab.jpg";
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(crabImg)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Default Constructor
     */
    @SuppressWarnings("SSDoc")
    public OffensiveCrab() {

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

}