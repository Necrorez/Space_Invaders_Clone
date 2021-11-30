package SpaceX05;

import java.awt.*;

public class Sprite {
    private boolean visible;
    private Image image;
    protected int x;
    protected int y;
    protected boolean dying;
     int dx;
    /**
     * TODO | DOING | DONE
     * DONE
     * Sets sprite to visible
     * @param
     */
    @SuppressWarnings("SSDoc")
    public Sprite() {
        visible = true;
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * @return sprite visibility boolean
     */
    @SuppressWarnings("SSDoc")
    public boolean isVisible() { return visible;}
    /**
     * TODO | DOING | DONE
     * DONE
     * Sets sprite visibility to false
     */
    @SuppressWarnings("SSDoc")
    public void die() {
        visible = false;
    }
    /**
     * TODO | DOING | DONE
     * DONE
     * Sets the sprites' image to given image
     * @param image
     */
    @SuppressWarnings("SSDoc")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * returns the sprites' image
     * @return
     */
    @SuppressWarnings("SSDoc")
    public Image getImage() {
        return image;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Sets the sprites' x coordinates
     * @param x
     */
    @SuppressWarnings("SSDoc")
    public void setX(int x) {
        this.x = x;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Sets the sprites' y coordinates
     * @param x
     */
    @SuppressWarnings("SSDoc")
    public void setY(int y) {
        this.y = y;
    }


    /**
     * TODO | DOING | DONE
     * Returns the sprites' y coordinates
     * @return y
     */
    @SuppressWarnings("SSDoc")
    public int getY() {
        return y;
    }
    /**
     * TODO | DOING | DONE
     * Returns the sprites' x coordinates
     * @return x
     */
    @SuppressWarnings("SSDoc")
    public int getX() {
        return x;
    }


    /**
     * TODO | DOING | DONE
     * DONE
     * Sets the sprite as dying to give a delay for the animation of death
     * @param dying
     */
    @SuppressWarnings("SSDoc")
    public void setDying(boolean dying) {
        this.dying = dying;
    }

    /**
     * TODO | DOING | DONE
     * DONE
     * Returns boolean for the sprites' death
     * @return
     */
    @SuppressWarnings("SSDoc")
    public boolean isDying() {
        return this.dying;
    }

}
