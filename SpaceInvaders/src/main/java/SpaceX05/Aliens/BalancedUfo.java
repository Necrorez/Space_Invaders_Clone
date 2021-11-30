package SpaceX05.Aliens;


import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BalancedUfo extends Ufo {

    /**
     * TODO | DOING | DONE
     * Constructor for BalancedUfo alien object
     * @param src, id, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public BalancedUfo(String src, int id, int PosX, int PosY){
        this.id = id;
        this.damagePoints = 10;
        this.healthPoints=10;
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
     * Constructor for BalancedUfo alien object
     * @param PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public BalancedUfo(int PosX, int PosY){
        this.damagePoints = 10;
        this.healthPoints=10;
        this.PosX = PosX;
        this.PosY = PosY;

        String ufoImg = "/Images/UFO.jpeg";
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ufoImg));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Default Constructor
     */
    @SuppressWarnings("SSDoc")
    public BalancedUfo() {

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