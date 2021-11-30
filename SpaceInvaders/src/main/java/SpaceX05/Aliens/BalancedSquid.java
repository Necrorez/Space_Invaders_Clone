package SpaceX05.Aliens;

import SpaceX05.PowerUps.PowerUp;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BalancedSquid extends Squid {


    /**
     * TODO | DOING | DONE
     * Constructor for BalancedSquid alien object
     * @param src, id, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public BalancedSquid(String src, int id, int PosX, int PosY){
      super(PosX, PosY);
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
     * Constructor for BalancedSquid alien object
     * @param PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public BalancedSquid(int PosX, int PosY){
        super(PosX, PosY);
        this.damagePoints = 10;
        this.healthPoints=10;
        this.PosX = PosX;
        this.PosY = PosY;

        String squidImg = "/Images/Squid.jpg";
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(squidImg)));
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
    public BalancedSquid() {
        super();
    }

    @Override
    public PowerUp rollPower() {
        return super.rollPower();
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
