package SpaceX05.Adapter;

import SpaceX05.Sprite;
import java.awt.*;

public class BasicWall extends Sprite{
    /**
     * TODO | DOING | DONE
     * DONE
     * Constructor for BasicWall object
     * @param x, y, img
     */
    @SuppressWarnings("SSDoc")
    public BasicWall(int x, int y, Image img){
        setImage(img);
        setX(x);
        setY(y);
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Default constructor
     */
    @SuppressWarnings("SSDoc")
    public BasicWall(){
    }
}
