package SpaceX05.PowerUps;

import javax.swing.*;
import java.awt.*;

public class ExtraLife extends PowerUp  {

    public ExtraLife(String src , int id, int PosX, int PosY){
        this.id = id;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(12, 12, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
}
