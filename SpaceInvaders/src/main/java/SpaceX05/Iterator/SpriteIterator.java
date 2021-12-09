package SpaceX05.Iterator;

import SpaceX05.Sprite;

public interface SpriteIterator {
    boolean hasNext();

    Sprite getNext();

    void reset();

}
