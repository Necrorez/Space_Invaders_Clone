package SpaceX05.PowerUps;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ExtraLife extends PowerUp  {

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for ExtraLife PowerUp
     * @param src , id, PosX, PosY
     */
    @SuppressWarnings("SSDoc")
    public ExtraLife(String src , int id, int PosX, int PosY) {
        this.id = id;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(src)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
    }
}
