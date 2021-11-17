package SpaceX05.PowerUps;

import javax.swing.*;
import java.awt.*;

public class AttackSpeed extends PowerUp {

    public AttackSpeed(String src , int id, int PosX, int PosY){
        this.id = id;
        this.PosX = PosX;
        this.PosY = PosY;

        ImageIcon ii = new ImageIcon(this.getClass().getResource(src));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(17, 17, Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
}
