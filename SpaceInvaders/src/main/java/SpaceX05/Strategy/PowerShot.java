package SpaceX05.Strategy;

import SpaceX05.Alien;
import SpaceX05.Commons;
import SpaceX05.Shot;
import SpaceX05.Template.PowerShotCollision;
import SpaceX05.Template.Collision;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PowerShot  extends Shot implements ShootingStrategy, Commons {

    /**
     * TODO | DOING | DONE
     * DONE
     * default Constructor
     */
    @SuppressWarnings("SSDoc")
    public PowerShot() {
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor
     * @param x, y
     */
    @SuppressWarnings("SSDoc")
    public PowerShot(int x, int y){
        String shot = "/Images/PowerShot.png";
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(shot)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(10, 10,  Image.SCALE_SMOOTH);
        ii = new ImageIcon(newImage);
        setImage(ii.getImage());
        int h_SPACE = 6;
        setX(x + h_SPACE - 5);
        int v_SPACE = 1;
        setY(y - v_SPACE);
    }
    @Override
    public int shoot(ArrayList<Alien> aliens) {
        int kills = 0;
        for (Alien alien : aliens) {
            Collision collision = new PowerShotCollision();
            collision.checkHit(alien, this);
            if (!this.isVisible() && !alien.isVisible())
                kills++;

        }
        int y = getY();
        y -=4;
        if (y<0){
            this.die();
        }else{
            setY(y);
        }
        return kills;
    }

    @Override
    public int type() {
        return 2;
    }

    @Override
    public Shot returnShot(){
        return this;
    }

}
