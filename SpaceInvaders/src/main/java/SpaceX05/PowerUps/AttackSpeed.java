package SpaceX05.PowerUps;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AttackSpeed extends PowerUp {


    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for AttackSpeed PowerUp
     * @param src , id, PosX, PosY
     */
    @SuppressWarnings("SSDoc")public AttackSpeed(String src , int id, int PosX, int PosY){
        this.id = id;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(src)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }
}
