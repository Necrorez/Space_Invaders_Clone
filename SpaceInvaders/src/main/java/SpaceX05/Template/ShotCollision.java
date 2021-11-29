package SpaceX05.Template;

import SpaceX05.Alien;
import SpaceX05.Shot;
import SpaceX05.Sprite;
import SpaceX05.Strategy.PowerShot;

import javax.swing.*;
import java.awt.*;

import static SpaceX05.Commons.ALIEN_HEIGHT;
import static SpaceX05.Commons.ALIEN_WIDTH;

public class ShotCollision extends Collision{
    @Override
    void gotHit(Object thisItem, Object nextItem) {
        Alien alien = (Alien) thisItem;
        Shot sprite = (Shot) nextItem;
        int X = sprite.getX();
        int Y = sprite.getY();
        int alienX = alien.PosX;
        int alienY = alien.PosY;
        if (alien.isVisible() && sprite.isVisible()){
            if(X >= alienX && X <= (alienX + ALIEN_WIDTH)&& Y >= (alienY) && Y <= (alienY + ALIEN_HEIGHT)){
                hit = true;
            }
        }

    }

    @Override
    void doAction(Object first, Object second) {
        Alien alien = (Alien) first;
        Shot sprite = (Shot) second;
        alien.die();
        sprite.die();
    }
}
