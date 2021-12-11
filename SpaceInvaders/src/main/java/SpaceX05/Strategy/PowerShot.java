package SpaceX05.Strategy;

import SpaceX05.Alien;
import SpaceX05.Commons;
import SpaceX05.Player;
import SpaceX05.Iterator.AlienAndWallIterator;
import SpaceX05.Shot;
import SpaceX05.Template.PowerShotCollision;
import SpaceX05.Template.ShotCollision;
import SpaceX05.Template.Collision;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PowerShot  extends Shot implements ShootingStrategy, Commons {
    private final String shot = "/Images/PowerShot.png";
    private final String explosion = "/Images/Explosion.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;

    public PowerShot(){
    }
    public PowerShot(int x, int y){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(shot));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
    public PowerShot(String img){
        ImageIcon ii = new ImageIcon(this.getClass().getResource(img));
        Image image = ii.getImage();
        Image newimg = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        ii = new ImageIcon(newimg);
        setImage(ii.getImage());
    }
    public void setCoords(int x, int y)
    {
        setX(x + H_SPACE - 5);
        setY(y - V_SPACE);
    }
    @Override
    public int shoot(ArrayList<Alien> aliens, ArrayList<Player> players) {
        int kills = 0;
        AlienAndWallIterator it = new AlienAndWallIterator(aliens);

        while (it.hasNext()){
            Alien alien = (Alien) it.getNext();
            Collision collision = new PowerShotCollision();
            collision.checkHit(alien,this);
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
