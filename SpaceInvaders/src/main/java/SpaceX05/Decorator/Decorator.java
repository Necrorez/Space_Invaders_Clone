package SpaceX05.Decorator;
import SpaceX05.Alien;
import SpaceX05.Aliens.Crab;
import SpaceX05.Sprite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public abstract class Decorator extends Crab {
    protected Crab wrapee;

    public Decorator(Crab crab)
    {
        super(crab.PosX, crab.PosY);
        this.wrapee = crab;
    }

    public int getDamage()
    {
        return this.wrapee.getDamage();
    }

    public int getHealth()
    {
        return this.wrapee.getHealth();
    }

}
