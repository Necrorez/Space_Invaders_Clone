package SpaceX05.Template;

import SpaceX05.Alien;
import SpaceX05.Shot;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static SpaceX05.Commons.ALIEN_HEIGHT;
import static SpaceX05.Commons.ALIEN_WIDTH;

public class PowerShotCollision extends Collision {

    @Override
    void gotHit(Object thisItem, Object nextItem) {
        Alien alien = (Alien) thisItem;
        Shot sprite = (Shot) nextItem;
        int X = sprite.getX();
        int Y = sprite.getY();
        int alienX = alien.PosX;
        int alienY = alien.PosY;
        if (alien.isVisible() && sprite.isVisible()) {
            if (X >= alienX && X <= (alienX + ALIEN_WIDTH) && Y >= (alienY) && Y <= (alienY + ALIEN_HEIGHT)) {
                hit = true;
            }
        }
    }


    @Override
    void doAction(Object first, Object second) {
        String explosion = "/Images/Explosion.png";
        Alien alien = (Alien) first;
        Shot sprite = (Shot) second;
        ImageIcon ii = new ImageIcon(Objects.requireNonNull(getClass().getResource(explosion)));
        Image image = ii.getImage();
        Image imageScaled = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ii = new ImageIcon(imageScaled);
        alien.setImage(ii.getImage());
        alien.setDying(true);
        sprite.die();
    }

}
