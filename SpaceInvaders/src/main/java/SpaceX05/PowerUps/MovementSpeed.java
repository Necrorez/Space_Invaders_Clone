package SpaceX05.PowerUps;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MovementSpeed extends PowerUp  {
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for MovementSpeed Power-up
     * @param src , id, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public MovementSpeed(String src , int id, int PosX, int PosY) {
        this.id = id;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(src)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for MovementSpeed Power-up
     * @param src , id, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public MovementSpeed(String src , int PosX, int PosY){
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(src)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }
}
