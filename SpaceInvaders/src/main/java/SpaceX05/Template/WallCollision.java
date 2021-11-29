package SpaceX05.Template;

import SpaceX05.Adapter.BasicWall;
import SpaceX05.Alien;
import SpaceX05.Sprite;

import static SpaceX05.Commons.ALIEN_HEIGHT;
import static SpaceX05.Commons.ALIEN_WIDTH;

public class WallCollision extends Collision{

    @Override
    void gotHit(Object item, Object nextItem) {
        Alien alien = (Alien) item;
        BasicWall sprite = (BasicWall) nextItem;
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
        BasicWall sprite = (BasicWall) second;
        alien.die();
        sprite.die();
    }
}
