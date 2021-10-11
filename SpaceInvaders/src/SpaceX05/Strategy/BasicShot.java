package SpaceX05.Shot;

import SpaceX05.Alien;
import SpaceX05.Commons;
import SpaceX05.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BasicShot  extends Sprite implements ShootingStrategy, Commons {
    private String shot = "/Images/BasicShot.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;

    public BasicShot(int x, int y){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(shot));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
        setX(x + H_SPACE - 5);
        setY(y - V_SPACE);
    }
    @Override
    public int shoot(ArrayList<Alien> aliens) {
        int kills = 0;
        Iterator it = aliens.iterator();
        int X = getX();
        int Y = getY();
        while (it.hasNext()){
            Alien alien = (Alien) it.next();
            int alienX = alien.PosX;
            int alienY = alien.PosY;
            if(X >= alienX && X <= (alienX + ALIEN_WIDTH)&& Y >= (alienY) && Y <= (alienY + ALIEN_HEIGHT)){
                alien.die();
                kills++;
                die();
            }
        }
        int y = getY();
        y -=4;
        if (y<0){
            die();
        }else{
            setY(y);
        }
        return kills;
    }

}
