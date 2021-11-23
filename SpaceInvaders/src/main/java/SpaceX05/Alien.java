package SpaceX05;

import SpaceX05.Composite.GroupedAlien;

import javax.swing.*;
import java.awt.*;


public abstract class Alien extends Sprite implements  Cloneable, GroupedAlien {

    public int id ;
    public int damagePoints;
    public int healthPoints ;
    public int PosX ;
    public int PosY;


    public Alien copyShallow( )
    {
        try {
            return (Alien)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean isAlien() {
        return true;
    }
}
