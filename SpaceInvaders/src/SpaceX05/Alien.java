package SpaceX05;

import javax.swing.*;
import java.awt.*;

public abstract class Alien extends Sprite {

    public int id ;
    public int damagePoints;
    public int healthPoints ;
    public int PosX ;
    public int PosY;

    public int getDamage(){return this.damagePoints;}
    public int getHealth() {return this.healthPoints;}

}
