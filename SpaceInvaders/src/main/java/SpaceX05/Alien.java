package SpaceX05;

import SpaceX05.Visitor.Visitable;
import SpaceX05.Visitor.Visitor;

import javax.swing.*;
import java.awt.*;


public abstract class Alien extends Sprite implements  Cloneable, Visitable {


    public int id ;
    public int damagePoints;
    public int healthPoints ;
    public int PosX ;
    public int PosY;
    public String type;


    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    public Alien copyShallow( )
    {
        try {
            return (Alien)this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void setCoords(int posX, int posY) {
        this.PosX = posX;
        this.PosY = posY;
    }
}
