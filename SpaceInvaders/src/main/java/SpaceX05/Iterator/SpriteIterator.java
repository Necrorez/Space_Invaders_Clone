package SpaceX05.Iterator;

import SpaceX05.Sprite;

public interface SpriteIterator {
    boolean hasNext();

    Sprite getNextAlien();
    Sprite getNextWall();

    void reset();

}
