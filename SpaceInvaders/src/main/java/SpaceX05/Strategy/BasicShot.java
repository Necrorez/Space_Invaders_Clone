package SpaceX05.Strategy;

import SpaceX05.Alien;
import SpaceX05.Commons;
import SpaceX05.Shot;
import SpaceX05.Template.Collision;
import SpaceX05.Template.ShotCollision;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class BasicShot  extends Shot implements ShootingStrategy, Commons {


    /**
     * TODO | DOING | DONE
     * DONE
     * default Constructor
     */
    @SuppressWarnings("SSDoc")
    public BasicShot(){
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor
     * @param x, y
     */
    @SuppressWarnings("SSDoc")
    public BasicShot(int x, int y){
        String shot = "/Images/BasicShot.png";
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(shot)));
        Image image = ii.getImage();
        Image newImage = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
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
            Collision collision = new ShotCollision();
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
        return 1;
    }

    @Override
    public Shot returnShot(){
        return this;
    }

}
